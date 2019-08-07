/**   
 * @Title: DateWithTime.java 
 * @Package com.dangdang.shardingjdbc.function 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年7月11日 下午4:26:06 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.function;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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
 * @ClassName: DateWithTime
 * @Description: TODO
 * @author yueling
 * @date 2018年7月11日 下午4:26:06
 * 
 */
public class DateWithTime extends AbstractFunction {

    private static final List<String> desc = new LinkedList<>();
    private static final String KEY = "__DateWithTime"; // 函数key，用于界面上选择函数

    static {
	desc.add(JMeterUtils.getResString("Date:yyyy-MM-dd")); // 函数助手中显示的参数说明，对应到参数
	desc.add(JMeterUtils.getResString("Time:HH:mm:ss"));
	desc.add(JMeterUtils.getResString("function_name_paropt"));// 保存函数返回结果的变量，用于引用
    }
    private CompoundVariable varName, date, time;

    @Override
    public List<String> getArgumentDesc() {
	return desc;
    }

    public DateWithTime() {
    }

    // 函数执行，返回结果
    @Override
    public String execute(SampleResult previousResult, Sampler currentSampler) throws InvalidVariableException {
	String dataTemp = date.execute().trim();
	String timeTemp = time.execute().trim();
	String data_time = dataTemp + timeTemp;
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
	Date date = null;
	try {
	    date = sdf1.parse(data_time);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
	String varTime = date.getTime() + "";
	if (varName != null) {
	    JMeterVariables vars = getVariables();
	    final String varTrim = varName.execute().trim();
	    if (vars != null && varTrim.length() > 0) {
		vars.put(varTrim, varTime);//
	    }
	}

	return varTime;

    }

    /** {@inheritDoc} */
    // 接收参数
    @Override
    public void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
	// 检查参数数量
	checkParameterCount(parameters, 2, 3);
	Object[] values = parameters.toArray();

	date = (CompoundVariable) values[0];
	time = (CompoundVariable) values[1];
	if (values.length > 2) {
	    varName = (CompoundVariable) values[2];
	} else {
	    varName = null;
	}
    }

    @Override
    public String getReferenceKey() {
	return KEY;
    }
}