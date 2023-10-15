package com.sg.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logForm")
public class LogServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	res.setContentType("text/html");
	PrintWriter pr = res.getWriter();
	String myEmail = req.getParameter("email1");
	String myPass = req.getParameter("password1");
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb", "root", "sutanu123");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM regis where email = ? and password = ?");
		ps.setString(1, myEmail);
		ps.setString(2, myPass);
		
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			HttpSession session = req.getSession();
			session.setAttribute("name", rs.getString("name"));
			RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
			rd.include(req, res);
		}
		else
		{
			pr.print("<h3 style='color:red'>Email and Password didn't match!</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req, res);
		}
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
