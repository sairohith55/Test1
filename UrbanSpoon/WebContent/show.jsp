<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
</head>
<body>
	<h1 align="center">${msg}</h1>
	<c:forEach var="feedback" items="${feedList}">
                	<div id="feed">
                	 	<div id="recipeDesc">
            	        	<%-- <h2 align="center"><c:out value="${feedback.user.name}" /></h2> --%>
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
</body>
</html>