package com.truvaile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLogout")
public class AdminLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   response.setContentType("text/html");  
  		 PrintWriter out = response.getWriter(); 
  		 
  		HttpSession session =request.getSession();
  		session.removeAttribute("username");
  		session.invalidate();
          out.print("<!DOCTYPE html>\r\n"
          		+ "<html lang=\"en\">\r\n"
          		+ "<head>\r\n"
          		+ "    <meta charset=\"UTF-8\">\r\n"
          		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
          		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
          		+ "    <title> Admin Logout | Truvaile</title>\r\n"
          		+ "    <link rel=\"icon\" href=\"/Images/logo01.png\">\r\n"
          		+ "    <link rel=\"stylesheet\" href=\"css/style.css\">\r\n"
          		+ "    <link rel=\"stylesheet\" href=\"css/style05.css\">\r\n"
          		+ "    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.1.1/css/all.css\" integrity=\"sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ\" crossorigin=\"anonymous\">\r\n"
          		+ "    <style>\r\n"
          		+ "      .content-table{\r\n"
          		+ "        margin: 2rem 0.2rem;\r\n"
          		+ "      }\r\n"
          		+ "    </style>\r\n"
          		+ "</head>\r\n"
          		+ "<body>\r\n"
          		+ "    <header class=\"main\">\r\n"
          		+ "        <div class=\"header-cotainer\">\r\n"
          		+ "           <div class=\"top-container\">\r\n"
          		+ "                <nav class=\"navigation container\">\r\n"
          		+ "                    <div class=\"nav-brand\">Truvaile</div>\r\n"
          		+ "                    <ul class=\"list-non-bullet nav-pills\">\r\n"
          		+"                       <li class=\"list-item-inline\">\r\n"
          		+ "                            <a class=\"link\" href=\"home.html\">Home</a>\r\n"
          		+ "                        </li>"
          		+ "                        <li class=\"list-item-inline\">\r\n"
          		+ "                            <a class=\"link\" href=\"ViewUsers\">Users List</a>\r\n"
          		+ "                        </li>\r\n"
          		+ "                        <li class=\"list-item-inline\">\r\n"
          		+ "                            <a class=\"link \" href=\"ViewServlet\">Packages</a>\r\n"
          		+ "                        </li>\r\n"
          		+ "                        <li class=\"list-item-inline\">\r\n"
          		+ "                            <a class=\"link\" href=\"ViewBookedPackages\">Booked Packages </a>\r\n"
          		+ "                        </li>\r\n"
          		+ "                        <li class=\"list-item-inline\">\r\n"
                + "                        <a class=\"link\" href=\"ViewPackageQueries\">Package Queries</a>\r\n"
                + "                        </li>\r\n"
          		+ "                        <li class=\"list-item-inline\">\r\n"
          		+ "                            <a class=\"link \" href=\"ViewFeedback\">Feedback</a>\r\n"
          		+ "                        </li>\r\n"
          		+ "                        <li class=\"list-item-inline\">\r\n"
          		+ "                            <a class=\"link link-active\" href=\"AdminLogout\">Logout</a>\r\n"
          		+ "                        </li>\r\n"
          		+ "                    </ul>\r\n"
          		+ "                 </nav>\r\n"
          		+ "            </div>\r\n"
          		+ "         </div>\r\n"
          		+ "       </header>\r\n"
          		+ "<section class=\"content\" style=\"height: 35vh;\">\r\n"
        		+ "    \r\n"
        		+ "  <h3 style=\"margin-top:-1rem\" >You have successfully logged out!</h3>\r\n"
        	    + "  <img src=\"Images/logout.svg\" alt=\"\" height=\"250vh\" width=\"400vh\" style=\"margin-left: -5rem; margin-top:2rem\">  "
        		+ "</section>\r\n"
          		+ "<footer class=\"footer\">\r\n"
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
          		+ "</footer></body></html>\r\n"
          		+ "\r\n"
          		+ "\r\n");
          }
       }