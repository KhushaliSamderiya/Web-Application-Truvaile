package com.truvaile;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

@WebServlet("/Booking")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   response.setContentType("text/html");  
           PrintWriter out=response.getWriter();  
           String pid=request.getParameter("package_id"); 
    	   
//            out.println(pid);
            
            Emp e=EmpDao.getEmployeeById(pid);
        
//            out.println(""+e.getPackage_Name());
            
            HttpSession session=request.getSession(false);  
            String s = (String) session.getAttribute("Username");
           
             out.print("<!DOCTYPE html>\r\n"
            		+ "<html lang=\"en\">\r\n"
            		+ "<head>\r\n"
            		+ "    <meta charset=\"UTF-8\">\r\n"
            		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
            		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
            		+ "    <title> Booking | Truvaile</title>\r\n"
            		+ "    <link rel=\"icon\" href=\"/Images/logo01.png\">\r\n"
            		+ "    <link rel=\"stylesheet\" href=\"css/style.css\">\r\n"
            		+ "    <link rel=\"stylesheet\" href=\"css/style05.css\">\r\n"
            		+ "    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.1.1/css/all.css\" integrity=\"sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ\" crossorigin=\"anonymous\">\r\n"
            		+ "\r\n"
            		+ "<style>\r\n"
            		+ "    input{\r\n"
            		+ "        /* padding : 0.5rem, 0.8rem; */\r\n"
            		+ "        margin: 0.8rem;\r\n"
            		+ "        height: 1.5rem;\r\n"
            		+ "        width: 12rem;\r\n"
            		+ "        box-shadow: 1px 1px 5px #c0b6b6;\r\n"
            		+ "        border-radius: 5px;\r\n"
            		+ "        border-color: gainsboro;\r\n"
            		+ "    }\r\n"
            		+ "    input:{\r\n"
            		+ "        box-shadow: 1px 1px 10px rgb(255, 249, 159);\r\n"
            		+ "        border-color:none;\r\n"
            		+ "    }\r\n"
            		+ "    label{\r\n"
            		+ "        text-transform: capitalize;\r\n"
            		+ "    }\r\n"
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
            		+ "                            <a class=\"link \" href=\"home.html\">Home</a>\r\n"
            		+ "                        </li>\r\n"
            		+ "                        <li class=\"list-item-inline\">\r\n"
            		+ "                            <a class=\"link\" href=\"about.html\">About us</a>\r\n"
            		+ "                        </li>\r\n"
            		+ "                        <li class=\"list-item-inline\">\r\n"
            		+ "                            <a class=\"link\" href=\"working.html\">How it works</a>\r\n"
            		+ "                        </li>\r\n"
            		+ "                        <li class=\"list-item-inline\">\r\n"
            		+ "                            <a class=\"link\" href=\"survey.html\">The Survey</a>\r\n"
            		+ "                        </li>\r\n"
            		+ "                        <li class=\"list-item-inline\">\r\n"
            		+ "                            <a class=\"link\" href=\"contact.html\">Contact us</a>\r\n"
            		+ "                        </li>\r\n"
            		+ "                        <li class=\"list-item-inline\">\r\n"
            		+ "                            <div class=\"dropdown\" style=\"background-color: transparent;\">\r\n"
            		+ "                                <button class=\"dropbtn\"> \r\n"
            		+ "                                    <i class=\"far fa-user-circle\"></i>\r\n"
            		+ "                                </button>\r\n"
            		+ "                                <div class=\"dropdown-content\">\r\n"
            		+ "                                  <a href=\"MyAccount\">My Account</a><hr/>\r\n"
            		+ "                                  <a href=\"Logout\">logout</a>\r\n"
            		+ "                                </div>\r\n"
            		+ "                              </div>\r\n"
            		+ "                        </li>\r\n"
            		+ "                    </ul>\r\n"
            		+ "                 </nav>\r\n"
            		+ "            </div>\r\n"
            		+ "         </div>\r\n"
            		+ "       </header>");
            
            out.print("<section class=\"form\" style=\"padding-top: 2rem;\">\r\n"
            		+ "   <form action=\"BookingDao\" method=\"POST\">\r\n"
            		+ "        <fieldset style=\"padding:1rem 1rem; width: 50rem; height: 37rem; border-radius: 5%;\" >\r\n"
            		+ "            <legend style=\"font-size: larger; text-transform: uppercase; font-weight: bold;\">Booking Details</legend>\r\n"
            		+ "    <table>\r\n"
            		+ "        <tr><td colspan=\"2\" style=\"font-weight: bold;\">Personal Details<br><span style=\"color:red;\"><small>Use the same details, which you used while signing up</small></span><br></td></tr>\r\n"
            		
            		
            		+ "        <tr>\r\n"
            		+ "            <td><lable>Username:</lable></td>\r\n"
            		+ "            <td><input type=\"text\" name='username' class=\"entertext\" value = '"+s+"' required></td>\r\n"
            		+ "            <td><lable>Phone Number:</lable></td>\r\n"
            		+ "            <td><input type=\"tel\" name='number'  class=\"entertext\" required></td>\r\n"
            		+ "        </tr>\r\n"
            		+ "        <tr>\r\n"
            		+ "            <td> <lable>Email:</lable></td>\r\n"
            		+ "            <td> <input type=\"email\" name='email' class=\"entertext\" required></td>\r\n"
            		+ "        </tr>\r\n"
            		+ "       </table>\r\n"
            		+ "       <br>\r\n"
            		+ "        <hr><br>\r\n"
            		+ "        <table>\r\n"
            		+ "        <tr><td colspan=\"2\" style=\"font-weight: bold;\">Package Details</td></tr>\r\n"
            		+ "        <tr>\r\n"
            		+ "            <td><lable>Package ID:</lable></td>\r\n"
            		+ "            <td><input type=\"text\" name='id' class=\"entertext\" value='"+e.getPackage_ID()+"' style=\"border: none;box-shadow: none;\" placeholder=\"xyz\"></td>\r\n"
            		+ "            <td><lable>Package Name:</lable></td>\r\n"
            		+ "            <td> <input type=\"text\" name='name' class=\"entertext\" value='"+e.getPackage_Name()+"' style=\"border: none;box-shadow: none;\"placeholder=\"xyz\"></td>\r\n"
            		+ "        </tr>\r\n"
            		+ "        <tr >\r\n"
            		+ "            <td><lable>Inclusions:</lable></td>\r\n"
            		+ "            <td colspan=\"2\"><input type=\"text\" name='inclusions' class=\"entertext\" value='"+e.getInclusions()+"' style=\"height: 2rem; width: 20rem;border: none;box-shadow: none;\" placeholder=\"xyz\" ></td>\r\n"
            		+ "        </tr>\r\n"
            		+ "        <tr>\r\n"
            		+ "            <td><label>No. of travelers:</label></td>\r\n"
            		+ "            <td> <input type=\"number\" name='count' class=\"entertext\" reqiured></td>\r\n"
            		+ "        </tr>\r\n"
            		+ "        <tr>\r\n"
            		+ "            <td> <lable>Duration Of Stay:</lable></td>\r\n"
            		+ "            <td> <input type=\"text\" name='duration' value='"+e.getNights()+"'class=\"entertext\" required style=\"border: none; box-shadow: none;\" placeholder=\"xyz\" ></td>\r\n"
            		+ "        </tr>\r\n"
            		+ "         <tr>\r\n"
            		+ "            <td> <label>Check in date</label></td>\r\n"
            		+ "            <td> <input type=\"date\" id=\" Date Of Travel\" class=\"entertext\" name='InDate' reqiured></td>\r\n"
            		+ "            <td><label>Check out date</label></td>\r\n"
            		+ "            <td>  <input type=\"date\" id=\"Date\" name='OutDate' class=\"entertext\" reqiured></td>\r\n"
            		+ "        </tr>\r\n"
            		+ "        <tr>\r\n"
            		+ "            <td> <label>Cost (per person) : Rs.</label></td> \r\n"
            		+ "            <td><input type=\"text\" name='cost' value='"+e.getPrice_per_person()+"' class=\"entertext\" required style=\"border: none;box-shadow: none;\" placeholder=\"xyz\"></td>\r\n"
            		+ "        </tr>\r\n"
            		+ "    </table>\r\n"
            		+ "    <input type=\"submit\" value=\"Confirm Booking\" style=\"margin-bottom: 1rem; background-color: white; color:black;width:7rem; height:2.5rem;  border-radius: 5px;;\">\r\n"
            		+ "</fieldset>\r\n"
            		+ "</form>\r\n"
            		+ "</section>");
     
            out.print("<footer class=\"footer\">\r\n"
            		+ "    \r\n"
            		+ "    <div class=\"footer-header\">\r\n"
            		+ "        <div class=\"icon\">\r\n"
            		+ "           <a href=\"#\" class=\"link\"><i class=\"fas fa-chevron-up\"></i></a></div>\r\n"
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

       }
}
