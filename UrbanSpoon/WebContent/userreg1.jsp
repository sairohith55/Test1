<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User register</title>
</head>
<body>
	<div id="userReg" align="center">
		<h2 align="center">User Register</h2>
		<form name="userReg" action="UrbanSpoonController" method="post">
		<input type="hidden" name="action" value="userRegForm">
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
</body>
</html>