package com.ts.urbanspoon.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.ts.urbanspoon.dto.*;
import com.ts.urbanspoon.util.DAOUtility;

public class RestaurantDAO {
	
	
	
	public static List<Restaurant> getRestaurants(){
		 //w.r.t query to get Top 10 Restaurants.
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Restaurant> restaurant = new ArrayList<Restaurant>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/urbanspoon","root","root");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from restaurant");
			if(resultSet.next()) {
				do{
					Restaurant rs = new Restaurant();
					rs.setId(resultSet.getInt(1));
					rs.setGovtRegistrationId(resultSet.getString(2));
					rs.setName(resultSet.getString(3));
					rs.setLogoName(resultSet.getString(5));
					restaurant.add(rs);
				}while (resultSet.next());
			}else
				System.out.println("No records found");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				statement.close();
				resultSet.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return restaurant;
	}

	public static Restaurant insert(Restaurant rest) {
		Connection con = null;
		PreparedStatement pst = null;
		int restId=0;
		try {
			con=DAOUtility.getConnection();
			pst=con.prepareStatement("insert into restaurant(govt_registration_id,name,password) values(?,?,?)");
			pst.setString(1, rest.getGovtRegistrationId());
			pst.setString(2, rest.getName());
			pst.setString(3, rest.getPassword());
			pst.addBatch();
			if(pst.execute()==false){
				restId = DAOUtility.getLatestId("restaurant","restaurant_id");
				rest.setId(restId);
				System.out.println(rest.getName()+" registred successfully");
			}else
				System.out.println("Registration failed");
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
		return rest;
	}

	public static void updateLogoAddress(int id, String logoName) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con=DAOUtility.getConnection();
			pst = con.prepareStatement("update restaurant set logo_name=? where restaurant_id=?");
			pst.setString(1, logoName);
			pst.setInt(2, id);
			pst.addBatch();
			if(pst.execute()==false){
				System.out.println("image updated successfully");
			}else
				System.out.println("img updation failed");
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

	public static Restaurant login(int restaurantId, String password) {
		Connection con = null;
		PreparedStatement pst= null;
		ResultSet rs=null;
		Restaurant restaurant = new Restaurant();
		try {
			con=DAOUtility.getConnection();
			pst = con.prepareStatement("select * from restaurant where restaurant_id=? and password=?");
			pst.setInt(1, restaurantId);
			pst.setString(2, password);
			pst.addBatch();
			rs = pst.executeQuery();
			if(rs.next()){
				do{
					restaurant.setId(rs.getInt(1));
					restaurant.setGovtRegistrationId(rs.getString(2));
					restaurant.setName(rs.getString(3));
					restaurant.setPassword(rs.getString(4));
					restaurant.setLogoName(rs.getString(5));
					
				}while(rs.next());
			}else{
				System.out.println("no restaurant found");
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
		return restaurant;

	}
}
