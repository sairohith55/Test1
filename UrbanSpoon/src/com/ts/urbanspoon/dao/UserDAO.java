package com.ts.urbanspoon.dao;
import java.sql.*;
import com.ts.urbanspoon.dto.User;
import com.ts.urbanspoon.util.DAOUtility;

public class UserDAO {
	public static void insert(User user) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DAOUtility.getConnection();
			pst = con.prepareStatement("insert into user(name,gender,email,password,date_of_birth,mobile_number) values(?,?,?,?,?,?)");
			pst.setString(1, user.getName());
			pst.setString(2, user.getGender());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPassword());
			pst.setDate(5, (Date) user.getDate());
			pst.setLong(6,user.getMobileNo());
			pst.addBatch();
			if(pst.execute()==false){
				System.out.println(user.getName()+" registred successfully");
			}else
				System.out.println("User registration failed");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pst.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static User login(int id,String password){
		Connection con = null;
		PreparedStatement pst= null;
		ResultSet rs=null;
		User user = new User();
		try {
			con=DAOUtility.getConnection();
			pst = con.prepareStatement("select * from user where user_id=? and password=?");
			pst.setInt(1, id);
			pst.setString(2, password);
			pst.addBatch();
			rs = pst.executeQuery();
			if(rs.next()){
				do{
					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setEmail(rs.getString(4));
					user.setMobileNo(rs.getLong(7));
				}while(rs.next());
			}else{
				System.out.println("no user found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pst.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public static User getUser(int id) {
		Connection con = null;
		PreparedStatement pst= null;
		ResultSet rs=null;
		User user = new User();
		try {
			con=DAOUtility.getConnection();
			pst = con.prepareStatement("select * from user where user_id=?");
			pst.setInt(1, id);
			pst.addBatch();
			rs = pst.executeQuery();
			if(rs.next()){
				do{
					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setEmail(rs.getString(4));
					user.setMobileNo(rs.getLong(7));
				}while(rs.next());
			}else{
				System.out.println("no user found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DAOUtility.close(con,pst,rs);
		}
		return user;
	}
}
