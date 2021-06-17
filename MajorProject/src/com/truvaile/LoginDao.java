package com.truvaile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LoginDao")
public class LoginDao{
       
	public static boolean validate(String username, String password) {
		boolean status=false;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/truvaileDB?useSSL=false","root","root");
		
		PreparedStatement ps = con.prepareStatement("select * from Users where `User_name`= ? and `Password` =?");
		
		ps.setString(1,username);
		ps.setString(2,password);
		
		ResultSet rs = ps.executeQuery();
		status = rs.next();
			}
	
	  catch(Exception e)
	{ System.out.println(e);}
	return status;
	}
 }
