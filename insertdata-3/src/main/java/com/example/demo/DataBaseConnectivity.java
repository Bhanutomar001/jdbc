package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataBaseConnectivity {
	
	
	

	@PostMapping("/inserdata")

	public int insertData() throws ClassNotFoundException, SQLException {
		          
		      	Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
				
				String query="insert into categories(CategoryName,Description) VALUES('Indian dishes','Samosas and Vada Pav');";
				Statement st= connection.createStatement();
				 int update=st.executeUpdate(query);
				 
				 return update;
			}
	
	@PostMapping("/insertemployeesdata")
	public int employeesData() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
		System.out.println("connection establish");
	     
		
		String query ="insert into employees (LastName, FirstName) values ('chouhan', 'Ram');";
	     Statement st=connection.createStatement();
		    int update = st.executeUpdate(query);
		    
			return update;
			
	}
	      
	      @PostMapping("/inserdatacustomers") 
	      public int customersData() throws ClassNotFoundException, SQLException {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
				
	    	String query="Insert Into customers(CustomerName ,Address) VALUES('Pratibha chouhan', 'Indore');";
	    	Statement st= connection.createStatement();
			 int update=st.executeUpdate(query);
			 
			 return update;
		
	      }
	      
	      @PostMapping("/insertshippersids") 
	      public int shippersDetailsData() throws ClassNotFoundException, SQLException {
	    	  Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
				
	    	String query="Insert into shippers(ShipperName , ShipperID) VALUES('Kevin',39);";
	    	Statement st= connection.createStatement();
			 int update=st.executeUpdate(query);
			 
			 return update;
		
	      }
	
	}



