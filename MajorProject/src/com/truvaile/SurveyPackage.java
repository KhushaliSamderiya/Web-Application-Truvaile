package com.truvaile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

@WebServlet("/SurveyPackage")
public class SurveyPackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	  response.setContentType("text/html");  
          PrintWriter out=response.getWriter();  
          
          try {
        	  Class.forName("com.mysql.jdbc.Driver");  
              Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/truvaileDB?useSSL=false","root","root");  
              java.sql.Statement stmt = con.createStatement();
              java.sql.ResultSet rs = stmt.executeQuery("select * from Package_table WHERE Nights= '5N/6D' and Package_type = 'Adventure' and Price_per_person = 5500 ");
             
             
              out.print("<table><thead><tr><th>Id</th><th>Name</th><th>Type</th><th>Inclusions</th><th>Duration</th><th>Cost</th>");
             while(rs.next()) {
            	 String Id = rs.getString("Package_ID");
            	 String name = rs.getString("Package_Name");
            	 String type = rs.getString("Package_type");
            	 String inclusions = rs.getString("Inclusions");
            	 String duration = rs.getString("Nights");
            	 long cost = rs.getLong("Price_per_person");
            	 
            	 out.println("<tbody><tr><td>" +Id + "</td><td>" + name + "</td><td>" + type + "</td><td>" +inclusions + "</td><td>" + duration + "</td><td>"+ cost +"</td></tr></tbody>"); 
            	 out.print("</table>");
             }
             con.close();  
          }
          catch (Exception e) 
          {  
        	  System.err.println("Got an exception! ");
              System.err.println(e.getMessage());
       }  
	}
}
