package project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet { //inheri
	private static final long serialVersionUID = 1L;
       
    //polymorphism
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        String password = request.getParameter("password");//encapsulation

        if ("service@gmail.com".equals(email) && "Service123".equals(password)) { 
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            response.sendRedirect("paymentHome.jsp");
        } else {
            boolean isValidUser = UserModel.validateUser(email, password);
            if (isValidUser) {
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                response.sendRedirect("home.jsp");
            } else {
                request.setAttribute("msg", "Invalid User");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}


