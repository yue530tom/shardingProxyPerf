/**   
 * @Title: GetTableInfoTest.java 
 * @Package com.dangdang.shardingjdbc.utils 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:37:02 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.utils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

/** 
 * @ClassName: GetTableInfoTest 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月9日 下午5:37:02 
 *  
 */
import com.dangdang.com.shardingjdbc.utils.entry.TableInfoObject;

public class GetTableInfoTest {
    static Logger logger = Logger.getLogger("com.dangdang.com.shardingjdbc.utils.GetTableInfoTest");

    public static void main(String[] args) throws SQLException {
/*	HashMap<String, TableInfoObject> resultHashMap = GetTableInfo.getTableMinMaxRowGroupByIpExp();

	Iterator<Map.Entry<String, TableInfoObject>> iter = resultHashMap.entrySet().iterator();

	while (iter.hasNext()) {
	    Map.Entry<String, TableInfoObject> entry = (Entry<String, TableInfoObject>) iter.next();

	    logger.info("ip:" + (String) entry.getKey() + "\tmin:" + ((TableInfoObject) entry.getValue()).getMin()
		    + "\tmax:" + ((TableInfoObject) entry.getValue()).getMax() + "\tminSeq:"
		    + ((TableInfoObject) entry.getValue()).getMinSeq() + "\tmaxSeq:"
		    + ((TableInfoObject) entry.getValue()).getMaxSeq());
	}*/
	
	HashMap<String, TableInfoObject> resultHashMap1=GetTableInfo.tableInfo;
	Iterator<Map.Entry<String, TableInfoObject>> iter1 = resultHashMap1.entrySet().iterator();
	while (iter1.hasNext()) {
	    Map.Entry<String, TableInfoObject> entry = (Entry<String, TableInfoObject>) iter1.next();

	    logger.info("ip:" + (String) entry.getKey() + "\tmin:" + ((TableInfoObject) entry.getValue()).getMin()
		    + "\tmax:" + ((TableInfoObject) entry.getValue()).getMax() + "\tminSeq:"
		    + ((TableInfoObject) entry.getValue()).getMinSeq() + "\tmaxSeq:"
		    + ((TableInfoObject) entry.getValue()).getMaxSeq());
	}
	resultHashMap1=GetTableInfo.tableInfo;
	iter1 = resultHashMap1.entrySet().iterator();
	while (iter1.hasNext()) {
	    Map.Entry<String, TableInfoObject> entry = (Entry<String, TableInfoObject>) iter1.next();

	    logger.info("ip:" + (String) entry.getKey() + "\tmin:" + ((TableInfoObject) entry.getValue()).getMin()
		    + "\tmax:" + ((TableInfoObject) entry.getValue()).getMax() + "\tminSeq:"
		    + ((TableInfoObject) entry.getValue()).getMinSeq() + "\tmaxSeq:"
		    + ((TableInfoObject) entry.getValue()).getMaxSeq());
	}
	resultHashMap1=GetTableInfo.tableInfo;
	iter1 = resultHashMap1.entrySet().iterator();
	while (iter1.hasNext()) {
	    Map.Entry<String, TableInfoObject> entry = (Entry<String, TableInfoObject>) iter1.next();

	    logger.info("ip:" + (String) entry.getKey() + "\tmin:" + ((TableInfoObject) entry.getValue()).getMin()
		    + "\tmax:" + ((TableInfoObject) entry.getValue()).getMax() + "\tminSeq:"
		    + ((TableInfoObject) entry.getValue()).getMinSeq() + "\tmaxSeq:"
		    + ((TableInfoObject) entry.getValue()).getMaxSeq());
	}
    }
}
