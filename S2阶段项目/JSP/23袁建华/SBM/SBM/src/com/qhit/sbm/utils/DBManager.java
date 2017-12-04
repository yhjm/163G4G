package com.qhit.sbm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	private static Connection con = null;
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=db_sbm";
	
	public static Connection getConnection(){
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, "sa", "123456");
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}
	
	public static void close(PreparedStatement ps,ResultSet rs ,Connection con){
		try {
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
