package com.truvaile;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

@WebServlet("/BookingDao")
public class BookingDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   response.setContentType("text/html");
   		
//   		PrintWriter out = response.getWriter();
   		
   		String name = request.getParameter("username");
   		Long number = Long.parseLong(request.getParameter("number"));
   		String mail = request.getParameter("email");
   		String id = request.getParameter("id");
   		String pname = request.getParameter("name");
//   		String includes = request.getParameter("inclusions");
   		Long count =Long.parseLong(request.getParameter("count"));
//   		String duration = request.getParameter("duration");
   		String indate = request.getParameter("InDate");
   		String outdate = request.getParameter("OutDate");
   		String cost = request.getParameter("cost");
   		
   		try {
   			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=(Connection) DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/truvaileDB?useSSL=false","root","root");  
			  
			PreparedStatement ps=con.prepareStatement("insert into BOOKING (`User_name`,`Email`,`Phone_Number`,`Package_ID`, `Package_Name`,`Price_per_person`,`Traveller count`,`Check_in`,`Check_out`) values (?,?,?,?,?,?,?,?,?);");
			
			ps.setString(1, name);
			ps.setString(2, mail);
			ps.setLong(3, number );
			ps.setString(4, id);
			ps.setString(5, pname);
			ps.setString(6, cost);
			ps.setLong(7, count );
			ps.setString(8,indate);
			ps.setString(9,outdate);
			
			int i=ps.executeUpdate();  
			
			if(i>0) {
				RequestDispatcher rd=request.getRequestDispatcher("payment.html");  
				 rd.forward(request, response);
			}
			
   		}
   		catch (Exception e) 
        {  
      	  System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
     }  
	}

}
