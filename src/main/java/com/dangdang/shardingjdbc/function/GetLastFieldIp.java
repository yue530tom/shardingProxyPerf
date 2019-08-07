/**   
 * @Title: GetLastFieldIp.java 
 * @Package com.dangdang.shardingjdbc.function 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年7月11日 下午4:20:27 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.function;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;
import org.apache.jmeter.threads.JMeterVariables;
import org.apache.jmeter.util.JMeterUtils;

/**
 * @ClassName: GetLastFieldIp
 * @Description: TODO
 * @author yueling
 * @date 2018年7月11日 下午4:20:27
 * 
 */
public class GetLastFieldIp extends AbstractFunction {

    private static final List<String> desc = new LinkedList<>();
    private static final String KEY = "__GetLastFieldIp"; // 函数key，用于界面上选择函数

    static {
	desc.add(JMeterUtils.getResString("function_name_paropt"));// 保存函数返回结果的变量，用于引用
    }
    private CompoundVariable varName;

    /*
     * (非 Javadoc) <p>Title: getArgumentDesc</p> <p>Description: </p>
     * 
     * @return
     * 
     * @see org.apache.jmeter.functions.Function#getArgumentDesc()
     */
    @Override
    public List<String> getArgumentDesc() {
	// TODO Auto-generated method stub
	return desc;
    }

    /*
     * (非 Javadoc) <p>Title: execute</p> <p>Description: </p>
     * 
     * @param arg0
     * 
     * @param arg1
     * 
     * @return
     * 
     * @throws InvalidVariableException
     * 
     * @see org.apache.jmeter.functions.AbstractFunction#execute(org.apache.jmeter.
     * samplers.SampleResult, org.apache.jmeter.samplers.Sampler)
     */
    @Override
    public String execute(SampleResult arg0, Sampler arg1) throws InvalidVariableException {
	// TODO Auto-generated method stub
	String ip=String.valueOf(getip());
	if (varName != null) {
	    JMeterVariables vars = getVariables();
	    final String varTrim = varName.execute().trim();
	    if (vars != null && varTrim.length() > 0) {
		vars.put(varTrim, ip);//
	    }
	}
	return ip;
    }

    /*
     * (非 Javadoc) <p>Title: getReferenceKey</p> <p>Description: </p>
     * 
     * @return
     * 
     * @see org.apache.jmeter.functions.AbstractFunction#getReferenceKey()
     */
    @Override
    public String getReferenceKey() {
	// TODO Auto-generated method stub
	return KEY;
    }

    /*
     * (非 Javadoc) <p>Title: setParameters</p> <p>Description: </p>
     * 
     * @param arg0
     * 
     * @throws InvalidVariableException
     * 
     * @see org.apache.jmeter.functions.AbstractFunction#setParameters(java.util.
     * Collection)
     */
    @Override
    public void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
	// TODO Auto-generated method stub
	checkParameterCount(parameters, 0, 1);
	Object[] values = parameters.toArray();

	if (values.length > 0) {
	    varName = (CompoundVariable) values[0];
	} else {
	    varName = null;
	}

    }

    public static int getip() {
	try {
	    String address = InetAddress.getLocalHost().getHostAddress();
	    return Integer.parseInt(address.substring(address.lastIndexOf('.') + 1));
	} catch (UnknownHostException e) {
	    e.printStackTrace();
	}
	return 0;
    }
}
