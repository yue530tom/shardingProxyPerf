/**   
 * @Title: RandomUtilsTest.java 
 * @Package com.dangdang.shardingjdbc.utils 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:37:31 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.utils;

/** 
 * @ClassName: RandomUtilsTest 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月9日 下午5:37:31 
 *  
 */

import java.util.logging.Logger;

public class RandomUtilsTest {
    static Logger logger = Logger.getLogger("com.dangdang.com.shardingjdbc.utils.RandomUtilsTest");

    public static void main(String[] args) {
	logger.info(num2String(RandomUtils.getRandomDateRandom().longValue()));
	logger.info(num2String(RandomUtils.getRandomDefine().longValue()));
	logger.info(num2String(RandomUtils.getRandomDefineFix04_1().longValue()));
	logger.info(num2String(RandomUtils.getRandomDefineFix04().longValue()));
	for (int i = 0; i < 100; i++) {
	    logger.info(num2String(RandomUtils.getRangeRandom(30L, 50L).longValue()));
	}
    }

    public static String num2String(long srcNum) {
	return String.valueOf(srcNum);
    }
}
