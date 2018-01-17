<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>${userName}</title>
        <script src="changeImage.js"></script>
        <link href="user.css" rel="stylesheet"/>
    </head>
    <body>
        <div id="header">
            <div class="rtitle">
                <p> Welcome ${userName}</p>
            </div>
            <div id="buttion">
                <a href="/UrbanSpoon"> 
                    <button type="button" style="cursor: pointer;" >logout </button>
                </a>
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
                                <img class="mi" src="images/symbols/feedback.png"onclick="showHideImg('recipeFeed','block')"/>
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
                <div class="resp">
                <div class="col_recipe" style="margin-right:1px;">
                    <img class="img ${recipe.name}" src="images/recipes/${recipe.imageName}" alt="recipe"> 
                </div>
                <div class="col_recipe" style="margin-left: 1%">
                    <div class="rdesc">
                        <div class="recipe_desc">
                            Roti (also known as chapati) is a flatbread originating from the Indian subcontinent, made from stoneground wholemeal flour, traditionally known as atta, that originated and is consumed in India
                        </div>
                        <div class="reipe-rating">
                             <div class="more">
                                <img class="mi" src="images/symbols/feedback.png"onclick="showHideImg('recipeFeed','block')"/>
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
            </div>
            </c:forEach>
        </div>
        </div>
        <div id="footer">
        
        </div>
        <div id="popup"></div>
        <div id="recipeFeed">
            <div id="close">
                <img id="closeImg" src="images/symbols/close.png" height="100%" width="100%" onmouseover="colorImg('images/symbols/closered.png',this)"onclick="showHideImg('recipeFeed','none')" onmouseout="colorImg('images/symbols/close.png',this)"/>
            </div><br>
            <div id="userFeed">
				<c:forEach var="feedback" items="${feedList}">
                	<div id="feed">
                	 	<div id="recipeDesc">
            	        	<h2 align="center"><c:out value="${feedback.user.name}" /></h2>
        	                <p><b>Comment:</b><c:out value="${feedback.comments}" /></p>
    	                    <p><b>posted date:</b><c:out value="${feedback.feedbackDate}" /></p>
	                        <p><b>visited date:</b><c:out value="${feedback.visitedDate}" /></p>
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
				</c:forEach>
            </div>
        </div>
    </body>
</html>