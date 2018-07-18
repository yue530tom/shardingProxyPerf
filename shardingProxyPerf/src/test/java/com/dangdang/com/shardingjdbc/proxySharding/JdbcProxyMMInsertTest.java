/**   
 * @Title: JdbcProxyMMInsertTest.java 
 * @Package com.dangdang.com.shardingjdbc.proxy 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:20:21 
 * @version V1.0   
 */
package com.dangdang.com.shardingjdbc.proxySharding;

/** 
 * @ClassName: JdbcProxyMMInsertTest 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月9日 下午5:20:21 
 *  
 */
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;

import com.dangdang.com.shardingjdbc.proxySharding.JdbcProxyMMInsert;

public class JdbcProxyMMInsertTest {
    public static void main(String[] args) {
	Arguments params = new Arguments();

	JavaSamplerContext arg0 = new JavaSamplerContext(params);
	JdbcProxyMMInsert test = new JdbcProxyMMInsert();
	test.setupTest(arg0);
	for (int i = 0; i < 1; i++) {
	    test.runTest(arg0);
	}
	test.teardownTest(arg0);
    }
}
