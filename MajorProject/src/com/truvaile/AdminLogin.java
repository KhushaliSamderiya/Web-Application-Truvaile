package com.truvaile;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        String uname = request.getParameter("username");
	        String upass = request.getParameter("password");
	        
	        if(AdminDao.checkUser(uname, upass))
	        {
	        	HttpSession session = request.getSession();
		    	session.setAttribute("username", uname);
	           RequestDispatcher rs = request.getRequestDispatcher("ViewUsers");
               rs.forward(request, response);
	           
	        }
	        else
	        {
	        	out.println("<script type=\"text/javascript\">");
				   out.println("alert('Username or Password incorrect');");
				   out.println("location='WelcomeAdmin.html';");
				   out.println("</script>");
//	           out.println("Username or Password incorrect");
//	           RequestDispatcher rs = request.getRequestDispatcher("index.html");
//               rs.include(request, response);
	        	
	        }
	    }  
	}
	