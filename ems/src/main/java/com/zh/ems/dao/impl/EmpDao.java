package com.zh.ems.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zh.ems.dao.IEmpDao;
import com.zh.ems.pojo.Emp;
import com.zh.ems.utils.DBUtils;

public class EmpDao implements IEmpDao {

	@Override
	public Emp findEmpByNicknameAndPassword(String nickname, String password) {
		String sql = "select * from emp where nickname=? and password=?";

		// 1, 获取到链接数据库的对象
		Connection connection = DBUtils.getConnection();

		try {

			// 2, 获取到执行sql语句的预编译对象
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			// 3, 给sql中的占位符[?] 赋值
			prepareStatement.setString(1, nickname);
			prepareStatement.setString(2, password);

			// 4, 执行sql语句, 得到结果集
			ResultSet resultSet = prepareStatement.executeQuery();

			// 5, 如果有值, 则封装, 然后, 返回
			while (resultSet.next()) {
				// 获取数据库中对应的数据值
				int id = resultSet.getInt("id");
				String gender = resultSet.getString("gender");
				double salary = resultSet.getDouble("salary");
				// 把数据更到对象中
				Emp emp = new Emp(id, nickname, password, gender, salary);

				return emp;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 断开链接, 释放资源
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int findEmpBynickname(String nickname) {
		String sql = "select * from emp where nickname=?";
		// 1, 获取到链接数据库的对象
		Connection connection = DBUtils.getConnection();
		try {
			// 2, 获取到执行sql语句的预编译对象
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			// 3, 给sql中的占位符[?] 赋值
			prepareStatement.setString(1, nickname);
			// 4, 执行sql语句, 得到结果集
			ResultSet resultSet = prepareStatement.executeQuery();
			// 5, 如果有值, 则封装, 然后, 返回
			while (resultSet.next()) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 断开链接, 释放资源
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public void registerEmp(Emp emp) {
		String sql = "insert into emp values(null, ?, ?, ?, ?)";

		Connection connection = DBUtils.getConnection();

		try {
			// 获取到执行sql的对象
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			// 给占位符赋值
			prepareStatement.setString(1, emp.getNickname());
			prepareStatement.setString(2, emp.getPassword());
			prepareStatement.setString(3, emp.getGender());
			prepareStatement.setDouble(4, emp.getSalary());

			// 执行 增, 删, 改, 都是使用executeUpdate()方法
			prepareStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
