package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccessTables {
        @GetMapping("/api")
	public String accessDataFromTables() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
			System.out.println("connection establish");
		     
			String query ="select*From employees";
		     Statement st=connection.createStatement();
			    ResultSet rs=st.executeQuery(query);
			    
			    while(rs.next()) {
			    	System.out.print(rs.getInt("EmployeeID")+" ");
			    	System.out.print(rs.getString("FirstName")+" ");
			    	System.out.println(rs.getString("LastName")+" ");
			    	System.out.println(rs.getDate("BirthDate")+" ");
			    	System.out.println(rs.getString("Photo")+" ");
			    	System.out.println(rs.getString("Notes")+"||");

			    }
				return query;
				
		}
	}


