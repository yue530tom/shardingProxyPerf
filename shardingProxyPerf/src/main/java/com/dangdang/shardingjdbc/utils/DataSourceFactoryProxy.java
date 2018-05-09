/**   
 * @Title: DataSourceFactoryProxy.java 
 * @Package com.dangdang.shardingjdbc.utils 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:25:15 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/** 
 * @ClassName: DataSourceFactoryProxy 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月9日 下午5:25:15 
 *  
 */

import com.dangdang.com.shardingjdbc.utils.conf.Configuration;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

public class DataSourceFactoryProxy {
    private static Map<String, DataSource> dateSourceMap = new HashMap<String, DataSource>();
    public static DataSource[] dataSources = new DataSource[Configuration.numOfDatabases + 1];
    public static Connection[] cons = new Connection[Configuration.numOfDatabases + 1];

    public static DataSource[] initJdbcDataSource() {
	dataSources[0] = instance("db");
	dataSources[1] = instance("db0");
	dataSources[2] = instance("db1");
	return dataSources;
    }

    public static DataSource instance(String key) {
	return (DataSource) dateSourceMap.get(key);
    }

    public static void init() {
	dateSourceMap.put("db", initDataSource(PropKit.use("db.properties")));
	dateSourceMap.put("db0", initDataSource(PropKit.use("db0.properties")));
	dateSourceMap.put("db1", initDataSource(PropKit.use("db1.properties")));
    }

    public static Connection[] getJDBCConnect() {
	init();
	initJdbcDataSource();
	for (int i = 0; i < cons.length; i++) {
	    try {
		cons[i] = dataSources[i].getConnection();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return cons;
    }

    private static DataSource initDataSource(Prop databaseConfig) {
	BasicDataSource dataSource = new BasicDataSource();
	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	dataSource.setUsername(databaseConfig.get("userName"));
	dataSource.setPassword(databaseConfig.get("password"));
	dataSource.setUrl(databaseConfig.get("url"));
	dataSource.setMinIdle(databaseConfig.getInt("minIdle").intValue());
	dataSource.setMaxActive(databaseConfig.getInt("maxActive").intValue());
	dataSource.setMaxWait(databaseConfig.getInt("maxWait").intValue());
	return dataSource;
    }
}
