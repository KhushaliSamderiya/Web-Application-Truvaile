package com.truvaile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;


@WebServlet("/UserViewBooking")
public class UserViewBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter();  
	    
	
	    HttpSession session=request.getSession(false);  
        String s = (String) session.getAttribute("Username");

        out.print("<!DOCTYPE html>\r\n"
        		+ "<html lang=\"en\">\r\n"
        		+ "<head>\r\n"
        		+ "    <meta charset=\"UTF-8\">\r\n"
        		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
        		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
        		+ "    <title> My Bookings | Truvaile</title>\r\n"
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
        		+ "                            <a class=\"link\" href=\"home.html\">Home</a>\r\n"
        		+ "                        </li>\r\n"
        		+ "                        <li class=\"list-item-inline\">\r\n"
        		+ "                            <a class=\"link\" href=\"MyAccount\">My Account</a>\r\n"
        		+ "                        </li>\r\n"
        		+ "                        <li class=\"list-item-inline\">\r\n"
        		+ "                            <a class=\"link \" href=\"Wishlist\">My Wishlist</a>\r\n"
        		+ "                        </li>\r\n"
      		    + "                         <li class=\"list-item-inline\">\r\n"
       		    + "                            <a class=\"link link-active\" href=\"UserViewBooking\">Booked Packages</a>\r\n"
       		    + "                        </li>\r\n"
       	        + "	                       <li class=\"list-item-inline\">\r\n"
                + "                            <a class=\"link\" href=\"PackageQuery.html\">Package Queries</a>\r\n"
                + "                        </li>\r\n"
        		+ "                        <li class=\"list-item-inline\">\r\n"
        		+ "                            <a class=\"link\" href=\"Logout\">Logout</a>\r\n"
        		+ "                        </li>\r\n"
        		+ "                    </ul>\r\n"
        		+ "                 </nav>\r\n"
        		+ "            </div>\r\n"
        		+ "         </div>\r\n"
        		+ "       </header>\r\n"
        		+ "<section class=\"view-tables\">"
        		+ "    <h2>Booked Packages</h2>");
        
        try 
	            {  
        	       
        	      int k=0;
	         	   Class.forName("com.mysql.jdbc.Driver");  
	                Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/truvaileDB?useSSL=false","root","root");  
	                PreparedStatement ps=(PreparedStatement) con.prepareStatement("select * from BOOKING where User_name=?"); 
	                ps.setString(1, s);
	                ResultSet rs = (ResultSet) ps.executeQuery();

	                out.println("<table class=\"content-table\" border=1 width=50% height=50% margin-left=10rem>");  
	                out.println("<thead><tr><th>BookingId</th><th>UserName</th><th>UserEmail</th><th>UserNumber</th><th>Package ID</th><th>Package Name</th><th>Cost</th><th>No.of Travelers</th><th>Check-In</th><th>Check-Out</th></tr></thead>");  
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
	                    
	                    k=k+1;
	                }  
	               
	                
	                if(k==0) 
	                	{out.println("<tbody><tr><td colspan = 10 style=\" text-align:center;\"><span >Oh-oh! No packages booked yet!</span></td></tr></tbody></table>\r\n"
//			             		+ "    <h3 style=\"margin-bottom:1rem ;\">Oh-oh! No packages booked yet</h3>"
			             		+ "<div class=\"linktopackages\" style=\"  margin-bottom: 2rem;text-align:center;\">\r\n"
			             		+ "    <span><b><i>Checkout all our Packages</i></b></span><br><br>\r\n"
			             		+ "    <a href=\"UserViewPackages\" class=\"link\" style=\"border: 0.2px solid black; margin-top: 1rem;\">View Other Packages</a>\r\n"
			             		+ "   </div>\r\n"
			             		+ "</section>");}
	                out.println("</table></section>"); 
	                	
	                out.println("<footer class=\"footer\">\r\n"
	                		+ "    \r\n"
	                		+ "    <div class=\"footer-header\">\r\n"
	                		+ "        <div class=\"icon\">\r\n"
	                		+ "            <a href=\"#\" class=\"link\"><i class=\"fas fa-chevron-up\"></i></a></div>\r\n"
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
