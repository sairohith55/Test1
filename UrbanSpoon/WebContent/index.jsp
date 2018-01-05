

<div id="user_registration">
    <h3>User Register</h3>
    <form name="user_registration_form" action="UrbanspoonController" method="post">
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
