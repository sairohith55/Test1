package com.ts.urbanspoon.service;

import java.sql.Date;
import java.util.List;
import java.io.File;
import java.io.PrintWriter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.jni.*;
import org.apache.tomcat.util.http.fileupload.*;
import org.apache.tomcat.util.http.fileupload.disk.*;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.urbanspoon.dao.BranchDAO;
import com.ts.urbanspoon.dao.CuisineDAO;
import com.ts.urbanspoon.dao.FeedbackDAO;
import com.ts.urbanspoon.dao.RecipeDAO;
import com.ts.urbanspoon.dao.RestaurantDAO;
import com.ts.urbanspoon.dao.UserDAO;
import com.ts.urbanspoon.dto.Branch;
import com.ts.urbanspoon.dto.Cuisine;
import com.ts.urbanspoon.dto.Feedback;
import com.ts.urbanspoon.dto.Recipe;
import com.ts.urbanspoon.dto.Restaurant;
import com.ts.urbanspoon.dto.User;

public class UrbanSpoonService {
	private static final String IMAGESLOCATION = "D:\\urbanspoon\\UrbanSpoon\\WebContent\\images\\";
	private static int cuisionId; 
	public UrbanSpoonService() {
		// TODO Auto-generated constructor stub
	}

	public static List<Restaurant> getRestaurants() {
		// w.r.t query to get Top 10 Restaurants.

		List<Restaurant> restaurantsList = RestaurantDAO.getRestaurants();
		

		return restaurantsList;
	}
	
	

	public static void addUser(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		user.setName(request.getParameter("uName"));
		user.setGender(request.getParameter("gender"));
		user.setEmail(request.getParameter("eMail"));
		user.setMobileNo(Long.parseLong(request.getParameter("mNo")));
		user.setPassword(request.getParameter("pwd"));
		user.setDate(Date.valueOf(request.getParameter("dt")));
		
		UserDAO.insert(user);
	}

	public static void addRestaurant(List<FileItem> fileItemsList) {
		Restaurant rest = new Restaurant();
		String uploadPath =  IMAGESLOCATION+"restuarent";
				
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			
			if (fileItemsList != null && fileItemsList.size() > 0) {
	
				for (FileItem item : fileItemsList) {
					if(item.getFieldName().equals("rName")){
						rest.setName(item.getString());
					}
					if(item.getFieldName().equals("regId")){
						rest.setGovtRegistrationId(item.getString());
					}
					if(item.getFieldName().equals("pwd")){
						rest.setPassword(item.getString());
					}
				}
					rest = RestaurantDAO.insert(rest);
					int rId = rest.getId();
					String imgName=rId+".jpg";
					RestaurantDAO.updateLogoAddress(rId, imgName);
				for (FileItem item : fileItemsList) {
					if (item.getFieldName().equals("image")) {
						String filePath = uploadPath + File.separator +imgName;
						File storeFile = new File(filePath);
						item.write(storeFile);
						System.out.println("file uploaded successfully");
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("error in upload");
		}

	}

	public static String addRecipe(List<FileItem> fileItemsList) {
		Recipe recipe = new Recipe();
		String msg="";
		String fileUpload = IMAGESLOCATION+"recipes";
		File fileDir = new File(fileUpload);
		if(!fileDir.exists()){
			fileDir.mkdirs();
		}
		try {
			for (FileItem item : fileItemsList) {
				if(item.getFieldName().equals("recipeName")){
					recipe.setName(item.getString());	
				}if(item.getFieldName().equals("desc")){
					recipe.setDescription(item.getString());	
				}if(item.getFieldName().equals("recipeType")){
					recipe.setIsVeg(Integer.parseInt(item.getString()));
				}
			}
			recipe = RecipeDAO.insert(recipe);
			String imgName = recipe.getId()+".jpg";
			boolean isImgInserted = RecipeDAO.updateImage(recipe.getId(),imgName);
			if(isImgInserted){
				for (FileItem item : fileItemsList) {
					if(item.getFieldName().equals("recipeImage")){
						String filePath = fileUpload+File.separator+imgName;
						File storeFile = new File(filePath);
						item.write(storeFile);
						System.out.println("img stored in folder");
					}
				}
			}else{
				System.out.println("iamge not stored");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "recipe added successfully";
	}

	public static User getUser(HttpServletRequest request, HttpServletResponse response) {
		int userId= Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		User user= UserDAO.login(userId,password);
		return user;
	}

	public static Restaurant getRestaurant(HttpServletRequest request, HttpServletResponse response) {
		int restaurantId= Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		Restaurant restaurant = RestaurantDAO.login(restaurantId,password);
		return restaurant;
	}

	public static List<Feedback> getFeedback() {
		User user = new User();
		List<Feedback> feedList = FeedbackDAO.getFeedback();
		for (Feedback list : feedList) {
			user = UserDAO.getUser(list.getUser().getId());
			list.setUser(user);
		}
		return feedList;
	}
}
