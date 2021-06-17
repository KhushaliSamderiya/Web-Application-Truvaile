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
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

@WebServlet("/VeiwBookedPackages")
public class VeiwBookedPackages extends HttpServlet {
	private static final long serialVersionUID = 1L;
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        try 
        {  
     	   Class.forName("com.mysql.jdbc.Driver");  
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/truvaileDB?useSSL=false","root","root");  
            Statement stmt = (Statement) con.createStatement();  
            ResultSet rs = (ResultSet) stmt.executeQuery("select * from BOOKING"); 
            out.print("<!DOCTYPE html>\r\n"
            		+ "<html lang=\"en\">\r\n"
            		+ "<head>\r\n"
            		+ "    <meta charset=\"UTF-8\">\r\n"
            		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
            		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
            		+ "    <title> Users List | Truvaile</title>\r\n"
            		+ "    <link rel=\"icon\" href=\"/Images/logo01.png\">\r\n"
            		+ "    <link rel=\"stylesheet\" href=\"css/style.css\">\r\n"
            		+ "    <link rel=\"stylesheet\" href=\"css/style07.css\">\r\n"
            		+ "    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.1.1/css/all.css\" integrity=\"sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ\" crossorigin=\"anonymous\">\r\n"
            		+ "    <style> .content-table{margin: 2rem 3rem;}</style>     "
            		+ "</head>\r\n"
            		+ "<body>\r\n"
            		+ "    <header class=\"main\">\r\n"
            		+ "        <div class=\"header-cotainer\">\r\n"
            		+ "           <div class=\"top-container\">\r\n"
            		+ "                <nav class=\"navigation container\">\r\n"
            		+ "                    <div class=\"nav-brand\">Truvaile</div>\r\n"
            		+ "                    <ul class=\"list-non-bullet nav-pills\">\r\n"
            		+ "                        <li class=\"list-item-inline\">\r\n"
            		+ "                            <a class=\"link \" href=\"ViewUsers\">Users List</a>\r\n"
            		+ "                        </li>\r\n"
            		+ "                        <li class=\"list-item-inline\">\r\n"
            		+ "                            <a class=\"link\" href=\"ViewServlet\">Packages</a>\r\n"
            		+ "                        </li>\r\n"
          		    + "                         <li class=\"list-item-inline\">\r\n"
           		    + "                            <a class=\"link link-active\" href=\"ViewBookedPackages\">Booked Packages </a>\r\n"
           		    + "                        </li>\r\n"
           			+ "                        <li class=\"list-item-inline\">\r\n"
                    + "                        <a class=\"link\" href=\"ViewPackageQueries\">Package Queries</a>\r\n"
                    + "                        </li>\r\n"
            		+ "                        <li class=\"list-item-inline\">\r\n"
            		+ "                            <a class=\"link\" href=\"ViewFeedback\">Feedback</a>\r\n"
            		+ "                        </li>\r\n"
            		+ "                        <li class=\"list-item-inline\">\r\n"
            		+ "                            <a class=\"link\" href=\"AdminLogout\">Logout</a>\r\n"
            		+ "                        </li>\r\n"
            		+ "                    </ul>\r\n"
            		+ "                 </nav>\r\n"
            		+ "            </div>\r\n"
            		+ "         </div>\r\n"
            		+ "       </header>\r\n"
            		+ "<section class=\"view-tables\">"
            		+ "    <h2>Booked Packages</h2>");
            out.println("<table class=\"content-table\" border=1 width=50% height=50% margin-left=-20rem>");  
            out.println("<thead><tr><th>BookingId</th><th>UserName</th><th>UserEmail</th><th>UserNumber</th><th>Package ID</th><th>Package Name</th><th>Cost</th><th>No.of Travelers</th><th>Check-In</th><th>Check-Out</th></tr><thead>");  
            while (rs.next()) 
            {  
                int id = rs.getInt("Bookind_id");  
                String name = rs.getString("User_name");
                String Email = rs.getString("Email");
                Long num = rs.getLong("Phone_Number");
                String Pid = rs.getString("Package_ID");
                String pname = rs.getString("Package_Name");
                Long price = rs.getLong("Price_per_person");
                String count= rs.getString("Traveller count");
                String InDate = rs.getString("Check_in");
                String OutDate = rs.getString("Check_out");
               
                out.println("<tbody><tr><td>" +id + "</td><td>" + name + "</td><td>" + Email + "</td><td>" +num + "</td><td>" + Pid + "</td><td>"+ pname +"</td><td>Rs."+price+"</td><td>"+ count +"</td><td>"+ InDate +"</td><td>"+ OutDate +"</td></tr></tbody>");   
            }  
            out.println("</table></section>");  
            out.println("<footer class=\"footer\">\r\n"
            		+ "    \r\n"
            		+ "    <div class=\"footer-header\">\r\n"
            		+ "        <div class=\"icon\">\r\n"
            		+ "           <a href=\"#\" class=\"link\"> <i class=\"fas fa-chevron-up\"></i></a></div>\r\n"
            		+ "        <p>© 2020 Truvaile Trips Pvt Ltd.</p>\r\n"
            		+ "    </div>\r\n"
            		+ "    <ul class=\"social-link list-non-bullet\">\r\n"
            		+ "        <li class=\"list-item-inline\">\r\n"
            		+ "            <a href=\"#\" class=\"link\"><i class=\"fab fa-linkedin-in\"></i></a> \r\n"
            		+ "        </li>\r\n"
            		+ "        <li class=\"list-item-inline\">\r\n"
            		+ "            <a href=\"#\" class=\"link\"><i class=\"fab fa-facebook-f\"></i></a> \r\n"
            		+ "        </li>\r\n"
            		+ "        <li class=\"list-item-inline\">\r\n"
            		+ "            <a href=\"#\" class=\"link\"><i class=\"fas fa-play\"></i></a> \r\n"
            		+ "        </li>\r\n"
            		+ "        <li class=\"list-item-inline\">\r\n"
            		+ "            <a href=\"#\" class=\"link\"><i class=\"fab fa-instagram\"></i></a> \r\n"
            		+ "        </li>\r\n"
            		+ "        <li class=\"list-item-inline\">\r\n"
            		+ "            <a href=\"#\" class=\"link\"><i class=\"fab fa-twitter\"></i></a> \r\n"
            		+ "        </li>\r\n"
            		+ "    </ul>\r\n"
            		+ "</footer></body></html>\r\n");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error");  
        }  
	}
}
