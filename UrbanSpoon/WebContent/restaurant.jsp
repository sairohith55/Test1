<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>${currentRest.name}</title>
        <script src="changeImage.js"></script>  
        <link href="restaurant.css" rel="stylesheet"/>
    </head>
    <body>
        <div id="header">
        	Welcome ${currentRest.name}
            <div id="logout">
            	<button onclick="showHideImg('addBranch','block')">Add Branch</button>
                 <a href="/UrbanSpoon"> 
                    <button type="button" style="cursor: pointer" >logout </button>
                </a>
            </div>
        </div>
        <div id="body">
        <c:forEach var="restaurant" items="${restaurantsList}">
        	<c:if test="${restaurant.id==currentRest.id}">
        	<c:forEach var="branchList" items="${restaurant.branchesList}">
        	<div class="bodycol">
                <div class="res_img">
                	<c:forEach var="branchImg" items="${branchList.imagesList}">
                    	<img class="img ${branchList.id}" src="images/branch/${branchImg}" alt="Branch">
                    </c:forEach>
                    <button class="slide_butn_left l2" onclick="changeImage(-1,'${branchList.id}')">&#10094</button>
                    <button class="slide_butn_right r2" onclick="changeImage(1,'${branchList.id}')">&#10095</button>
                </div>
                <div class="feed">
                    <div class="rfed">
                        <img class="rimg"style="cursor: pointer"  onclick="showHideImg('recipeList','block')" src="images/symbols/rfed.png"/>
                        <img class="rimg" style="cursor: pointer"onclick="showHideImg('recipeFeed','block')"  src="images/symbols/feedback.png"/>
                    </div>
                </div>
            </div>
         	</c:forEach>
         	</c:if>
        </c:forEach>
        </div>
        <div id="footer">
        
        </div>
        <div id="popup"></div>
        <div id="recipeList">
             <div id="close">
                <img id="closeImg" style="cursor: pointer" src="images/symbols/close.png" height="100%" width="100%" onmouseover="colorImg('images/symbols/closered.png',this)"onclick="showHideImg('recipeList','none')" onmouseout="colorImg('images/symbols/close.png',this)"/>
            </div><br><br>
            <div id="recipeDetails">
                <div id="recipeDesc">
                    <img id="recipeImg" src="images/recipes/recipe-3.jpg" alt="recipe">
                     Roti (also known as chapati) is a flatbread originating from the Indian subcontinent, made from stoneground wholemeal flour.
                    
                </div>
                <div id="ratingrecipe">
                <div class="star">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                </div>
                </div>
            </div>
            <div id="recipeDetails">
                <div id="recipeDesc">
                    <img id="recipeImg" src="images/recipes/recipe-3.jpg" alt="recipe">
                     Roti (also known as chapati) is a flatbread originating from the Indian subcontinent, made from stoneground wholemeal flour.
                </div>
                <div id="ratingrecipe">
                <div class="star">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                </div>
                </div>
            </div>
            <div id="recipeDetails">
                <div id="recipeDesc">
                    <img id="recipeImg" src="images/recipes/recipe-3.jpg" alt="recipe">
                     Roti (also known as chapati) is a flatbread originating from the Indian subcontinent, made from stoneground wholemeal flour.
                </div>
                <div id="ratingrecipe">
                <div class="star">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                </div>
                </div>
            </div>
            <div id="recipeDetails">
                <div id="recipeDesc">
                    <img id="recipeImg" src="images/recipes/recipe-3.jpg" alt="recipe">
                     Roti (also known as chapati) is a flatbread originating from the Indian subcontinent, made from stoneground wholemeal flour.
                </div>
                <div id="ratingrecipe">
                <div class="star">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                </div>
                </div>
            </div>
            <div id="recipeDetails">
                <div id="recipeDesc">
                    <img id="recipeImg" src="images/recipes/recipe-3.jpg" alt="recipe">
                     Roti (also known as chapati) is a flatbread originating from the Indian subcontinent, made from stoneground wholemeal flour.
                </div>
                <div id="ratingrecipe">
                <div class="star">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                </div>
                </div>
            </div>
            <div id="recipeDetails">
                <img src="images/symbols/add.png" style="cursor: pointer" onclick="addRecipes('addRecipe','block')"  height="100%" width="100%"/>
            </div>
        </div>
        <div id="recipeFeed">
            <div id="close">
                <img id="closeImg" src="images/symbols/close.png" height="100%" width="100%" onmouseover="colorImg('images/symbols/closered.png',this)"onclick="showHideImg('recipeFeed','none')" onmouseout="colorImg('images/symbols/close.png',this)"/>
            </div><br>
            <div id="userFeed">
                <div id="feed">
                    <div id="recipeDesc">
                        <h2 align="center">Hanu</h2>
                        <p><b>Comment:</b>Food taste is good</p>
                        <p><b>posted date:</b>21-nov-2017</p>
                        <p><b>visited date:</b>25-nov-2017</p>
                    </div>
                    <div id="rating">
                <div class="star">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                </div>  
                    </div>
                </div>
                <div id="feed">
                    <div id="recipeDesc">
                        <h2 align="center">Hanu</h2>
                        <p><b>Comment:</b>Food taste is good</p>
                        <p><b>posted date:</b>21-nov-2017</p>
                        <p><b>visited date:</b>25-nov-2017</p>
                    </div>
                    <div id="rating">
                <div class="star">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                </div>  
                    </div>
                </div>
                <div id="feed">
                    <div id="recipeDesc">
                        <h2 align="center">Hanu</h2>
                        <p><b>Comment:</b>Food taste is good</p>
                        <p><b>posted date:</b>21-nov-2017</p>
                        <p><b>visited date:</b>25-nov-2017</p>
                    </div>
                    <div id="rating">
                <div class="star">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                </div>  
                    </div>
                </div>
                <div id="feed">
                    <div id="recipeDesc">
                        <h2 align="center">Hanu</h2>
                        <p><b>Comment:</b>Food taste is good</p>
                        <p><b>posted date:</b>21-nov-2017</p>
                        <p><b>visited date:</b>25-nov-2017</p>
                    </div>
                    <div id="rating">
                <div class="star">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                </div>  
                    </div>
                </div>
                <div id="feed">
                    <div id="recipeDesc">
                        <h2 align="center">Hanu</h2>
                        <p><b>Comment:</b>Food taste is good</p>
                        <p><b>posted date:</b>21-nov-2017</p>
                        <p><b>visited date:</b>25-nov-2017</p>
                    </div>
                    <div id="rating">
                <div class="star">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                    <img class="si" src="images/symbols/star.png">
                </div>  
                    </div>
                </div>
            </div>
        </div>
        
        <div id="addBranch" align="center">
            <div id="close">
                <img id="closeImg" src="images/symbols/close.png" height="100%" width="100%" onmouseover="colorImg('images/symbols/closered.png',this)"onclick="showHideImg('addBranch','none')" onmouseout="colorImg('images/symbols/close.png',this)"/>
            </div>
            <h2 align="center"><b>Add Branch</b></h2>
            <form action="UrbanSpoonController" method="post" enctype="multipart/form-data">
            	
            	
            	
            </form>
        </div>
         <div id="addRecipe" align="center">
             <div id="close">
                <img id="closeImg" src="images/symbols/close.png" height="100%" width="100%" onmouseover="colorImg('images/symbols/closered.png',this)"onclick="showHideImg('addRecipe','none')" onmouseout="colorImg('images/symbols/close.png',this)"/>
            </div>
            <h2 align="center"><b>Add recipe</b></h2>
            <form action="UrbanSpoonController" method="post" enctype="multipart/form-data">
            	<input type="hidden" name="action" value="addRecipe"/>
             <table style="border-spacing: 15px;">
                <tr><th><input type="text" placeholder="Recipe name" name="recipeName"/></th></tr>
                 <tr><th><input type="text" placeholder="Decscription" name="desc"/></th></tr>
                 <tr><th>Veg<input type="radio" name="recipeType" value="1"/>
                        Non veg<input type="radio" name="recipeType" value="0"/>
                    <select name="cusine">
                        <option>cusine</option>
                        <option value="North Indian" name="cusine">North-Indian</option>
                        <option value="South Indian" name="cusine">South-Indian</option>
                     </select>     
                </th></tr>
                <tr><th style="border: 1px solid black;"><input type="file" name="recipeImage"/></th></tr>
             </table>
             <input type="submit" id="send" align="center" value="send" style="cursor: pointer;"/>
            </form>
            </div>
    </body>
</html>