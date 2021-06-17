package com.truvaile;

import java.io.*;  
import java.sql.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;  

@WebServlet("/SurveyResponse")
public class SurveyResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		 out.println("<!DOCTYPE html>\r\n"
		       		+ "<html lang=\"en\">\r\n"
		       		+ "<head>\r\n"
		       		+ "    <meta charset=\"UTF-8\">\r\n"
		       		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
		       		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
		       		+ "    <title> Packages | Truvaile</title>\r\n"
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
		       
		       		+ "                                   <a href=\"MyAccount\">My Account</a><hr/>\r\n"
		       		+ "                                  <a href=\"logout.html\">logout</a>\r\n"
		       		+ "                                </div>\r\n"
		       		+ "                              </div>\r\n"
		       		+ "                        </li>\r\n"
		       		+ "                    </ul>\r\n"
		       		+ "                 </nav>\r\n"
		       		+ "            </div>\r\n"
		       		+ "         </div>\r\n"
		       		+ "       </header>\r\n");
		
		String Date = request.getParameter("Traveldate");
		String Duration = request.getParameter("duration");
		String Budget = request.getParameter("budget");
		int travelers = Integer.parseInt(request.getParameter("NumberOfTravelers"));
		String Preference = request.getParameter("preferance");
		String accommadate = request.getParameter("Accommodation");
		String mode = request.getParameter("Mode");
		String Dcity = request.getParameter("city");
		String msg = request.getParameter("message");
		
		survey s= new survey();
		s.setDate_of_travel(Date);
		s.setDuration_of_travel(Duration);
		s.setBudget(Budget);
		s.setNumber_of_travellers(travelers);
		s.setType_of_adventure(Preference);
		s.setType_of_accommodation(accommadate);
		s.setMode_of_travel(mode);
		s.setDeparture_city(Dcity);
		s.setWhat_else_do_we_need_to_know(msg);

		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=(Connection) DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/truvaileDB?useSSL=false","root","root");  
			  
			PreparedStatement ps=con.prepareStatement("insert into Survey_response_table values (?,?,?,?,?,?,?,?,?)");
			
			ps.setString(1, s.getDate_of_travel());
			ps.setString(2, s.getDuration_of_travel());
			ps.setString(3,s.getBudget());
			ps.setInt(4,s.getNumber_of_travellers());
		    ps.setString(5,s.getType_of_adventure());
		    ps.setString(6,s.getType_of_accommodation());
		    ps.setString(7,s.getMode_of_travel());
		    ps.setString(8,s.getDeparture_city());
		    ps.setString(9,s.getWhat_else_do_we_need_to_know());
		    
		    int i=ps.executeUpdate();  
//            out.print(i);
			
			if(i>0) {
//				out.print("Record saved");

				String i1= s.getBudget();
				String i2 = s.getDuration_of_travel();
				String i3 = s.getType_of_adventure();
//				out.print(s.getBudget());
//				out.print(s.getDuration_of_travel());
//				out.print(s.getType_of_adventure());
				
				try {
					
					int k=0;
					Connection conn=(Connection) EmpDao.getConnection();  
		            PreparedStatement p=conn.prepareStatement("select * from Package_table where Package_type=? and Nights =? and Price_per_person =?");  
		            p.setString(1,i3); 
		            p.setString(2, i2);
		            p.setString(3, i1);
		            ResultSet rs=(ResultSet) p.executeQuery();  
		           out.print("<section class=\"View-Package\" style=\"width:100%;\">\r\n"
		           		+ "    <h2 style=\"margin-bottom:1rem ;\">Get Ready to explore more...!<br><br><span style=\"font-weight: 100; font-style: italic;\">Here are the packages that match your preferences..</span></h2>");
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
		            	 		+ "<input type=\"hidden\"  name=\"package_id\" value="+Id+">"
		            	 		+ "<input type= \"submit\" value=\"BOOK NOW\" class=\"button\"></form>"
		            	 		+ " <form action=\"AddToCart\" method=\"get\">\r\n"
		            		    + " <input type=\"hidden\" style=\"float:right;\" name=\"package_id\" value="+Id+">"
		            		    + " <button class=\"button\" style=\"float:right; color:black; font-size:x-large; border:none; margin-bottom:1rem;\" \"><i class=\"far fa-bookmark\" style=\"color:black\"></i></button></form>"
		            	 		+ "</div></div></div>");
		            	 
		            	 k=k+1;
		            	  }
		            
		             if(k==0) {
		            	 
				            PreparedStatement k1 =conn.prepareStatement("select * from Package_table where Price_per_person =?");  
				            k1.setString(1,i1); 
				           
				            ResultSet r=(ResultSet) k1.executeQuery();  
				             while(r.next()) {
				            	 String Id = r.getString("Package_ID");
				            	 String name = r.getString("Package_Name");
				            	 String type = r.getString("Package_type");
				            	 String inclusions = r.getString("Inclusions");
				            	 String duration = r.getString("Nights");
				            	 long cost = r.getLong("Price_per_person");
				       
				            	 out.print("<div class=\"package-cards\"><div class=\"card\"  style=\"padding: 4rem 4rem;\"><div class=\"title\" style=\" margin-top:-2rem;\"><h1><i>"+name+"</i></h1><br></div><divclass=\"des\"><p style=\" margin-left:-1rem;\">Includes: "+inclusions+"<br><br>Travel Type: "+type+"</p><p><span style=\"float: left; margin-left: -0.5rem; margin-top: 1rem;\">"+duration+"</span>"
				            	 		+ "<span style=\"float: right; margin-top: 1rem;\">Rs."+cost+"</span></p><br><br><br>"
				            	 		+ "<form action=\"Booking\" method=\"get\">"
				            	 		+ "<input type=\"hidden\" style=\"float:left;\" name=\"package_id\" value="+Id+">"
				            	 		+ "<input type= \"submit\" style=\"float:left;\"value=\"BOOK NOW\" class=\"button\"></form>"
				            	 		+ " <form action=\"AddToCart\" method=\"get\">\r\n"
				            		    + " <input type=\"hidden\" style=\"float:right;\" name=\"package_id\" value="+Id+">"
				            		    + " <button class=\"button\" style=\"float:right; color:black; font-size:x-large; border:none; margin-bottom:1rem;\" \"><i class=\"far fa-bookmark\" style=\"color:black\"></i></button></form>"
				            	 		+ "</div></div></div>");
		             }
				     }
		             out.print("<div class=\"linktopackages\">\r\n"
			             		+ "    <span>Checkout our other Packages as well</span><br><br>\r\n"
			             		+ "    <a href=\"UserViewPackages\" class=\"link\" style=\"border: 0.2px solid black; margin-top: 1rem;\">View Other Packages</a>\r\n"
			             		+ "   </div>\r\n"
			             		+ "</section>");
		             out.println("<footer class=\"footer\" style=\"margin-left: -5rem;margin-bottom: -2rem; margin-right: -5.9rem;\">\r\n"
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
		                		+ "</footer></body></html>\r\n");  
		             conn.close();  
		          }
		          catch (Exception e) 
		          {  
		        	  System.err.println("Got an exception! ");
		              System.err.println(e.getMessage());
		       }  
				
		    }
			else {
				out.print("something went wrong!");
			}
		}
		
		
		catch (Exception e2)
		{
			 System.err.println("Got an exception! ");
             System.err.println(e2.getMessage());
		}  
        
		out.close(); 
		out.print("</section><footer class=\"footer\"><div class=\"footer-header\"><div class=\"icon\"><i class=\"fas fa-chevron-up\"></i></div><p>© 2020 Truvaile Trips Pvt Ltd.</p></div>"
	       		+ "<ul class=\"social-link list-non-bullet\"><li class=\"list-item-inline\"><a href=\"#\" class=\"link\"><i class=\"fab fa-linkedin-in\"></i></a> </li><li class=\"list-item-inline\"><a href=\"#\" class=\"link\"><i class=\"fab fa-facebook-f\"></i></a> </li>"
	       		+ "<li class=\"list-item-inline\"><a href=\"#\" class=\"link\"><i class=\"fas fa-play\"></i></a> </li><li class=\"list-item-inline\"><a href=\"#\" class=\"link\"><i class=\"fab fa-instagram\"></i></a> </li><li class=\"list-item-inline\"><a href=\"#\" class=\"link\"><i class=\"fab fa-twitter\"></i></a> "
	       		+ "</li></ul></footer></body></html>");
	}

}
