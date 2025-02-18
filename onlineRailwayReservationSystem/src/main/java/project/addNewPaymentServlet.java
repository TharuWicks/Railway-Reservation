package project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addNewPaymentServlet")
public class addNewPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id"); //abstra
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String amount = request.getParameter("amount");
        String valid = request.getParameter("valid");

        boolean isAdded = UserModel.addNewPayment(id, name, category, amount, valid);

        if (isAdded) {
            request.setAttribute("message", "Successfully Added");
            request.getRequestDispatcher("addNewPayment.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Something Went Wrong! Try Again !");
            request.getRequestDispatcher("addNewPayment.jsp").forward(request, response);
        }
    }
}
