package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deletePaymentServlet")
public class deletePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String catagory=request.getParameter("catagory");
		String amount=request.getParameter("amount");
		String price=request.getParameter("price");

		boolean isAdded = UserModel.deletePayment(id, name, catagory, amount, price);
		
		if (isAdded) {
            request.setAttribute("message", "Successfully Deleted");
            request.getRequestDispatcher("allPayment.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Something Went Wrong! Try Again !");
            request.getRequestDispatcher("allPayment.jsp").forward(request, response);
        }
		
		
	}

}