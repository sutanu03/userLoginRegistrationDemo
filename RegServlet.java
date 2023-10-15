package com.sg.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regisForm")
public class RegServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	res.setContentType("text/html");
	PrintWriter pr = res.getWriter();
	
	String myName = req.getParameter("name");
	String myEmail = req.getParameter("email");
	String myPass = req.getParameter("password");
	String myGender = req.getParameter("gender");
	String myCity = req.getParameter("city");
	
	
	try {
		
		String url = "jdbc:mysql://localhost:3306/logindb";
		String username = "root";
		String password = "sutanu123";
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		String query = "INSERT INTO regis(name, email, password, gender, city) VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, myName);
		ps.setString(2, myEmail);
		ps.setString(3, myPass);
		ps.setString(4, myGender);
		ps.setString(5, myCity);
		
		
	    int count = ps.executeUpdate();
	    
	    if(count>0)
	    {
	    	pr.print("<h3 style = 'color:green'>User registration successful!</h3>");
	    	
	    	RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
	    	rd.include(req, res);
	    }
	    else
	    {
	    	pr.print("<h3 style = 'color:red'>User registration failed, try again!</h3>");
	    	
	    	RequestDispatcher rd = req.getRequestDispatcher("/registration.jsp");
	    	rd.include(req, res);
	    }
	    
	    ps.close();
	    conn.close();
	} 
	catch (Exception e) {
		e.printStackTrace();
		res.setContentType("text/html");
    	pr.print("<h3 style = 'color:red'>Exception Occured : "+e.getMessage()+"</h3>");
    	
    	RequestDispatcher rd = req.getRequestDispatcher("/registration.jsp");
    	rd.include(req, res);
	}
	
	//pr.print("Welcome : "+myName+", your registraion is successful");
	
	
	pr.close();
}
}

