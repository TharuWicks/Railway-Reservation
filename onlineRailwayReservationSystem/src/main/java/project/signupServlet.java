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

@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobileNumber = request.getParameter("mobileNumber");
        String sequrityQuestion = request.getParameter("sequrityQuestion");
        String answer = request.getParameter("answer");
        String password = request.getParameter("password");

        boolean isRegistered = UserModel.registerUser(name, email, mobileNumber, sequrityQuestion, answer, password);

        if (isRegistered) {
            request.setAttribute("message", "Successfully Registered");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Something Went Wrong! Try Again!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
    }

}


