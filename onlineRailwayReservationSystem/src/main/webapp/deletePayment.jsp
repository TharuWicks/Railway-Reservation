<%@page import="project.ConnectionProvider" %>
<%@page import="java.sql.*" %>
<%@include file="adminHeader.jsp" %>
<%@include file="footer.jsp" %>

<html>
<head>
<link rel="stylesheet" href="css/addNewProduct-style.css">
<title>Delete Vehicle</title>
<style>
.back
{
  color: white;
  margin-left: 2.5%
}
</style>
</head>
<body>
 <h2><a class="back" href="allPayment.jsp"><i class='fas fa-arrow-circle-left'> Back</i></a></h2>
<%
String id=request.getParameter("id");
try{
	Connection con=ConnectionProvider.getCon();
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from payment where id='"+id+"'");
	while(rs.next()){

%>

<form action="deletePaymentServlet" method="POST">
<input type="hidden" name="id" value="<%out.println(id); %>">
<div class="left-div">
 <h3>Name</h3>
 <input class="input-style" type="text" name="name" value="<%=rs.getString(2) %>" readonly>

<hr>
</div>

<div class="right-div">
<h3>Category</h3>
 <input class="input-style" type="text" name="catagory" value="<%=rs.getString(3) %>" readonly>
<hr>
</div>

<div class="left-div">
<h3>Amount</h3>
 <input class="input-style" type="number" name="amount" value="<%=rs.getString(4) %>" readonly>
<hr>
</div>

<div class="right-div">
<h3>Valid</h3>
<select class="input-style" name="valid">
	<option value="yes">Yes</option>
	<option value="no">No</option>
</select>
 <hr>
</div>
 <button class="button">Delete <i class='far fa-arrow-alt-circle-right'></i></button>
 </form>
 
<%
}}catch(Exception e){
	System.out.print(e);
}
%>


</body>
<br><br><br>
</body>
</html>