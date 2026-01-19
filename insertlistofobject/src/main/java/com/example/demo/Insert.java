package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Insert {

	  @PostMapping("/url")
	 	public Hello dataBaseConnection1(@RequestBody List<Hello> product) throws ClassNotFoundException, SQLException {
	     	 Class.forName("com.mysql.cj.jdbc.Driver");
	     	 Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
	     	 
	     	 String query="insert into products (ProductID, ProductName) values (?, ?)";
	     	 PreparedStatement ps=connection.prepareStatement(query);
	     	 
	     	   
	     	List<Hello> list = new ArrayList<>();
	     	 Hello P1=product.get(0);
	     	 
	     	ps.setInt(1, P1.getId());
	        ps.setString(2, P1.getName());
	     	
//	     	list1.setProductID();
//			list1.getProductName();
//			list.add(list1);
	     	
	     	
	     	
	     	
	     	
	     	
	     	
	     	
	     	
	     	
	              connection.setAutoCommit(false);

	     	      int update=ps.executeUpdate();
	     	      connection.commit();
	     	      ps.close();
	     	      connection.close();
	 	    
 
	     	      return P1;
	     }
		
	}


