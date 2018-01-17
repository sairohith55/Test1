<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Home page</title>
        <script src="changeImage.js"></script>
        <link href="styles.css" rel="stylesheet"/>
        <link href="homepage.css" rel="stylesheet"/>
       
    </head>
    <body>
        <div id="header"> 
            <div id="button">
                 <button id='b1' onclick="showHideImg('loginform','block')">Login</button>
                 <button id='b1' onclick="showHideImg('userRegform','block')">User</button>
                 <button id='b1' onclick="showHideImg('restaurantRegform','block')">Restaurant</button>
            </div>
        </div>
        <div id="body">
            <div class="col" >
            <c:forEach var="restaurant" items="${restaurantsList}">
               <div class="Restuarent">
                    <div class="Restuarent_title">
                        <div class="rtitle">
                            <p><c:out value="${restaurant.name}"/></p>
                        </div>
                        <div class="r_logo">
                            <img class="rlogo" src="images/restuarent/${restaurant.logoName}" alt="logo">
                        </div>
                    </div>
                    <c:forEach var="branchList" items="${restaurant.branchesList}">
                    <div class="branch">
                        <div class="branch_images">
                        	<c:forEach var="branchImagesList" items="${branchList.imagesList}">
                            	<img class="img ${branchList.id}" src="images/branch/${branchImagesList}" alt="Branch">
                            </c:forEach>
                           <button class="slide_butn_left l2" onclick="changeImage(-1,'${branchList.id}')">&#10094</button>
                            <button class="slide_butn_right r2" onclick="changeImage(1,'${branchList.id}')">&#10095</button>
                        </div>
                        <div class="feedback">
                        <div class="rating" style="margin-right: 4px;">
                          <c:out value="${branchList.location}"/>
                        </div>
                        <div class="rating">
                            <div class="more">
                                <img class="mi" src="images/symbols/more.png">
                            </div>
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
                    </c:forEach>
                </div> 
             </c:forEach>
            </div>
            <div class="col">
    			<c:forEach var="recipe" items="${recipesList}">
    			<div class="col_recipe" style="margin-right:1px;">
                    <img class="img ${recipe.name}" src="images/recipes/${recipe.imageName}" alt="recipe"> 
                </div>
                <div class="col_recipe" style="margin-left: 1%">
                    <div>
                        <div class="recipe_desc">
                           <b>Recipe Name:</b><c:out value="${recipe.name}"/>
                           <p><b>Discription:</b><c:out value="${recipe.description}"/></p>
                        </div>
                        <div class="reipe-rating">
                             <div class="more">
                                <img class="mi" src="images/symbols/more.png">
                            </div>
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
    			</c:forEach>
            </div>
        </div>
        <div id="footer">
            
        </div>
         <div id="popup"></div>
        <div id="loginform" align="center">
            <div id="close">
                <img id="closeImg" src="images/symbols/close.png" height="100%" width="100%" onmouseover="colorImg('images/symbols/closered.png',this)" onclick="showHideImg('loginform','none')" onmouseout="colorImg('images/symbols/close.png',this)"/>
            </div><br><br>
            <div id="loginImg">
                <img src="images/symbols/user_login.png" height="100%" width="100%"/>
            </div>
            <div class="f1" align="center">
            <form id="loginform1" action="UrbanSpoonController" method="post"><br>
            	<input type="hidden" value="login" name="action"/><br>
                <input type="text" placeholder="enter Id" name="id" required/><br><br>
                <input type="password" placeholder="password"name="password" required/><br><br>
                <input type="radio" name="person" value="user"required />User
                <input type="radio" name="person" value="restaurant" required/>Restaurant<br><br>
                <input type="submit" value="login"/>
            </form>   
        </div>
        </div>
        <div id="userRegform">
            <div id="close">
                <img id="closeImg" src="images/symbols/close.png" height="100%" width="100%" onmouseover="colorImg('images/symbols/closered.png',this)"onclick="showHideImg('userRegform','none')" onmouseout="colorImg('images/symbols/close.png',this)"/>
            </div><br><br>
            <div class="f1" align="center">
            <form name="userReg" action="UrbanSpoonController" method="post">
				
				<input type="hidden" name="action" value="userRegForm"><br>
        		<input type="text" name="uName" placeholder="user name" required/><br><br>
            	<input type="radio" name="gender" value="M" />Male
            	<input type="radio" name="gender" value="F"/>Female<br><br>
            	<input type="email" name="eMail"placeholder="email" required/><br><br>
            	<input type="number" name="mNo" placeholder="mobile number" required/><br><br>
            	<input type="password"name="pwd" placeholder="password" required/><br><br>
            	<input type="date"name="dt" placeholder="date of birth(yyyy-mm-dd)" required/><br><br>
            	<input type="submit" id="button2" value="Register"/>  
  			</form>   
        </div>
        </div>
        <div id="restaurantRegform">
            <div id="close">
                <img id="closeImg" src="images/symbols/close.png" height="100%" width="100%" onmouseover="colorImg('images/symbols/closered.png',this)"onclick="showHideImg('restaurantRegform','none')" onmouseout="colorImg('images/symbols/close.png',this)"/>
            </div><br><br>
     <div class="f1" align="center">
				<form name="restReg" action="UrbanSpoonController" method="post" enctype="multipart/form-data">
					<input type="hidden" name="action" value="restRegForm"><br>
        			<input type="text" name="rName" placeholder="restaurant name" required/><br><br>
            		<input type="text" name="regId" placeholder="Govt reg id" required/><br><br>
            		<input type="password"name="pwd" placeholder="password" required/><br><br>
            		<input type="file" value="upload" name="image" required/><br><br>
            		<input type="submit" value="Register"/>  
	  			</form>        
	  		</div>
    </div>
    </body>
</html>