/**   
 * @Title: CreateSeqForCRUD.java 
 * @Package com.dangdang.shardingjdbc.utils 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:24:27 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.utils;

import java.sql.SQLException;
import java.util.logging.Logger;

/** 
 * @ClassName: CreateSeqForCRUD 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月9日 下午5:24:27 
 *  
 */

import com.dangdang.com.shardingjdbc.utils.entry.TableInfoObject;

public class CreateSeqForCRUD {
    static Logger logger = Logger.getLogger("com.dangdang.com.shardingjdbc.utils.CreateSeqForCRUD");
    
    
    /**
     * 说明为什么要设计3个变量：
     * 	3个标记分别对应3中场景获取序号，如果用统一的变量，在综合场景可能会在某些极端的情况影响刚开的结果
     */
    public static String uniqIdFirstFlag = null;
    public static String rangeIdFirstFlag = null;
    public static String minIdFirstFlag = null;
    
    public static String tmpSeq = "0";
    public static long initId = 0L;
    public static long minId = 0L;
    public static long maxId = 0L;

    public static long getUniqId() {
	if (uniqIdFirstFlag == null) {
	    logger.info("getUniqId first times");
	    String ipStr = Integer.toString(FormatSeqUtils.getip());
	    try {
		if (GetTableInfo.getTableMinMaxRowGroupByIp().get(ipStr) == null) {
		    initId = 0L;
		} else {
		    uniqIdFirstFlag = ipStr;
		    initId = ((TableInfoObject) GetTableInfo.getTableMinMaxRowGroupByIp().get(uniqIdFirstFlag)).getMax();
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	if (initId != 0L) {
	    tmpSeq = String.valueOf(initId).substring(uniqIdFirstFlag.length() + 1);
	}
	return Long.valueOf(tmpSeq).longValue() + FormatSeqUtils.getSeqId();
    }

    public static long getRangeId() {
	if (rangeIdFirstFlag == null) {
	    logger.info("getRangeId first time");
	    String ipStr = Integer.toString(FormatSeqUtils.getip());
	    try {
		if (GetTableInfo.getTableMinMaxRowGroupByIp().get(ipStr) != null) {
		    rangeIdFirstFlag = ipStr;
		    minId = ((TableInfoObject) GetTableInfo.getTableMinMaxRowGroupByIp().get(rangeIdFirstFlag)).getMaxSeq();
		    maxId = ((TableInfoObject) GetTableInfo.getTableMinMaxRowGroupByIp().get(rangeIdFirstFlag)).getMinSeq();
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	if ((minId != 0L) && (maxId != 0L)) {
	    return FormatSeqUtils.getSeqId(RandomUtils.getRangeRandom(maxId, minId));
	}
	return 0L;
    }

    public static long getMinId() {
	if (minIdFirstFlag == null) {
	    logger.info("getMinId first time");
	    String ipStr = Integer.toString(FormatSeqUtils.getip());
	    try {
		if (GetTableInfo.getTableMinMaxRowGroupByIp().get(ipStr) != null) {
		    minIdFirstFlag = ipStr;
		    minId = ((TableInfoObject) GetTableInfo.getTableMinMaxRowGroupByIp().get(minIdFirstFlag)).getMinSeq();
		    maxId = ((TableInfoObject) GetTableInfo.getTableMinMaxRowGroupByIp().get(minIdFirstFlag)).getMaxSeq();
		}
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	long tempId = minId + FormatSeqUtils.getSeqId() - 1L;
	if (Long.valueOf(String.valueOf(tempId).substring(minIdFirstFlag.length() + 1)).longValue() <= maxId) {
	    return tempId;
	}
	return 0L;
    }
}
