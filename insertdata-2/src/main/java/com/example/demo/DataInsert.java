package com.example.demo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataInsert {

	@PostMapping("/inserdata")
	public String DataBaseConnectivity() throws ClassNotFoundException, SQLException {
          
      	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
		
		String query="insert into categories(CategoryName,Description) VALUES('Indian dishes','Samosas and Vada Pav');";
		Statement st= connection.createStatement();
		 int update=st.executeUpdate(query);
		 
		 return "bhanu";
	}

}
