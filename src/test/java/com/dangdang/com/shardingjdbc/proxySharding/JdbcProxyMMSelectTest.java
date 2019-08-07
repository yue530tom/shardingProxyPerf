/**   
 * @Title: JdbcProxyMMSelectTest.java 
 * @Package com.dangdang.com.shardingjdbc.proxy 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:22:03 
 * @version V1.0   
 */
package com.dangdang.com.shardingjdbc.proxySharding;

/** 
 * @ClassName: JdbcProxyMMSelectTest 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月9日 下午5:22:03 
 *  
 */
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;

import com.dangdang.com.shardingjdbc.proxySharding.JdbcProxyMMSelect;

public class JdbcProxyMMSelectTest {
    public static void main(String[] args) {
	Arguments params = new Arguments();

	JavaSamplerContext arg0 = new JavaSamplerContext(params);
	JdbcProxyMMSelect test = new JdbcProxyMMSelect();
	test.setupTest(arg0);
	for (int i = 0; i < 10; i++) {
	    test.runTest(arg0);
	}
	test.teardownTest(arg0);
    }
}
