<%@page import="project.ConnectionProvider" %>
<%@page import="java.sql.*" %>
<%@include file="adminHeader.jsp" %>
<%@include file="footer.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
h3
{
	color: yellow;
	text-align: center;
}
</style>
</head>
<body>
<div style="color: white; text-align: center; font-size: 30px;">All Payment <i class='fab fa-elementor'></i></div>
<%
String msg=request.getParameter("msg");
if("done".equals(msg)){
	
%>
<h3 class="alert">Payment Successfully Updated!</h3>
<%} %>
<%
if("wrong".equals(msg)){
	
%>
<h3 class="alert">Some thing went wrong! Try again!</h3>
<%} %>
<table>
        <thead>
          <tr>
            <th scope="col">Payment ID</th>
            <th scope="col">Name</th>
            <th scope="col">Category</th>
            <th scope="col">Amount</th>
            <th>Status</th>
            <th scope="col">Edit <i class='fas fa-pen-fancy'></i></th>
            <th scope="col">Delete <i class='fas fa-pen-fancy'></i></th>
          </tr>
        </thead>
        <tbody>
       		<%
       			try{
       				Connection con=ConnectionProvider.getCon();
       				Statement st=con.createStatement();
       				ResultSet rs=st.executeQuery("select * from payment");
       				while(rs.next()){
       					%>
       			
       		
          <tr>
            <td><%=rs.getString(1) %></td>
            <td><%=rs.getString(2) %></td>
            <td><%=rs.getString(3) %></td>
            <td><%=rs.getString(4) %></td>
            <td><%=rs.getString(5) %></td>
            <td><a href="editPayment.jsp?id=<%=rs.getString(1) %>">Edit <i class='fas fa-pen-fancy'></i></a></td>
            <td><a href="deletePayment.jsp?id=<%=rs.getString(1) %>">Delete <i class='fas fa-pen-fancy'></i></a></td>
          </tr>
         <%}
       		}
       		catch(Exception e){
       			System.out.print(e);
       		}
       		%>
         
        </tbody>
      </table>
      <br>
      <br>
      <br>

</body>
</html>