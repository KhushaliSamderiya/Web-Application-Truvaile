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

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  
		  String pid=request.getParameter("package_id");
		  
//		  out.print(pid);
		  Emp e=EmpDao.getEmployeeById(pid);
			HttpSession session=request.getSession(false);  
	        String s = (String) session.getAttribute("Username");
	      
			
	        try {
		
			  Class.forName("com.mysql.jdbc.Driver");  
				Connection con=(Connection) DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/truvaileDB?useSSL=false","root","root");  
				
				PreparedStatement p=con.prepareStatement("select * from  MyWishList where User_name =? and Package_ID=?");
				p.setString(1,s);
				p.setString(2, pid);
				
				ResultSet rs=(ResultSet) p.executeQuery();
				
				if(rs.next()) {
					out.println("<script type=\"text/javascript\">");
					   out.println("alert('Your package is already saved to cart!');");
					   out.println("location='UserViewPackages';");
					   out.println("</script>");
					
				}
				
				else {
				
				PreparedStatement ps=con.prepareStatement("insert into MyWishList values (?,?,?,?,?,?,?)");
			    ps.setString(1,s);
				ps.setString(2, e.getPackage_ID());
				ps.setString(3, e.getPackage_Name());
				ps.setString(4, e.getPackage_type());
			    ps.setString(5, e.getInclusions());
			    ps.setString(6,e.getNights());
			    ps.setLong(7, e.getPrice_per_person());
			   
			    int i=ps.executeUpdate();
			    
			    if(i>0) {
			    	out.println("<script type=\"text/javascript\">");
					   out.println("alert('Your package saved to cart!');");
					   out.println("location='UserViewPackages';");
					   out.println("</script>");
			    }
			    
			    else {
			    	out.println("Sorry! unable to save record");
			    }
		  }
	 }
	   catch (Exception e2)
			{
				 System.err.println("Got an exception! ");
	             System.err.println(e2.getMessage());
			}  
	        
		  
	}

}
