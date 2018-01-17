import java.util.*;

import com.ts.urbanspoon.dao.BranchDAO;
import com.ts.urbanspoon.dao.CuisineDAO;
import com.ts.urbanspoon.dao.RecipeDAO;
import com.ts.urbanspoon.dto.*;
import com.ts.urbanspoon.service.UrbanSpoonService;

public class Test {

	public static void main(String[] args) {
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
		
		for(Restaurant r1:rest){
			System.out.println(r1.getName());
			for(Branch b:r1.getBranchesList()){
				System.out.println(b.getEmail());
				for(Cuisine c:b.getCuisinesList()){
					System.out.println(c.getName());
					for(Recipe r2:c.getRecipesList()){
						System.out.println(r2.getName());
					}
				}
			}
			System.out.println("------------------------");
		}
		
	}

}
