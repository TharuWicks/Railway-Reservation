<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup-style.css?v=1.1">
<title>ForgotPassword</title>
</head>
<body>
<div id='container'>
  <div class='signup'>
     <form action="forgotPasswordServlet" method="POST">
     	<input type="email" name="email" placeholder="Enter Your Email">
     	<input type="number" name="mobileNumber" placeholder="Enter Your Mobile Number">
     	<select name="sequrityQuestion" required>
    		<option value="what was your first car">What as your first car?</option>
    		<option value="what is the name of your first pet">what is the name of your first pet?</option>
    		<option value="what is the name of your town where you were born">what is the name of your town where you were born?</option>
    	</select>
    	<input type="text" name="answer" placeholder="Enter Your Answer" required>
    	<input type="password" name="newPassword" placeholder="Enter Your New Password" required>
    	<input type="submit" value="Save">
     
     </form>
      <h2><a href="login.jsp">Login</a></h2>
  </div>
  <div class='whyforgotPassword'>
  <h1>${message}</h1>
    <h2>Online Car Rental</h2>
    <p>The Online Cars Rental System is the application that allows the users to booking online without going to the shops.</p>
  </div>
</div>
</body>
</html>