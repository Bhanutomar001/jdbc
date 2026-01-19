package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseConnection {

	@PostMapping("/insertdata")
	public int connection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
		
		String query="Insert into categories(CategoryId , CategoryName) VALUES(9 ,'Dessert');";
		Statement st= connection.createStatement();
		 int update=st.executeUpdate(query);
		 
		 if(update==1) {
			 System.out.println("Query excuted");
		 }else if(update==0) {
			System.out.println("Query not excuted"); 
		 }else {
			 System.out.println("other issue");
		 }
		return update;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DatabaseConnection dc = new DatabaseConnection();
		dc.connection();
	}

}
