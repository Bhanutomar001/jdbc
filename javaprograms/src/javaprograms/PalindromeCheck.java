package javaprograms;

import java.util.Scanner;

public class PalindromeCheck {

	public static void main(String[] args){
		
	
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		System.out.println("Enter your name:"+name);
		
         String rvs="";
		for(int i=name.length()-1; i>=0; i--) {
			rvs+=name.charAt(i);	
		}
		System.out.println("reverse name is :"+rvs);
		if(name.equals(rvs)) {
			System.out.println("Name is palindrome");
		}else {
			System.out.println("Name is not Palindrome");
		}
	}

}
