package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoProject {
	@GetMapping("/bhanu")
	public String bhanu() {
		return "Gwalior";
	}
	@GetMapping("/aman")
	public String aman() {
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
		System.out.println("5");
		System.out.println("6");
		System.out.println("7");
		System.out.println("8");
		System.out.println("9");
		System.out.println("10");
		return "jaipur";
	}
	@GetMapping("/amisha")
	public String amisha() {
		return "indore";
	}
}
