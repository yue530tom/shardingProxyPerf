/**   
 * @Title: GetTableInfo.java 
 * @Package com.dangdang.shardingjdbc.utils 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:25:46 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.dangdang.com.shardingjdbc.utils.entry.TableInfoObject;

public class GetTableInfo {
    static Logger logger = Logger.getLogger("com.dangdang.com.shardingjdbc.utils.GetTableInfo");

    public static HashMap<String, TableInfoObject> getTableMinMaxRowGroupByIpExp() throws SQLException {
	DataSource dataSource = null;
	Connection con = null;
	PreparedStatement stmt = null;
	long minId = 0L;
	long maxId = 0L;
	HashMap<String, TableInfoObject> tableInfo = new HashMap<String, TableInfoObject>();

	// 做判断是分片还是主从
	//DataSourceFactoryProxy.init();
	dataSource = DataSourceFactoryProxy.initDataSource();
	con = dataSource.getConnection();
	stmt = con
		.prepareStatement("SELECT min(order_id) as minId,max(order_id) as maxId,ip FROM t_order GROUP BY ip;");
	ResultSet result = stmt.executeQuery();
	while (result.next()) {
	    TableInfoObject tableInfoObject = new TableInfoObject();
	    minId = result.getLong("minId");
	    maxId = result.getLong("maxId");
	    if (tableInfo.containsKey(result.getString("ip"))) {
		TableInfoObject tempTableInfoObject = (TableInfoObject) tableInfo.get(result.getString("ip"));
		tableInfoObject.setMax(tempTableInfoObject.getMax());
		tableInfoObject.setMin(tempTableInfoObject.getMin());
		if (tempTableInfoObject.getMin() > minId) {
		    tableInfoObject.setMin(minId);
		}
		if (tempTableInfoObject.getMax() < maxId) {
		    tableInfoObject.setMax(maxId);
		}
	    } else {
		tableInfoObject.setMin(minId);
		tableInfoObject.setMax(maxId);
	    }
	    tableInfo.put(result.getString("ip"), tableInfoObject);
	}
	return formatTableMinMaxRowGroupByIp(tableInfo);
    }

    public static HashMap<String, TableInfoObject> formatTableMinMaxRowGroupByIp(
	    HashMap<String, TableInfoObject> tableInfo) {
	Iterator<Map.Entry<String, TableInfoObject>> iter = tableInfo.entrySet().iterator();
	while (iter.hasNext()) {
	    Map.Entry<String, TableInfoObject> entry = (Entry<String, TableInfoObject>) iter.next();

	    ((TableInfoObject) entry.getValue())
		    .setMaxSeq(Long.valueOf(String.valueOf(((TableInfoObject) entry.getValue()).getMax())
			    .substring(((String) entry.getKey()).length())).longValue());
	    ((TableInfoObject) entry.getValue())
		    .setMinSeq(Long.valueOf(String.valueOf(((TableInfoObject) entry.getValue()).getMin())
			    .substring(((String) entry.getKey()).length())).longValue());
	}
	return tableInfo;
    }
}
