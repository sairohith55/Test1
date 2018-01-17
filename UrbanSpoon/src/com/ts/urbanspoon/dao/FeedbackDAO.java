package com.ts.urbanspoon.dao;

import java.util.*;
import java.sql.*;

import com.ts.urbanspoon.dto.Branch;
import com.ts.urbanspoon.dto.Feedback;
import com.ts.urbanspoon.dto.Recipe;
import com.ts.urbanspoon.dto.User;
import com.ts.urbanspoon.util.DAOUtility;

public class FeedbackDAO {

	public static List<Feedback> getFeedback() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Feedback> feedList = new ArrayList<Feedback>();
		try {
			con = DAOUtility.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from feedback");
			if(rs.next()){
				do{
					Feedback fb = new Feedback();
					User user = new User();
					Branch branch = new Branch();
					Recipe recipe = new Recipe();
					fb.setId(rs.getInt(1));
					user.setId(rs.getInt(2));
					fb.setUser(user);
					branch.setId(rs.getInt(3));
					fb.setBranch(branch);
					recipe.setId(rs.getInt(5));
					fb.setRecipe(recipe);
					fb.setFeedbackDate(rs.getDate(6));
					fb.setVisitedDate(rs.getDate(7));
					fb.setComments(rs.getString(8));
					fb.setRatings(rs.getInt(9));
					feedList.add(fb);
				}while(rs.next());
			}else{
				System.out.println("no feed back found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DAOUtility.close(con,st,rs);
		}
		return feedList;
	}
	 
}
