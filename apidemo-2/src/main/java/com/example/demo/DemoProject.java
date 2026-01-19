package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoProject {

	@GetMapping("/amisha")
	public Person amisha() {
		Person p1=new Person();
		p1.setName("Amisha Tomar");
		p1.setAge(28);
		p1.setMobile(73540000);
		p1.setCompany("Yash Technology");
		return p1;		
	}
	
	@GetMapping("/aman")
	public Person aman() {
		Person p2=new Person();
		p2.setName("Aman Tomar");
		p2.setAge(29);
		p2.setMobile(73540000);
		p2.setCompany("Autodesk");
		return p2;		
	}

	
}
