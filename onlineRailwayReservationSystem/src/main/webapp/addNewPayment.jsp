<%@ page import="project.ConnectionProvider" %>
<%@ page import="java.sql.*" %>
<%@ include file="adminHeader.jsp" %>
<%@ include file="footer.jsp" %>
<html>
<head>
    <link rel="stylesheet" href="css/addNewProduct-style.css?v=1.1">
    <title>Add New Payment</title>
</head>
<body>
<div class="displayMsg">
	<h1>Add New Payment</h1>
    <h1>${message}</h1> <!-- Display success or error message -->
</div>
<%
int id=1;
try{
    Connection con=ConnectionProvider.getCon();
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select max(id) from payment");
    while(rs.next()){
        id=rs.getInt(1);
        id=id+1;
    }
}catch(Exception e){

}
%>
<form action="addNewPaymentServlet" method="POST">
    <h3 style="color: yellow;">Payment ID: <%= id %></h3>
    <input type="hidden" name="id" value="<%= id %>">

    <div class="left-div">
        <h3>Enter Name</h3>
        <input class="input-style" type="text" name="name" placeholder="Enter Name" required>
        <hr>
    </div>

    <div class="right-div">
        <h3>Enter Category</h3>
        <input class="input-style" type="text" name="category" placeholder="Enter Category" required>
        <hr>
    </div>

    <div class="left-div">
        <h3>Enter Amount</h3>
        <input class="input-style" type="text" name="amount" placeholder="Enter Amount" required>
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
    <button class="button">Save <i class='far fa-arrow-alt-circle-right'></i></button>
</form>
</body>
<br><br><br>
</html>
