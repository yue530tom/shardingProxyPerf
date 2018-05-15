/**   
 * @Title: GetProperties.java 
 * @Package com.dangdang.shardingjdbc.utils 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月14日 下午6:19:19 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.utils;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

/**
 * @ClassName: GetProperties
 * @Description: TODO
 * @author yueling
 * @date 2018年5月14日 下午6:19:19
 * 
 */
public class GetProperties {
    public static String getMode() {
	Prop prop=PropKit.use("conf.properties");
	return "db"+prop.get("mode");
    }
}
