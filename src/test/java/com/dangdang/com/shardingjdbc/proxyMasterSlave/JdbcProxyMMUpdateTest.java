/**   
 * @Title: JdbcProxyMMUpdateTest.java 
 * @Package com.dangdang.com.shardingjdbc.proxy 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:21:48 
 * @version V1.0   
 */
package com.dangdang.com.shardingjdbc.proxyMasterSlave;

/** 
 * @ClassName: JdbcProxyMMUpdateTest 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月9日 下午5:21:48 
 *  
 */

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;


public class JdbcProxyMMUpdateTest {
    public static void main(String[] args) {
	Arguments params = new Arguments();

	JavaSamplerContext arg0 = new JavaSamplerContext(params);
	JdbcProxyMMUpdate test = new JdbcProxyMMUpdate();
	test.setupTest(arg0);
	for (int i = 0; i < 10; i++) {
	    test.runTest(arg0);
	}
	test.teardownTest(arg0);
    }
}
