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

import com.mysql.jdbc.Connection;

@WebServlet("/Modify")
public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  response.setContentType("text/html");
  		
  		PrintWriter out = response.getWriter();
  		
  		String n1 = request.getParameter("nname");
  		int n2 =  Integer.parseInt(request.getParameter("nid"));
  		String update = request.getParameter("update");
  		String message = request.getParameter("visitor_message");
  		
  		try {
  			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=(Connection) DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/truvaileDB?useSSL=false","root","root");  
			
			PreparedStatement ps=con.prepareStatement("insert into Package_Queries values (?,?,?,?)");
			
		    ps.setString(1, n1);
		    ps.setInt(2, n2);
		    ps.setString(3, update);
		    ps.setString(4, message);
		    
		    int i = ps.executeUpdate();
		    
		    if(i>0) {
		    	out.print("<!DOCTYPE html>\r\n"
                		+ "<html lang=\"en\">\r\n"
                		+ "<head>\r\n"
                		+ "    <meta charset=\"UTF-8\">\r\n"
                		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
                		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
                		+ "    <title> My Account | Truvaile</title>\r\n"
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
                		+ "                              </li>\r\n"
                		+ "                        <li class=\"list-item-inline\">\r\n"
                		+ "                            <a class=\"link\" href=\"Wishlist\">My Wishlist</a>\r\n"
                		+ "                        </li>\r\n"
              		    + "                         <li class=\"list-item-inline\">\r\n"
               		    + "                            <a class=\"link \" href=\"UserViewBooking\">Booked Packages</a>\r\n"
               		    + "                        </li>\r\n"
               	        + "	                       <li class=\"list-item-inline\">\r\n"
 	                    + "                            <a class=\"link\" href=\"Modify\">PackageQuery</a>\r\n"
 	                    + "                        </li>\r\n"
                		+ "                        <li class=\"list-item-inline\">\r\n"
                		+ "                            <a class=\"link\" href=\"Logout\">Logout</a>\r\n"
                		+ "                        </li>\r\n"
                		+ "                    </ul>\r\n"
                		+ "                 </nav>\r\n"
                		+ "            </div>\r\n"
                		+ "         </div>\r\n"
                		+ "       </header>\r\n"
                		+ "<section class=\"view-tables\" style=\"height: 40vh; width: 90%;\">"
                		+" <h3 style=\"text-align:center;padding-top: 5rem; padding-left=1rem\">Your request for package <i>"+update+"<i> is successfuly recieved.<br><span>We'll get in touch with you shortly!<span></h3>"
                		+ "    </section>");
		       
		       out.println("<footer class=\"footer\">\r\n"
               		+ "    \r\n"
               		+ "    <div class=\"footer-header\">\r\n"
               		+ "        <div class=\"icon\">\r\n"
               		+ "            <a href=\"#\" class=\"link\"><i class=\"fas fa-chevron-up\"></i></a></div>\r\n"
               		+ "        <p>� 2020 Truvaile Trips Pvt Ltd.</p>\r\n"
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
		    }
		    
		    else {
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
                		+ "                            <a class=\"link\" href=\"Wishlist\">My Wishlist</a>\r\n"
                		+ "                        </li>\r\n"
              		    + "                         <li class=\"list-item-inline\">\r\n"
               		    + "                            <a class=\"link \" href=\"UserViewBooking\">Booked Packages</a>\r\n"
               		    + "                        </li>\r\n"
               	        + "	                       <li class=\"list-item-inline\">\r\n"
 	                    + "                            <a class=\"link\" href=\"Modify\">PackageQuery</a>\r\n"
 	                    + "                        </li>\r\n"
                		+ "                        <li class=\"list-item-inline\">\r\n"
                		+ "                            <a class=\"link\" href=\"contact.html\">General Feedback</a>\r\n"
                		+ "                        </li>\r\n"
                		+ "                        <li class=\"list-item-inline\">\r\n"
                		+ "                            <a class=\"link\" href=\"Logout\">Logout</a>\r\n"
                		+ "                        </li>\r\n"
                		+ "                    </ul>\r\n"
                		+ "                 </nav>\r\n"
                		+ "            </div>\r\n"
                		+ "         </div>\r\n"
                		+ "       </header>\r\n"
                		+ "<section class=\"view-tables\" style=\"height: 40vh; width: 90%;\">"
                		+" <h3 style=\"text-align:center; height:200rem; width:100rem;\">Couldn't send you request, try again later!</h3>"
                		+ "    </section>");
		    	 out.println("<footer class=\"footer\">\r\n"
		               		+ "    \r\n"
		               		+ "    <div class=\"footer-header\">\r\n"
		               		+ "        <div class=\"icon\">\r\n"
		               		+ "           <i class=\"fas fa-chevron-up\"></i></div>\r\n"
		               		+ "        <p>� 2020 Truvaile Trips Pvt Ltd.</p>\r\n"
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
