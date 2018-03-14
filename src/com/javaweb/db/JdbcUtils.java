package com.javaweb.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.activation.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	public static void relaseConnection(Connection connection){
		try {
			if (connection!=null) {
				connection.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static javax.sql.DataSource dataSource =null;
	static{
		dataSource=new ComboPooledDataSource("mvcApp");
	}
	public static Connection getConnection() throws SQLException{
			return dataSource.getConnection();
		}
}
