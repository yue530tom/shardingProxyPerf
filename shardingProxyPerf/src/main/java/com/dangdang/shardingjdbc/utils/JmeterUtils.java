/**   
 * @Title: JmeterUtils.java 
 * @Package com.dangdang.shardingjdbc.utils 
 * @Description: TODO
 * @author yueling yueling@dangdang.com
 * @date 2018年5月9日 下午5:25:59 
 * @version V1.0   
 */
package com.dangdang.shardingjdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** 
 * @ClassName: JmeterUtils 
 * @Description: TODO
 * @author yueling 
 * @date 2018年5月9日 下午5:25:59 
 *  
 */

import com.dangdang.com.shardingjdbc.utils.entry.ResponseInfo;
import com.dangdang.com.shardingjdbc.utils.entry.TOrderObject;

public class JmeterUtils {
    public static void closeConStmt(PreparedStatement stmt, Connection con) {
	if (stmt != null) {
	    try {
		stmt.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	if (con != null) {
	    try {
		con.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
    }

    public static ResponseInfo jdbcProxyInsert(PreparedStatement stmt, Connection con, ResponseInfo responseInfo,
	    TOrderObject tOrderObject) throws SQLException {
	stmt = con.prepareStatement("INSERT INTO t_order(order_id,status,user_id,ip) values (?, 'insert',?, ?);");
	stmt.setLong(1, tOrderObject.getOrder_id());
	stmt.setInt(2, tOrderObject.getUser_id());
	stmt.setInt(3, tOrderObject.getIp());
	responseInfo = assertExecuteUpdate(stmt, responseInfo);
	responseInfo.setResultMsg(tOrderObject.getOrder_id() + " " + responseInfo.getResultMsg());
	return responseInfo;
    }

    public static void jdbcProxyAssertExecuteQueryByOrderId(PreparedStatement stmt, Connection con,
	    TOrderObject tOrderObject) throws SQLException {
	stmt = con.prepareStatement("select order_id,status,user_id,ip from t_order where order_id=? and user_id=?");
	stmt.setLong(1, tOrderObject.getOrder_id());
	stmt.setInt(2, tOrderObject.getUser_id());
	ResultSet resultSet = stmt.executeQuery();
	while (resultSet.next()) {
	    System.err.println("查询order_id=" + resultSet.getString("order_id"));
	}
    }

    public static ResponseInfo jdbcProxySelect(PreparedStatement stmt, Connection con, ResponseInfo responseInfo,
	    TOrderObject tOrderObject) throws SQLException {
	stmt = con.prepareStatement("select order_id,status,user_id,ip from t_order where order_id=? and user_id=?;");
	stmt.setLong(1, tOrderObject.getOrder_id());
	stmt.setInt(2, tOrderObject.getUser_id());

	responseInfo = assertExecute(stmt, responseInfo);
	responseInfo.setResultMsg(tOrderObject.getOrder_id() + " " + responseInfo.getResultMsg());
	return responseInfo;
    }

    public static void jdbcProxyAssertExecuteQueryById(PreparedStatement stmt, Connection con,
	    TOrderObject tOrderObject) throws SQLException {
	stmt = con.prepareStatement("select order_id from t_order where order_id=? and user_id=?");
	stmt.setLong(1, tOrderObject.getOrder_id());
	stmt.setInt(2, tOrderObject.getUser_id());
	ResultSet resultSet = stmt.executeQuery();
	while (resultSet.next()) {
	    System.err.println("查询 Order_id=" + resultSet.getString("order_id"));
	}
    }

    public static ResponseInfo jdbcProxyUpdate(PreparedStatement stmt, Connection con, ResponseInfo responseInfo,
	    TOrderObject tOrderObject) throws SQLException {
	stmt = con.prepareStatement("update t_order SET status='update' where order_id=? and user_id=?;");
	stmt.setLong(1, tOrderObject.getOrder_id());
	stmt.setInt(2, tOrderObject.getUser_id());

	responseInfo = assertExecuteUpdate(stmt, responseInfo);
	responseInfo.setResultMsg(tOrderObject.getOrder_id() + " " + responseInfo.getResultMsg());
	return responseInfo;
    }

    public static ResponseInfo assertExecuteUpdate(PreparedStatement stmt, ResponseInfo responseInfo)
	    throws SQLException {
	int result = stmt.executeUpdate();
	if (result == 0) {
	    responseInfo.setResultMsg("fail");
	} else {
	    responseInfo.setResultMsg("success");
	}
	return responseInfo;
    }

    public static ResponseInfo assertExecute(PreparedStatement stmt, ResponseInfo responseInfo) throws SQLException {
	Boolean result = Boolean.valueOf(stmt.execute());
	if (!result.booleanValue()) {
	    responseInfo.setResultMsg("fail");
	} else {
	    responseInfo.setResultMsg("success");
	}
	return responseInfo;
    }
}
