package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PutData {
	@PostMapping("/insert")
	public Hello InsertDataBas(@RequestBody Hello h) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
		 
		String query="Insert into products(ProductID , ProductName, Price) VALUES (?,?,?)";
		PreparedStatement st= connection.prepareStatement(query);
	
		    st.setInt(1,h.getProductid());
		    st.setString(2,h.getProductname());
		    st.setLong(3,h.getPrice());
		    
		    int update=st.executeUpdate();
		    
		    st.close();
		    connection.close();
		return h;
	}

}
