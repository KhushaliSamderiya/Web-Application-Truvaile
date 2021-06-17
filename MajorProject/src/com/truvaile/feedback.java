package com.truvaile;

import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  


@WebServlet("/feedback")
public class feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("name");
		Long unumb = Long.parseLong(request.getParameter("number"));
		String uemail = request.getParameter("email");
		String umsg = request.getParameter("message");
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/truvaileDB?useSSL=false","root","root");  
			  
			PreparedStatement ps=con.prepareStatement(  
			"insert into feedback_table (User_name, Phone_Number, Email_Address, Message) values (?,?,?,?)");  
			  
			ps.setString(1,uname);  
			ps.setLong(2,unumb);  
			ps.setString(3,uemail);  
			ps.setString(4,umsg);  
			          
			int i=ps.executeUpdate();  
			
			if(i>0)  
				
			out.print("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <link rel=\"icon\" href=\"Images/logo01.png\">\r\n"
					+ "    <link rel=\"stylesheet\" href=\"css/style.css\">\r\n"
					+ "    <link rel=\"stylesheet\" href=\"css/style04.css\">\r\n"
					+ "    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.1.1/css/all.css\" integrity=\"sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ\" crossorigin=\"anonymous\">\r\n"
					+ "    <title>Contact us | Truvaile</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <header class=\"main\" style=\"background-image: linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)), url('Images/BgContact.jpg'); height: 80vh;\">\r\n"
					+ "        <div class=\"header-cotainer\">\r\n"
					+ "           <div class=\"top-container\">\r\n"
					+ "                <nav class=\"navigation container\">\r\n"
					+ "                    <div class=\"nav-brand\">Truvaile</div>\r\n"
					+ "                    <ul class=\"list-non-bullet nav-pills\">\r\n"
					+ "                        <li class=\"list-item-inline\">\r\n"
					+ "                            <a class=\"link \" href=\"home.html\">Home</a>\r\n"
					+ "                        </li>\r\n"
					+ "                        <li class=\"list-item-inline\">\r\n"
					+ "                            <a class=\"link \" href=\"about.html\">About us</a>\r\n"
					+ "                        </li>\r\n"
					+ "                        <li class=\"list-item-inline\">\r\n"
					+ "                            <a class=\"link\" href=\"working.html\">How it works</a>\r\n"
					+ "                        </li>\r\n"
					+ "                        <li class=\"list-item-inline\">\r\n"
					+ "                            <a class=\"link\" href=\"survey.jsp\">The Survey</a>\r\n"
					+ "                        </li>\r\n"
					+ "                        <li class=\"list-item-inline\">\r\n"
					+ "                            <a class=\"link link-active\" href=\"/\">Contact us</a>\r\n"
					+ "                        </li>\r\n"
					+ "                        <li class=\"list-item-inline\">\r\n"
					+ "                            <div class=\"dropdown\" style=\"background-color: transparent;\">\r\n"
					+ "                                <button class=\"dropbtn\"> \r\n"
					+ "                                    <i class=\"far fa-user-circle\"></i>\r\n"
					+ "                                </button>\r\n"
					+ "                                <div class=\"dropdown-content\">\r\n"
					+ "                                 <a href=\"login.html\">Login</a>\r\n"
					+ "                                  <a href=\"signup.html\">Signup</a><hr/>\r\n"
					+ "                                  <a href=\"Logout\">Logout</a>"
					+ "                                </div>\r\n"
					+ "                              </div>\r\n"
					+ "                        </li>\r\n"
					+ "                    </ul>\r\n"
					+ "                 </nav>\r\n"
					+ "            </div>\r\n"
					+ "                \r\n"
					+ "            <div class=\"container-caption\">\r\n"
					+ "                <h2 class=\"header-caption\">Contact us</h2>\r\n"
					+ "             </div>\r\n"
					+ "        </div>\r\n"
					+ "       \r\n"
					+ "</header>\r\n"
					+ "<section class=\"contact-section\">\r\n"
					+ "<div class=\"contact-us\">\r\n"
					+ "    <div class=\"get-in-touch\">\r\n"
					+ "       <h5 class=\"address\" style=\"letter-spacing: 0.3rem; text-transform: uppercase;\">Get In touch</h5><br>\r\n"
					+ "       <p><i class=\"fas fa-envelope-open\"></i> <span style=\"color: teal;\"> info@truvalie.in </span></p><br>\r\n"
					+ "       <p><i class= \"fab fa-whatsapp\"></i><span style=\"color: teal;\"> +91-9398252034 | +91-9374252034 </span></p><br><br>\r\n"
					+ "       <h5 class=\"address\" style=\"letter-spacing: 0.3rem; text-transform: uppercase;\" >Address</h5><br>\r\n"
					+ "       <p style=\"font-size: 1.3rem; font-weight: normal;\">Truvaile,<br>\r\n"
					+ "        MVMP Spark,<br>\r\n"
					+ "        Near Balewadi High Street,<br>\r\n"
					+ "        Balewadi Phata,<br>\r\n"
					+ "        Baner, Hyderabad - 500 029</p>\r\n"
					+ "    </div>\r\n"
					+ "    <div class=\"form-container\">\r\n"
					+ "    <form action=feedback method=\"post\">\r\n"
					+ "        <input class=\"input\" type=\"text\" name=\"name\" placeholder=\"Your Name\">\r\n"
					+ "        <input class=\"input\" type=\"tel\" name=\"number\" placeholder=\"Your Number\"><br><br>\r\n"
					+ "        <input class=\"input\" type=\"email\" id=\"email\" name=\"email\" placeholder=\"Your Email Address\"><br><br>\r\n"
					+ "        <textarea name=\"message\" rows=\"4\" cols=\"47\" placeholder=\"Message\"></textarea><br><br>\r\n"
					+ "        <input type=\"submit\" value=\"send a message\"class=\"btn-submit\">\r\n"
					+ "        \r\n"
					+ "    </form>\r\n"
					+ "<h3 style=\"padding-top: 1rem\"><i><center>Thank you for your response!</center></i><h3>\r\n"
					+ "    </div>\r\n"
					+ "</div>\r\n"
					+ "</section>\r\n"
					+ "<footer class=\"footer\">\r\n"
					+ "    \r\n"
					+ "    <div class=\"footer-header\">\r\n"
					+ "        <div class=\"icon\">\r\n"
					+ "           <i class=\"fas fa-chevron-up\"></i></div>\r\n"
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
					+ "\r\n"
					+ "\r\n"
					+ "</footer>\r\n"
					+ "</body>\r\n"
					+ "</html>");  
			      
			          
			}catch (Exception e2) {System.out.println(e2);}  
			          
			out.close();  
			}  
			  
			}  
