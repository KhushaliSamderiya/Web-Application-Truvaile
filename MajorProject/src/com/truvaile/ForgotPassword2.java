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

@WebServlet("/ForgotPassword2")
public class ForgotPassword2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter(); 
		 response.setContentType("text/html");
		
		HttpSession session=request.getSession(false);  
	        String u = (String) session.getAttribute("Username");
	        
//	        out.print(u);
	        
	        String npass=request.getParameter("npass");  
		    String cpass=request.getParameter("cpass"); 
	        
	         try {
	    			 if(npass.contentEquals(cpass)) {
	   				 Class.forName("com.mysql.jdbc.Driver");  
		   				Connection con=(Connection) DriverManager.getConnection(  
		   				"jdbc:mysql://localhost:3306/truvaileDB?useSSL=false","root","root");  
	   				
	   				PreparedStatement p=con.prepareStatement(" update Users set `Password` = ?  where User_name =?");
	   				p.setString(1,npass);
	   				p.setString(2,u);
	   				
	                 int status = p.executeUpdate();
	                   
	                   if(status>0) {
	               		out.println(" <script type=\"text/javascript\">\r\n"
	               				+ "					       alert('Password updated successfully!<br>You'll br directed to login page');\r\n"
	               				+ "					       location='login.html';\r\n"
	               				+ "					     </script>");
//	               	   HttpSession session1 =request.getSession();
//	               		session1.removeAttribute("Username");
//	               		session1.invalidate();
	                   }
	                   
	   			 } 
	                   
	                   else {
	    	    		   out.println(" <script type=\"text/javascript\">\r\n"
	    	    		   		+ "					       alert('Passwords do not match, try again!');\r\n"
	    	    		   		+ "					       location='ForgotPassword2.html';\r\n"
	    	    		   		+ "					     </script>");
	    	    	   }
	   			     
	    		   }
	    		   
	    		   catch (Exception e2)
	   			{
	   				 System.err.println("Got an exception! ");
	   	             System.err.println(e2.getMessage());
	   			}  
	    	  }
	    	   
	    	  
	       
	      
	}

