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


@WebServlet("/MyAccount")
public class MyAccount extends HttpServlet {
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
        		+ "    <title> My Account | Truvaile</title>\r\n"
        		+ "    <link rel=\"icon\" href=\"/Images/logo01.png\">\r\n"
        		+ "    <link rel=\"stylesheet\" href=\"css/style.css\">\r\n"
        		+ "    <link rel=\"stylesheet\" href=\"css/style05.css\">\r\n"
        		+ "    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.1.1/css/all.css\" \r\n"
        		+ "    integrity=\"sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ\" crossorigin=\"anonymous\">\r\n"
        		+ "    <style>\r\n"
        		+ "        .text{\r\n"
        		+ "            height: 1.5rem;\r\n"
        		+ "    width: 13rem;\r\n"
        		+ "    border-radius: 7px;\r\n"
        		+ "    border-width: 0.5px;\r\n"
        		+ "    background-color: #F3F4F6;\r\n"
        		+ "    padding: 0.1rem;\r\n"
        		+ "        }\r\n"
        		+ "    label{\r\n"
        		+ "        font-style: italic;\r\n"
        		+ "    }\r\n"
        		+ "\r\n"
        		+ "    .link :hover{\r\n"
        		+ "        background-color: #FCA5A5;\r\n"
        		+ "        color: white;\r\n"
        		+ "    }\r\n"
        		+ "    </style>\r\n"
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
        		+ "                           <a class=\"link\" href=\"MyAccount\">My Account</a>\r\n"
        		+ "                             </li>\r\n"
        		+ "                       <li class=\"list-item-inline\">\r\n"
        		+ "	                	  <a class=\"link\" href=\"Wishlist\">My Wishlist</a>\r\n"
        		+ "	                		</li>\r\n"
        		+ "	              		<li class=\"list-item-inline\">\r\n"
        		+ "	               		   <a class=\"link \" href=\"UserViewBooking\">Booked Packages</a>\r\n"
        		+ "	               		  </li>\r\n"
        		+ "	               	     <li class=\"list-item-inline\">\r\n"
        		+ "	 	                    <a class=\"link\" href=\"Modify\">PackageQuery</a>\r\n"
        		+ "	 	                  </li>\r\n"
        		+ "	                    <li class=\"list-item-inline\">\r\n"
        		+ "	                	   <a class=\"link\" href=\"Logout\">Logout</a>\r\n"
        		+ "	                    </li>\r\n"
        		+ "                             \r\n"
        		+ "                      \r\n"
        		+ "                    </ul>\r\n"
        		+ "                 </nav>\r\n"
        		+ "            </div>\r\n"
        		+ "         </div>\r\n"
        		+ "       </header>");
        try {
        	  Class.forName("com.mysql.jdbc.Driver");  
				Connection con=(Connection) DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/truvaileDB?useSSL=false","root","root");  
				
				PreparedStatement p=con.prepareStatement("select * from  Users where User_name =?");
				p.setString(1,s);
				
                ResultSet rs=(ResultSet) p.executeQuery();
                
                while(rs.next()) {
                	String name = rs.getString("User_name");
                    String mail = rs.getString("Email");		
                    long numb = rs.getLong("Phone_Number");
                    String pass = rs.getString("Password");
                    
//                    out.print(name);
//                    out.print(mail);
//                    out.print(numb);
//                    out.print(pass);
                    
                    out.println("<section style=\"margin: 1rem; margin-top: -1rem;padding: 1rem; width: 90%;height: 70vh;place-items: normal; \">\r\n"
                    		+ "     <div class=\"account-container-header\" style=\"text-align: center; \"><h5 style=\"font-size:larger;\"> Welcome <span style=\"text-transform: capitalize;\"><i>"+name+"!</i></span></h5><br></div>\r\n"
                    		+ "     <div class=\"account-container\" style=\"display: inline-block;\">\r\n"
                    		+ "       <div class=\"image-container\" style=\"width: 35rem; float: left;\">\r\n"
                    		+ "          <img src=\"Images/profile.svg\" height=\"400rem\" width=\"500rem\" style=\"margin-left: 13rem; border: 2px solid #C6F2D6;box-shadow: 0px 15px 20px rgba(0,0,0,0.1);\">\r\n"
                    		+ "       </div>\r\n"
                    		+ "       <div class=\"form-container-right\" style=\" float: right; width: 30rem; \r\n"
                    		+ "      box-shadow: 0px 15px 20px #FCA5A5; height: 20rem; margin-right: 2rem;margin-top: 3rem; padding: 1rem; background: #f8f8f8; border-radius: 5px; \r\n"
                    		+ "        \">\r\n"
                    		+ "         <h6 style= \"text-align: center; text-transform: uppercase; font-size: medium; font-weight: 200;\">Personal Details</h6><br>\r\n"
                    		+ "            <p style=\"text-align: center;\">Basic info you use on Truailve services</p><br>\r\n"
                    		+ "        <fieldset style=\"padding: 1rem;\">\r\n"
                    		+ "            <legend> My Profile</legend>\r\n"
                    		+ "            <a>User Name</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+name+"<br><br><hr><br>\r\n"
                    		+ "            <a>Email</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+mail+"<br><br><hr><br>\r\n"
                    		+ "            <a>Phone Number</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&thinsp;"+numb+"<br><br><hr><br>\r\n"
                    		+ "            <a>Password</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&thinsp;&thinsp;<input type=\"password\" value="+pass+" id=\"myInput\" style=\"border: hidden;\"><button class=\"button\" onclick=\"myFunction()\" style=\"border: hidden;\"> <i class=\"far fa-eye\"></i></button>\r\n"
                    		+ "            <script>\r\n"
                    		+ "                function myFunction() {\r\n"
                    		+ "                  var x = document.getElementById(\"myInput\");\r\n"
                    		+ "                  if (x.type === \"password\") {\r\n"
                    		+ "                    x.type = \"text\";\r\n"
                    		+ "                  } else {\r\n"
                    		+ "                    x.type = \"password\";\r\n"
                    		+ "                  }\r\n"
                    		+ "                }\r\n"
                    		+ "                </script>\r\n"
                    		+ "        </fieldset>\r\n"
                    		+ "       </div>\r\n"
                    		+ "    </div>\r\n"
                    		+ "</section> <br>");
//                    
                }
        }
        
        catch (Exception e2)
		{
			 System.err.println("Got an exception! ");
             System.err.println(e2.getMessage());
		}  
        out.println("  <footer class=\"footer\">\r\n"
        		+ "    <div class=\"footer-header\">\r\n"
        		+ "        <div class=\"icon\">\r\n"
        		+ "            <a href=\"#\" class=\"link\"><i class=\"fas fa-chevron-up\"></i></a></div>\r\n"
        		+ "        <p>© 2020 Truvaile Trips Pvt Ltd.</p>\r\n"
        		+ "    </div>\r\n"
        		+ "    <ul class=\"social-link list-non-bullet\">\r\n"
        		+ "        <li class=\"list-item-inline\">\r\n"
        		+ "           <i class=\"fab fa-linkedin-in\"></i> \r\n"
        		+ "        </li>\r\n"
        		+ "        <li class=\"list-item-inline\">\r\n"
        		+ "           <i class=\"fab fa-facebook-f\"></i> \r\n"
        		+ "        </li>\r\n"
        		+ "        <li class=\"list-item-inline\">\r\n"
        		+ "           <i class=\"fas fa-play\"></i> \r\n"
        		+ "        </li>\r\n"
        		+ "        <li class=\"list-item-inline\">\r\n"
        		+ "           <i class=\"fab fa-instagram\"></i> \r\n"
        		+ "        </li>\r\n"
        		+ "        <li class=\"list-item-inline\">\r\n"
        		+ "           <i class=\"fab fa-twitter\"></i> \r\n"
        		+ "        </li>\r\n"
        		+ "    </ul>\r\n"
        		+ "</footer>\r\n"
        		+ "</body>\r\n"
        		+ "</html>");
	               
	               }  
	            }
