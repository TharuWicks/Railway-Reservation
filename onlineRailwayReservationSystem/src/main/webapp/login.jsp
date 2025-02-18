<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/signup-style.css?v=1.1">
<title>Login</title>
</head>
<body>
<div id='container'>
  <div class='signup'>
     <form action="loginServlet" method="POST">
     	<input type="email" name="email" placeholder="Enter Your Email" required>
     	<input type="password" name="password" placeholder="Enter Your Password" required>
     	<input type="submit" value="Login">
     </form>
      <h2><a href="signup.jsp">SignUp</a></h2>
       <h2><a href="forgotPassword.jsp">Forgot Password?</a></h2>
  </div>
  <div class='whysignLogin'>
  	<h1>${msg}</h1>
    <h2>Online Train Ticket reservation System</h2>
    <p>By enabling consumers to explore, choose, and reserve tickets from any device, the Online Train Ticket Reservation System streamlines the booking process. It simplifies the process and guarantees hassle-free travel planning for travelers, whether for short commutes or lengthy trips, with secure payment choices and real-time seat availability.</p>
  </div>
</div>

</body>
</html>