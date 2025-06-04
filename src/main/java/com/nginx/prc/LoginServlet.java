package com.nginx.prc;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Map this servlet to a URL (adjust as needed)
@WebServlet("/hello")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
private static final String username= "akash";
private static final String password= "8421";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");

        // Get the response writer
        PrintWriter out = response.getWriter();

        // Write simple HTML
        out.println("<html><body>");
        out.println("<h1>Hello, World!</h1>");
        out.println("</body></html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		String passwd = request.getParameter("password");
		
		if(LoginServlet.username.equals(username) && password.equals(passwd)) {
			response.sendRedirect("welcome.jsp");
		}else {
			response.sendRedirect("index.jsp?error=true");
		}
	}
}
