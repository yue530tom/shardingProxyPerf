/**   
 * @Title: FormatSeqUtilsTest.java 
 * @Package com.dangdang.shardingjdbc.utils 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:36:42 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.utils;

/** 
 * @ClassName: FormatSeqUtilsTest 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月9日 下午5:36:42 
 *  
 */
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class FormatSeqUtilsTest {
    static Logger logger = Logger.getLogger("com.dangdang.com.shardingjdbc.utils.FormatSeqUtilsTest");

    public static void main(String[] args) throws UnknownHostException {
	for (int i = 0; i < 10; i++) {
	    logger.info(String.valueOf(CreateSeqForCRUD.getRangeId()));
	}
    }
}