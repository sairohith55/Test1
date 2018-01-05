package com.ts.urbanspoon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.ts.urbanspoon.exception.UrbanspoonException;

public class DAOUtility {

	public static Connection getConncetion() {
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/urbanspoon", "root", "root");
			System.out.println("**connection:"+connection);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}
	
	public static int getLatestId(String table) throws UrbanspoonException{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DAOUtility.getConncetion();
			statement = (Statement) connection.createStatement();
			resultSet = statement.executeQuery("select max(id) from "+table);
			if(resultSet.next()){
				return resultSet.getInt(1);
			}			
		} catch (SQLException e) {
			throw new UrbanspoonException(e.toString());
		} 
		return -1;
	}	

}
