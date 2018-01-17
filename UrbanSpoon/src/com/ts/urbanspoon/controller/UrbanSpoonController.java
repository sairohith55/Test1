package com.ts.urbanspoon.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ts.urbanspoon.dao.BranchDAO;
import com.ts.urbanspoon.dao.CuisineDAO;
import com.ts.urbanspoon.dao.FeedbackDAO;
import com.ts.urbanspoon.dao.RecipeDAO;
import com.ts.urbanspoon.dto.Branch;
import com.ts.urbanspoon.dto.Cuisine;
import com.ts.urbanspoon.dto.Feedback;
import com.ts.urbanspoon.dto.Recipe;
import com.ts.urbanspoon.dto.Restaurant;
import com.ts.urbanspoon.dto.User;
import com.ts.urbanspoon.service.UrbanSpoonService;

@WebServlet("/UrbanSpoonController")
public class UrbanSpoonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String msg = "";
	public UrbanSpoonController() {
		// TODO Auto-generated constructor stub
		System.out.println("***UrbanSpoonController object is created..");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 
		List<Restaurant> rest=UrbanSpoonService.getRestaurants();
		List<Cuisine> cuisine_list=new ArrayList<>();
		List<Recipe> r = new ArrayList<>();
		for (Restaurant restaurant : rest) {
			List<Branch> branchesList = BranchDAO.getBranches(restaurant.getId());
			restaurant.setBranchesList(branchesList);
			for (Branch branch : branchesList) {
				List<String> imagesList = BranchDAO.getBranchImages(branch.getId());
				cuisine_list = CuisineDAO.getCuisinesList();
				branch.setImagesList(imagesList);
				branch.setCuisinesList(cuisine_list);
				for(Cuisine c: cuisine_list){
					r =RecipeDAO.getRecipes(branch.getId(), c.getId());
					c.setRecipesList(r);	
				}
			}	
		}
		for (Restaurant r1 : rest) {
			System.out.println(r1);
		}
		
		request.setAttribute("restaurantsList",rest);
		request.getRequestDispatcher("home.jsp").forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> fileItemsList=upload.parseRequest(request);
				for (FileItem item : fileItemsList) {
					if(item.getFieldName().equals("action")){
						if(item.getString().equals("restRegForm")){
							UrbanSpoonService.addRestaurant(fileItemsList);
						}if(item.getString().equals("addRecipe")){
							String msg = UrbanSpoonService.addRecipe(fileItemsList);
							request.setAttribute("msg", msg);
							request.getRequestDispatcher("show.jsp").forward(request, response);
						}
					}
				}
			} catch (Exception e) {
				System.out.println("error in controller");
			}
		
		}else if(action.equals("userRegForm")){
			UrbanSpoonService.addUser(request, response);
		}else if(action.equals("login")){
			
			List<Feedback> FeedbackList = UrbanSpoonService.getFeedback();
			request.setAttribute("feedList",FeedbackList );
			List<Restaurant> rest=UrbanSpoonService.getRestaurants();
			request.setAttribute("restaurantsList",rest);
			
			
			String type = request.getParameter("person");
			if(type.equals("user")){
				User user = UrbanSpoonService.getUser(request,response);
				if(user.getName()!=null){
					request.setAttribute("userName", user.getName());
					request.getRequestDispatcher("user.jsp").include(request, response);
				}else{
					request.setAttribute("msg", "Invalid user id or password");
					request.getRequestDispatcher("show.jsp").include(request, response);
				}
			}else if(type.equals("restaurant")){
				Restaurant restaurant = UrbanSpoonService.getRestaurant(request,response);
				if(restaurant.getName()!=null){
					request.setAttribute("currentRest", restaurant);
					request.getRequestDispatcher("restaurant.jsp").include(request, response);
				}else{
					request.setAttribute("msg", "Invalid restaurant id or password");
					request.getRequestDispatcher("show.jsp").include(request, response);
				}
			}
		}
	}

}
