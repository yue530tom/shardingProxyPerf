/**   
 * @Title: CreateSeqForCRUDTest.java 
 * @Package com.dangdang.shardingjdbc.utils 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月15日 下午7:36:06 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.utils;

/** 
 * @ClassName: CreateSeqForCRUDTest 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月15日 下午7:36:06 
 *  
 */
public class CreateSeqForCRUDTest {
    public static void main(String[] args) {
	for (int i = 0; i < 10; i++) {
	    System.err.println(CreateSeqForCRUD.getRangeId());
	}
	
    }
}
