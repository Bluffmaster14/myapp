package com.nginx.prc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Map this servlet to a URL (adjust as needed)
@WebServlet("/hello")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String username = "akash";
	//private static final String password = "8421";
	Connection conn = null;

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
		String sql= "select password from data where username = ?"; 
		try {
			if(validUser(username,passwd)) {
				response.sendRedirect("welcome.jsp");

			}else {
				response.sendRedirect("index.jsp?error=true");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean validUser(String username, String passwd) throws ClassNotFoundException {
		String password = null;
		String sql = "select password from data where username = ?";
		String Url = System.getenv("database_url");
		String db_user = System.getenv("database_user");
		String db_pass = System.getenv("database_password");
		//String Url = "jdbc:postgresql://192.168.56.13:5432/postgres";
		//String db_user = "akash";
		//String db_pass = "8421";
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(Url, db_user, db_pass);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			ResultSet rset = pstm.executeQuery();
			while (rset.next()) {
				password = rset.getString("password");
				System.out.println("Password is:: " +password);
				System.out.println("Provided pssa: " +passwd);
			}

			if (password.equals(passwd)) {
				System.out.println("inside if condition");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		}
		return false;
	}
}
