<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurant registration</title>
</head>
<body>
	<div id="restaurantReg" align="center">
		<h2 align="center">Restaurant Register</h2>
		<form name="restReg" action="UrbanSpoonController" method="post">
			<input type="hidden" name="action" value="restRegForm">
        	<input type="text" name="rName" placeholder="restaurant name" required/><br><br>
            <input type="text" name="regId" placeholder="Govt reg id" required/><br><br>
            <input type="password"name="pwd" placeholder="password" required/><br><br>
            <input type="file" value="upload" required/><br><br>
            <input type="submit" value="Register"/>  
	  </form>
</div>
</body>
</html>