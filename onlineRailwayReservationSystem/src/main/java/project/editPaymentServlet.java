package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/editPaymentServlet")
public class editPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");//abstra
		String catagory=request.getParameter("catagory");
		String amount=request.getParameter("amount");
		String valid=request.getParameter("valid");

		boolean isAdded = UserModel.editPayment(id, name, catagory, amount, valid);
		
		if (isAdded) {
            request.setAttribute("message", "Successfully Edited");
            request.getRequestDispatcher("allPayment.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Something Went Wrong! Try Again !");
            request.getRequestDispatcher("allPayment.jsp").forward(request, response);
        }
		
	}

}
