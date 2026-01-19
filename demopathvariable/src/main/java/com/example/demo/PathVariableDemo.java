package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableDemo {
   
		@GetMapping("/amisha/{age}")
		public Person amisha(@PathVariable  Integer age) {
			Person p1=new Person();
			p1.setName("Amisha Tomar");
			p1.setAge(age);	
			p1.setPlace("indore");
			return p1;		
		}
		
		@GetMapping("/aman")
		public Person aman() {
			Person p2=new Person();
			p2.setName("Aman Tomar");
			p2.setAge(29);
			p2.setPlace("Singapore");
			return p2;		
		}	
	}
