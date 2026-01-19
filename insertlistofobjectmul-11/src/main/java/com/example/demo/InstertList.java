package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstertList {

	  @PostMapping("/insert")
	 	public List<Hello> dataBaseConnection1(@RequestBody Hello product) throws ClassNotFoundException, SQLException {
	     	 Class.forName("com.mysql.cj.jdbc.Driver");
	     	 Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
	     	 
	     	 String query="insert into customers (CustomerName ,City ) values (?, ?)";
	     
	     	 PreparedStatement ps=connection.prepareStatement(query);
	     	 
	     	   
	    
	     	 
	     	
	        ps.setString(1, product.getCustomername());
	        ps.setString(2, product.getCity());
	     	
	              connection.setAutoCommit(false);

	     	      int update=ps.executeUpdate();
	     	      
	     	      
	     		 String query1="select * from customers where city=?";
	          	 PreparedStatement ps4=connection.prepareStatement(query1);
	          	 ps4.setString(1,  product.getCity());
	           
	          	 ResultSet rs=ps4.executeQuery();
	          	 
	             List<Hello> customers = new ArrayList<>();
	          	 while(rs.next()) {
	          		Hello c= new Hello();

	          		c.setCustomername(rs.getString("CustomerName"));
	          		c.setCity(rs.getString("City"));
	          		customers.add(c);
	          	 }
	     	      
	     	      connection.commit();
	     	      ps4.close();
	     	      connection.close();
	 	    
 
	     	      return customers;
	     }
		
	}


