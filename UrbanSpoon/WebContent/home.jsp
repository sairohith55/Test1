<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ts.urbanspoon.dto.*"%>


<table border="1">


	<c:forEach var="restList" items="${rl}">
		<tr>
			<td><c:out value="${restList.id}" /></td>
			<td><c:out value="${restList.govtRegistrationId}" /></td>
			<td><c:out value="${restList.name}" /></td>
			<td><c:out value="${restList.logoName}" /></td>


			<c:forEach var="branchList" items="${restList.branchesList}">

				<td><c:out value="${branchList.id}" /></td>
				<td><c:out value="${branchList.location}" /></td>
				<td><c:out value="${branchList.city}" /></td>
				<td><c:out value="${branchList.state}" /></td>
				<td><c:out value="${branchList.country}" /></td>
				<td><c:out value="${branchList.postalCode}" /></td>
				<td><c:out value="${branchList.email}" /></td>
				<td><c:out value="${branchList.mobileNo}" /></td>

			</c:forEach>

		</tr>
	</c:forEach>



</table>
<div id="user_registration">
    <h3>User Register</h3>
    <form name="user_registration_form" action="UrbanspoonController">
        <input type="hidden" name="action" value="user_registration">

        <input type="text" name="firstName" placeholder="Enter FirstName"
            required /><br> <input type="text" name="lastName"
        placeholder="Enter LastName" required /><br> <input
                type="radio" name="gender" value="Male" />Male <input type="radio"
            name="gender" value="Female" />Female<br> <br> <input
            type="email" name="email" placeholder="Enter Email" required /><br>
        <br> <input type="password" name="password"
            placeholder="Enter Password" required /><br> <br> <input
            type="date" name="date" /> <input type="number" name="mobileNumber"
            placeholder="Enter MobileNumber" required /><br> <br> <input
            type="submit" value="register">
    </form>

</div>
