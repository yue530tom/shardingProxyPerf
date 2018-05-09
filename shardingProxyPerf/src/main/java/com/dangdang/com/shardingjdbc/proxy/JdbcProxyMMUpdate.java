/**   
 * @Title: JdbcProxyMMUpdate.java 
 * @Package com.dangdang.com.shardingjdbc.proxy 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:21:09 
 * @version V1.0   
 */
package com.dangdang.com.shardingjdbc.proxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

import javax.sql.DataSource;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;



import com.dangdang.com.shardingjdbc.utils.conf.Configuration;
import com.dangdang.com.shardingjdbc.utils.entry.ResponseInfo;
import com.dangdang.com.shardingjdbc.utils.entry.TOrderObject;
import com.dangdang.shardingjdbc.utils.DataSourceFactoryProxy;
import com.dangdang.shardingjdbc.utils.JmeterUtils;
import com.dangdang.shardingjdbc.utils.TOrderObjectFactory;

/** 
 * @ClassName: JdbcProxyMMUpdate 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月9日 下午5:21:09 
 *  
 */
public class JdbcProxyMMUpdate extends AbstractJavaSamplerClient{
    static AtomicLong seq = new AtomicLong();
    JdbcProxyMMUpdate jdbcProxyMMUpdate = null;
    DataSource dataSource = null;
    Connection con = null;
    PreparedStatement stmt = null;
    ResponseInfo responseInfo = null;

    public Arguments getDefaultParameters() {
	Arguments params = new Arguments();

	return params;
    }

    public void setupTest(JavaSamplerContext arg0) {
	DataSourceFactoryProxy.init();
	DataSourceFactoryProxy.initJdbcDataSource();
	this.dataSource = DataSourceFactoryProxy.instance("db");
	this.responseInfo = new ResponseInfo();
	this.jdbcProxyMMUpdate = new JdbcProxyMMUpdate();
    }

    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
	SampleResult sr = new SampleResult();
	sr.setSampleLabel("JdbcProxy Update");
	try {
	    sr.sampleStart();
	    this.responseInfo = this.jdbcProxyMMUpdate.execute(this.dataSource);
	    sr.setResponseData("JdbcProxy Update:" + this.responseInfo.getResultMsg(), null);
	    if (Configuration.needTestOrNot.booleanValue()) {
		System.out.println("JdbcProxy Update:" + this.responseInfo.getResultMsg());
	    }
	    sr.setDataType("text");
	    sr.setSuccessful(true);
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    sr.sampleEnd();
	}
	return sr;
    }

    public ResponseInfo execute(DataSource dataSource) throws SQLException {
	ResponseInfo rI = new ResponseInfo();
	TOrderObject tOrderObject = fitObject();
	try {
	    this.con = dataSource.getConnection();
	    if (Configuration.needTestOrNot.booleanValue()) {
		JmeterUtils.jdbcProxyAssertExecuteQueryById(this.stmt, this.con, tOrderObject);
	    }
	    JmeterUtils.jdbcProxyUpdate(this.stmt, this.con, rI, tOrderObject);
	    if (Configuration.needTestOrNot.booleanValue()) {
		JmeterUtils.jdbcProxyAssertExecuteQueryById(this.stmt, this.con, tOrderObject);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    JmeterUtils.closeConStmt(this.stmt, this.con);
	}
	return rI;
    }

    public TOrderObject fitObject() {
	return TOrderObjectFactory.getSelectUpdateObj();
    }
}
