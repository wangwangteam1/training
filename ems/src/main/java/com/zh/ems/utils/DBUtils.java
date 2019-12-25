package com.zh.ems.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	private static Properties properties=new Properties();
	
	private DBUtils() {}
	static {
		try {
			//读取db.properties文件
			InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
			//加入Properties集合中
			properties.load(is);
			//将读取到的数据赋值到程序中
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			user=properties.getProperty("username");
			password=properties.getProperty("password");
			//注册驱动
			Class.forName(driver);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 *调用该方法获取数据库连接对象
	 *@return 
	 */
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
}
