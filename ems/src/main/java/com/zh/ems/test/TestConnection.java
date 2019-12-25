package com.zh.ems.test;

import java.sql.Connection;

import com.zh.ems.utils.DBUtils;

public class TestConnection {
	public static void main(String[] args) {
		Connection connection=DBUtils.getConnection();
		System.out.println(connection);
	}
}
