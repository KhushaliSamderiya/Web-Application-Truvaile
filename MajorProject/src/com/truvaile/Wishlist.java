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
import com.mysql.jdbc.Statement;

@WebServlet("/Wishlist")
public class Wishlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
         PrintWriter out=response.getWriter();  
         
         HttpSession session=request.getSession(false);  
         String s = (String) session.getAttribute("Username");
         
         out.println("<!DOCTYPE html>\r\n"
            		+ "<html lang=\"en\">\r\n"
            		+ "<head>\r\n"
            		+ "    <meta charset=\"UTF-8\">\r\n"
            		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
            		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
            		+ "    <title> View Packages | Truvaile</title>\r\n"
            		+ "    <link rel=\"icon\" href=\"/Images/logo01.png\">\r\n"
            		+ "    <link rel=\"stylesheet\" href=\"css/style.css\">\r\n"
            		+ "    <!-- <link rel=\"stylesheet\" href=\"css/style05.css\"> -->\r\n"
            		+ "    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.1.1/css/all.css\" integrity=\"sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ\" crossorigin=\"anonymous\">\r\n"
            		+ "    <style>\r\n"
            		+ "    :root{\r\n"
            		+ "    --primary-color: #FCA5A5;\r\n"
            		+ "    --primary-white: white;\r\n"
            		+ "}\r\n"
            		+ "header{\r\n"
            		+ "    background-image: none;\r\n"
            		+ "    height: 20vh;\r\n"
            		+ "}\r\n"
            		+ ".navigation {\r\n"
            		+ "    background-color: var(--primary-white);\r\n"
            		+ "    /* color: white; */\r\n"
            		+ "    /* padding: 2rem; */\r\n"
            		+ "    border-bottom-left-radius: 1rem;\r\n"
            		+ "    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);\r\n"
            		+ "    border: 1px solid #E7E5E4;\r\n"
            		+ "}\r\n"
            		+ "\r\n"
            		+ ".navigation .link, .nav-brand {\r\n"
            		+ "    color: black;\r\n"
            		+ "}\r\n"
            		+ "\r\n"
            		+ ".dropbtn {\r\n"
            		+ "  color: black;\r\n"
            		+ "}\r\n"
            		+ "\r\n"
            		+ ".dropdown-content {\r\n"
            		+ "  background-color: var(--primary-white);\r\n"
            		+ "}\r\n"
            		+ "\r\n"
            		+ "section{\r\n"
            		+ "  padding: 0.5rem 0rem;\r\n"
            		+ " \r\n"
            		+ "  height: 100%;\r\n"
            		+ "  width: 90%;\r\n"
            		+ "  margin: 2rem;\r\n"
            		+ "  \r\n"
            		+ "}\r\n"
            		+ ".package-cards{\r\n"
            		+ "    display: inline-flex;\r\n"
            		+ "}\r\n"
            		+ ".card{\r\n"
            		+ "     width: 225px;\r\n"
            		+ "     height: 180px;\r\n"
            		+ "     display: block;\r\n"
            		+ "     box-shadow: 1px 1px 10px rgb(255, 249, 159);\r\n"
            		+ "     border-radius: 5px; \r\n"
            		+ "     margin: 2%;\r\n"
            		+ "     margin-right: 3rem; margin-bottom: 2rem\r\n"
            		+ "}\r\n"
            		+ "\r\n"
            		+ ".title{\r\n"
            		+ " \r\n"
            		+ "  text-align: center;\r\n"
            		+ "  padding: 10px;\r\n"
            		+ "  \r\n"
            		+ " }\r\n"
            		+ "\r\n"
            		+ "h1{\r\n"
            		+ "  font-size: 20px;\r\n"
            		+ " }\r\n"
            		+ "\r\n"
            		+ ".des{\r\n"
            		+ "  padding: 3px;\r\n"
            		+ "  text-align: center;\r\n"
            		+ " \r\n"
            		+ "  padding-top: 5px;\r\n"
            		+ "  border-bottom-right-radius: 5px;\r\n"
            		+ "  border-bottom-left-radius: 5px;\r\n"
            		+ "}\r\n"
            		+ ".button{\r\n"
            		+ "  margin-top: 5px;\r\n"
            		+ "  margin-bottom: 10px;\r\n"
            		+ "  background-color: white;\r\n"
            		+ "  color: black;\r\n"
            		+ "  border: 1px solid black;\r\n"
            		+ "  border-radius: 5px;\r\n"
            		+ "  padding:10px;\r\n"
            		+ "}\r\n"
            		+ ".button:hover{\r\n"
            		+ "  background-color: black;\r\n"
            		+ "  color:yellow;\r\n"
            		+ "  transition: .5s;\r\n"
            		+ "  cursor: pointer;\r\n"
            		+ "}\r\n"
            		+ ".linktopackages{\r\n"
            		+ "    margin-left: 0.5rem;\r\n"
            		+ "    margin-top: 2rem;\r\n"
            		+ "    /* text-align: center; */\r\n"
            		+ "}\r\n"
            		+ "</style>\r\n"
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
            		+ "                            <a class=\"link link-active \" href=\"Wishlist\">My Wishlist</a>\r\n"
            		+ "                        </li>\r\n"
          		    + "                         <li class=\"list-item-inline\">\r\n"
           		    + "                            <a class=\"link \" href=\"UserViewBooking\">Booked Packages</a>\r\n"
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
            		+ "       </header>\r\n");
         
         try {
        	 int k=0;
        	 Class.forName("com.mysql.jdbc.Driver");  
             Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/truvaileDB?useSSL=false","root","root");  
             PreparedStatement ps=con.prepareStatement("select * from MyWishList where User_name=?"); 
             ps.setString(1, s);
             ResultSet rs=(ResultSet) ps.executeQuery(); 
            
             out.print("<section class=\"View-Package\" style=\"width:100%;\">\r\n"
		           		+ "    <h2 style=\"margin-bottom:1rem ;\">Your saved packages.....</h2>");
//		            out.print("<table><thead><tr><td>Id</td><td>Name</td><td>Type</td><td>Inclusions</td><td>Duration</td><td>Cost</td></tr></thead>");
		             while(rs.next()) {
		            	 
		            	 String Id = rs.getString("Package_ID");
		            	 String name = rs.getString("Package_Name");
		            	 String type = rs.getString("Package_type");
		            	 String inclusions = rs.getString("Inclusions");
		            	 String duration = rs.getString("Nights");
		            	 long cost = rs.getLong("Price_per_person");
		            	 
//		            	 out.println("<tr><td>"+Id+"</td><td>"+name+"</td><td>"+type+"</td><td>"+inclusions+"</td><td>"+duration+"</td><td>"+cost+"</td></tr>");
		            	 out.print("<div class=\"package-cards\"><div class=\"card\"  style=\"padding: 4rem 4rem;\"><div class=\"title\" style=\" margin-top:-2rem;\"><h1><i>"+name+"</i></h1><br></div><divclass=\"des\"><p style=\" margin-left:-1rem;\">Includes: "+inclusions+"<br><br>Travel Type: "+type+"</p><p><span style=\"float: left; margin-left: -0.5rem; margin-top: 1rem;\">"+duration+"</span>"
		            	 		+ "<span style=\"float: right; margin-top: 1rem;\">Rs."+cost+"</span></p><br><br><br>"
		            	 		+ "<form action=\"Booking\" method=\"get\">"
		            	 		+ "<input type=\"hidden\" style=\"float:left;\" name=\"package_id\" value="+Id+">"
		            	 		+ "<input type= \"submit\" style=\"float:left;\" value=\"BOOK NOW\" class=\"button\"></form>"
		            	 		+ " <form action=\"AddToCart\" method=\"post\">\r\n"
		            		    + " <input type=\"hidden\" style=\"float:right;\" name=\"package_id\" value="+Id+">"
		            		    + " <button class=\"button\" style=\"float:right; color:black; font-size:x-large; border:none; margin-bottom:1rem;\" onclick=\"alert('Your package is added to cart')\"><i class=\"far fa-bookmark\" style=\"color:black\"></i></button></form>"
		            	 		+ "</div></div></div>");
		            	 k=k+1;
		             }
		           if(k==0)  {out.println("<section class=\"View-Package\">\r\n"
		             		+ "    <h3 style=\"margin-bottom:1rem ;\">Oh-oh! No packages added to cart</h3><div class=\"linktopackages\">\r\n"
		             		+ "    <span>Checkout all our Packages</span><br><br>\r\n"
		             		+ "    <a href=\"UserViewPackages\" class=\"link\" style=\"border: 0.2px solid black; margin-top: 1rem;\">View Other Packages</a>\r\n"
		             		+ "   </div>\r\n"
		             		+ "</section>");}
		           out.println("<footer class=\"footer\" style=\"margin-left: -5rem;margin-bottom: -2rem; margin-right: -5.9rem;\">\r\n"
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
       	  System.err.println("Got an exception! ");
             System.err.println(e.getMessage());
      }  
	}
}
