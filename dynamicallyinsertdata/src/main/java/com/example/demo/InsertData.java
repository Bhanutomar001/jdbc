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
public class InsertData {
     @PostMapping("/insetvalue")
	public int dataBaseConnection() throws ClassNotFoundException, SQLException {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
    	 
    	 String query="insert into suppliers (SupplierName, ContactName) values (?, ?)";
    	 PreparedStatement ps=connection.prepareStatement(query);
	      
    	 String name="ruchi";
    	 String cname="Pratibha";
    	      ps.setString( 1, name); 
    	      ps.setString( 2, cname); 
    	      
    	      connection.setAutoCommit(false);

    	      int update=ps.executeUpdate();
    	      connection.commit();
    	      ps.close();
    	      connection.close();
	    
//    	      if (update==1) {
//    	    	  System.out.println("Query Excuted");
//    	      }else {
//    	    	  System.out.println("Query not excuted");
//    	      }
    	      
    	      return update;
      
	}
      
     @PostMapping("/url")
 	public Hello dataBaseConnection1(@RequestBody List <Hello> b) throws ClassNotFoundException, SQLException {
     	 Class.forName("com.mysql.cj.jdbc.Driver");
     	 Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
     	 
     	 String query="insert into suppliers (Address, City) values (?, ?)";
     	 PreparedStatement ps=connection.prepareStatement(query);
 	      

     	      ps.setString( 1,  ((Hello) b).getAddress()); 
     	      ps.setString( 2, ((Hello) b).getCity()); 

     	   
              connection.setAutoCommit(false);

     	      int update=ps.executeUpdate();
     	      connection.commit();
     	      ps.close();
     	      connection.close();
     	      
     	      return (Hello) b;
     }
	
}