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


@WebServlet("/forgotPasswordServlet")
public class forgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        String mobileNumber = request.getParameter("mobileNumber");
        String sequrityQuestion = request.getParameter("sequrityQuestion");
        String answer = request.getParameter("answer");
        String newPassword = request.getParameter("newPassword");

        boolean isPasswordChanged = UserModel.changePassword(email, mobileNumber, sequrityQuestion, answer, newPassword);

        if (isPasswordChanged) {
            request.setAttribute("message", "Password Changed Successfully");
            request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Something Went Wrong! Try Again!");
            request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
        }
    }
}
