/**   
 * @Title: DataSourceFactoryProxy.java 
 * @Package com.dangdang.shardingjdbc.utils 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:25:15 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.utils;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

public class DataSourceFactoryProxy {
    private static Map<String, DataSource> dateSourceMap = new HashMap<String, DataSource>();

    public static DataSource initDataSource() {
	init();
	return instance("db");
    }

    public static DataSource instance(String key) {
	return (DataSource) dateSourceMap.get(key);
    }

    public static void init() {
	dateSourceMap.put("db", initDataSource(PropKit.use("db.properties")));
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
