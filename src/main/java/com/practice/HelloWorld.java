package com.practice;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number a");
		int a = sc.nextInt();
		System.out.println("Enter the number b");
		int b = sc.nextInt();
		int c =calculate(a,b);
		System.out.println("The addtiong of A and B is: "+c);
		sc.close();

	}

	private static int calculate(int a, int b) {
		int c = a+b;
		return c;
	}

}
