/**   
 * @Title: TOrderObjectFactory.java 
 * @Package com.dangdang.shardingjdbc.utils 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:26:24 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.utils;

/** 
 * @ClassName: TOrderObjectFactory 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月9日 下午5:26:24 
 *  
 */

import com.dangdang.com.shardingjdbc.utils.entry.TOrderObject;

public class TOrderObjectFactory {
    public static long getInserId() {
	return CreateSeqForCRUD.getUniqId();
    }

    public static long getSelectUpdateId() {
	return CreateSeqForCRUD.getRangeId();
    }

    public static long getDeleteId() {
	return CreateSeqForCRUD.getMinId();
    }

    public static TOrderObject geTOrderObject() {
	TOrderObject tOrderObject = new TOrderObject();
	tOrderObject.setIp(FormatSeqUtils.decimalAddr);
	return tOrderObject;
    }

    public static TOrderObject getInsertObj() {
	long tempOrderId = CreateSeqForCRUD.getUniqId();

	TOrderObject tOrderObject = new TOrderObject();

	tOrderObject.setOrder_id(tempOrderId);
	tOrderObject.setUser_id((int) (tempOrderId % 2L));
	tOrderObject.setIp(FormatSeqUtils.decimalAddr);

	return tOrderObject;
    }

    public static TOrderObject getSelectUpdateObj() {
	long tempOrderId = CreateSeqForCRUD.getRangeId();

	TOrderObject tOrderObject = new TOrderObject();

	tOrderObject.setOrder_id(tempOrderId);
	tOrderObject.setUser_id((int) (tempOrderId % 2L));
	tOrderObject.setIp(FormatSeqUtils.decimalAddr);

	return tOrderObject;
    }

    public static TOrderObject getDeleteObj() {
	long tempOrderId = CreateSeqForCRUD.getMinId();

	TOrderObject tOrderObject = new TOrderObject();

	tOrderObject.setOrder_id(tempOrderId);
	tOrderObject.setUser_id((int) (tempOrderId % 2L));
	tOrderObject.setIp(FormatSeqUtils.decimalAddr);

	return tOrderObject;
    }
}
