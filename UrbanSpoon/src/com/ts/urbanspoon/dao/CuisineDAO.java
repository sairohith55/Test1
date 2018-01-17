package com.ts.urbanspoon.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ts.urbanspoon.dto.Cuisine;
import com.ts.urbanspoon.util.DAOUtility;

public class CuisineDAO {

	public static int getCuisine() {
		int cuisineId=0;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null; 
		try {
			con = DAOUtility.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from cuisine");
			while(rs.next()){
				cuisineId = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cuisineId;
	}


	public static List<Cuisine> getCuisinesList() {
		List<Cuisine> l= new ArrayList<>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null; 
		try {
			con = DAOUtility.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from cuisine");
			while(rs.next()){
				Cuisine c = new Cuisine();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setCountry(rs.getString(3));
				
				l.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return l;
	}

	 

}
