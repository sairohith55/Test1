package com.ts.urbanspoon.dao;

import java.sql.*;
import java.util.*;

import com.ts.urbanspoon.dto.Recipe;
import com.ts.urbanspoon.util.DAOUtility;

 

public class RecipeDAO {
	
	
	
	public static List<Recipe> getRecipes(int branch_id, int cuisine_id){
		 //wrt query to get recipes.
		Connection con=null;
		Statement st = null;
		ResultSet rs = null;
		List<Recipe> recipeList = new ArrayList();
		try {
			con = DAOUtility.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select distinct r.*,s.price,s.image_name from recipe r, serve s where r.recipe_id=s.recipe_id and branch_id = "+branch_id+" and cuisine_id = "+cuisine_id);
			if (rs.next()) {
				do {
					Recipe recipe = new Recipe();
					recipe.setId(rs.getInt(1));
					recipe.setName(rs.getString(2));
					recipe.setDescription(rs.getString(3));
					recipe.setIsVeg(rs.getInt(5));
					recipe.setPrice(rs.getFloat(6));
					recipe.setImageName(rs.getString(7));
					recipeList.add(recipe);
				} while (rs.next());
			} else {
				System.out.println("no record found in recipe");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DAOUtility.close(con,st,rs);
		}
		return recipeList;
	}

	public static Recipe insert(Recipe recipe) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = DAOUtility.getConnection();
			pst = con.prepareStatement("insert into recipe(name,description,is_Veg) values(?,?,?)");
			pst.setString(1, recipe.getName());
			pst.setString(2, recipe.getDescription());
			pst.setInt(4, recipe.getIsVeg());
			pst.addBatch();
			if(!pst.execute()){
				System.out.println("Recipe inserted successfully");
				int recipeId = DAOUtility.getLatestId("recipe", "recipe_id");
				recipe.setId(recipeId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pst.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return recipe;
	}

	public static boolean updateImage(int id, String imgName) {
		Connection con=null;
		Statement st = null;
		boolean result=false;
		try {
			con = DAOUtility.getConnection();
			st = con.createStatement();
			result = !st.execute("update recipe set recipe_image='"+imgName+"' where recipe_id="+id);
			if(result){
				System.out.println("image inserted successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}	 
}
