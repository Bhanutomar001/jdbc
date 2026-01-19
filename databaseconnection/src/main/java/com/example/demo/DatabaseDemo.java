package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DatabaseDemo {


@GetMapping("/select")
public String database() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
	System.out.println("connection establish");
     
	//String query ="select*From employees WHERE EmployeeID=1";
	String query ="select*From employees";
     Statement st=connection.createStatement();
	    ResultSet rs=st.executeQuery(query);
	    
	    while(rs.next()) {
	    	System.out.println(rs.getInt("EmployeeID"));
	    	System.out.println(rs.getString("LastName"));
	    	System.out.println(rs.getString("FirstName"));


	    }
		return query;
		
}

  
    	
    
@GetMapping("/insert")
public int databaseInsert() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
	System.out.println("connection establish");
     
	//String query ="select*From employees WHERE EmployeeID=1";
	String query ="insert into employees (LastName, FirstName) values ('Bhanu', 'Tomar');";
     Statement st=connection.createStatement();
	    int update = st.executeUpdate(query);
	    
		return update;
		
}


@GetMapping("/insertDynamicValues")
public int databaseInsertValues(String name, String sname) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
	System.out.println("connection establish");
     
	//String query ="select*From employees WHERE EmployeeID=1";
	String query ="insert into employees (LastName, FirstName) values (?, ?)";
     
	PreparedStatement ps = connection.prepareStatement(query);
	ps.setString(1, name);
	ps.setString(2, sname);
     
	    int update = ps.executeUpdate();
	    
		return update;
		
}


@PostMapping("/insertDynamicValuesFromUser")
public int databaseInsertValues2( @RequestBody Hello h) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/W3schools", "root", "root");
	System.out.println("connection establish");
     
	//String query ="select*From employees WHERE EmployeeID=1";
	String query ="insert into employees (LastName, FirstName) values (?, ?)";
     
	PreparedStatement ps = connection.prepareStatement(query);
	
	ps.setString(1, h.getLastName());
	ps.setString(2, h.getName());
     
	    int update = ps.executeUpdate();
	    
		return update;
		
}



//public static void main(String[] args) {
//	DatabaseDemo  d = new DatabaseDemo();
//	d.database();
//	System.out.println(d.databaseInsert());
//	System.out.println(d.databaseInsertValues());
//System.out.println(d.databaseInsertValues2("Anjana", "Sengar"));
// 	}

}
