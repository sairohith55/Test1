package com.ts.urbanspoon.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ts.urbanspoon.dto.User;
import com.ts.urbanspoon.exception.UrbanspoonException;
import com.mysql.jdbc.PreparedStatement;
import com.ts.urbanspoon.dto.Branch;
import com.ts.urbanspoon.dto.Restaurant;
import com.ts.urbanspoon.util.DAOUtility;
 
 

public class UserDAO {

	public static User insertUser(User u) throws UrbanspoonException{
		Connection con = null;
		java.sql.PreparedStatement stmt = null;
		User u1 = new User();

		try {
			con = DAOUtility.getConncetion();
			String query = "insert into user values(?,?,?,?,?)";
			System.out.println("------>query is:" + query);
			stmt=con.prepareStatement(query);
			
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getGender());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getPassword());
			stmt.setLong(5, u.getMobileNo());
			if (stmt.executeUpdate() > 0) {
				u.setId(DAOUtility.getLatestId("user"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		return u;

	}
}
