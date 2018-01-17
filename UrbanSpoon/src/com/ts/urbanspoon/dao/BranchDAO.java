package com.ts.urbanspoon.dao;

import java.util.ArrayList;
import java.util.List;

import com.ts.urbanspoon.dto.Branch;
import com.ts.urbanspoon.util.DAOUtility;

import java.sql.*;
public class BranchDAO {
	
	public static List<Branch> getBranches(int restaurantId){
		 Connection con = null;
		 Statement st = null;
		 ResultSet rs = null;
		 List<Branch> branches = new ArrayList<Branch>();
		 try {
			con = DAOUtility.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from branch where restaurant_id="+restaurantId);
			if(rs.next()){
				System.out.println("records found in branch");
				do {
					Branch b = new Branch();
					b.setId(rs.getInt(1));
					b.setLocation(rs.getString(2));
					b.setCity(rs.getString(3));
					b.setState(rs.getString(4));
					b.setCountry(rs.getString(5));
					b.setPostalCode(rs.getInt(6));
					b.setEmail(rs.getString(7));
					b.setMobileNo(rs.getLong(8));
					branches.add(b);
				} while (rs.next());
			}else{
				System.out.println("No records found in branch");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return branches;
		}
		
	}

	public static List<String> getBranchImages(int id) {
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		List<String> imagesList = new ArrayList<>();
		try {
			con = DAOUtility.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from branch_image where branch_id = "+id);
			if(rs.next()){
				do {
					imagesList.add(rs.getString(2));
				} while (rs.next());
			}else{
				System.out.println("no branch img found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DAOUtility.close(con,st,rs);
		}
		return imagesList;
	}
	 
	
}
