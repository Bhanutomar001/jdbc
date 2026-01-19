package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@GetMapping("/{name}")
	public Person aman(@PathVariable String name) {
		  
		Person p=new Person();
		System.out.println("TTTTTTomar");
		if(name.equals("aman")) {
		p.setName("Aman Tomar");
		p.setAge(29);
		p.setPlace("Jaipur");
	   }else if(name.equals("amisha")) {
		p.setName("Amisha Tomar");
		p.setAge(27);
		p.setPlace("Indore");	
	}else if(name.equals("bhanu")) {
		p.setName("Bhanu Tomar");
		p.setAge(24);
		p.setPlace("Gwalior");
	}else if(name.equals("anjana")) {
		p.setName("Anjana sengar");
		p.setAge(23);
		p.setPlace("Ahmdabad");		
	}
		System.out.println();
		return p;
   }
}
