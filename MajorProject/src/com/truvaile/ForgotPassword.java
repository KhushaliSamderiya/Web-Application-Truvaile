package com.truvaile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();  
         
		    String n=request.getParameter("username");  
		    String p=request.getParameter("email"); 
		    
		    try {
		    	
		    	 Class.forName("com.mysql.jdbc.Driver");  
					Connection con=(Connection) DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/truvaileDB?useSSL=false","root","root");  
					
					PreparedStatement ps=con.prepareStatement("select * from  Users where User_name =? and Email=?");
					ps.setString(1,n);
					ps.setString(2,p);
					
				 ResultSet rs=(ResultSet) ps.executeQuery();
				 
				 if(rs.next()) {
					 HttpSession session = request.getSession();
				    	session.setAttribute("Username", n);
					response.sendRedirect("ForgotPassword2.html");
				 }
				 
				 else {
					 out.println("<script type=\"text/javascript\">");
					   out.println("alert('This username and email do not exist! Please sign up to continue');");
					   out.println("location='signup.html';");
					   out.println("</script>");
				 }
		    }
		    
		    catch (Exception e2)
			{
				 System.err.println("Got an exception! ");
	             System.err.println(e2.getMessage());
			}  
	}

}
