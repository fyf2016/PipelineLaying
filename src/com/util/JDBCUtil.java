package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCUtil {
	static final String DRIVER;
	static final String URL;
	static final String USER;
	static final String PASSWORD;
	private static ThreadLocal<Connection> th = new ThreadLocal<>();
	static{
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		DRIVER = bundle.getString("driver");
		URL = bundle.getString("url");
		USER = bundle.getString("user");
		PASSWORD = bundle.getString("password");
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static Connection getConnection()
	{
		Connection conn = th.get();
		if(conn==null)
		{
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				th.set(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn)
	{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(ps!=null)
		{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		if(conn!=null)
		{
			
			try {
				conn.close();
				th.remove();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
}
