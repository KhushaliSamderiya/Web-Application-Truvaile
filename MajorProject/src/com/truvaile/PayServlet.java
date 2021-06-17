package com.truvaile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("uname");
		String cardnumber=(request.getParameter("number"));
		String date= request.getParameter("expiryDate");
		Long number=Long.parseLong(request.getParameter("pin"));
		
		if(name!= null && cardnumber!= null && date!= null && number!=null ) {
			response.sendRedirect("success.html");
		}
		
		else {
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Something went wrong try again!');");
			   out.println("location='payment.html';");
			   out.println("</script>");
		}
		
	}

}
