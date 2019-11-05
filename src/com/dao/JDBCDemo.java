package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.User;
import com.mysql.jdbc.PreparedStatement;

public class JDBCDemo {
	public Connection getCon() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webproject", "root",
				"14026958");
		System.out.println(connection);
		return connection;

	}

	public int insertUser(User user) throws Exception {
		String sql = "insert into USER_TABLE value(?,?,?,?,?)";
		Connection connection = getCon();
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPassword());
		statement.setString(3, user.getSex());
		statement.setString(4, user.getEmail());
		statement.setString(5, user.getPhone());
		// 增删改，executeUpdate：查询executeQuery
		int result = statement.executeUpdate();
		if (result == 1) {
			System.out.println("success");
		} else {
			System.out.println("failed");
		}
		return result;

	}

	public boolean findByName(User user) throws Exception {
		String sql = "select *from USER_TABLE where USERNAME=?";
		Connection connection = getCon();
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
		statement.setString(1, user.getUsername());
		//接受查询的数据，ResultSet
		ResultSet resultSet = statement.executeQuery();
		Boolean flag = false;
		while(resultSet.next()) {
			flag = true;
		}
		return flag;
	}
	
	public boolean checkUser(User user) throws Exception {
		String sql = "select *from USER_TABLE where USERNAME=? and PASSWORD=?";
		Connection connection = getCon();
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPassword());
		//接受查询的数据，ResultSet
		ResultSet resultSet = statement.executeQuery();
		Boolean flag = false;
		while(resultSet.next()) {
			flag = true;
		}
		return flag;
	}

	public static void main(String[] args) throws Exception {
		JDBCDemo jdbcDemo = new JDBCDemo();
		User user = new User();
		user.setUsername("xxxxxx");
		user.setPassword("xxxxxx");
		user.setSex("xxxxxx");
		user.setEmail("xxxxxx");
		user.setPhone("xxxxxx");
		jdbcDemo.insertUser(user);
		
		
		
	}
}
