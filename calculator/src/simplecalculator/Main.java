package simplecalculator;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("This is calculator. You can write a mathematical example with one of the operators: +,-,*,/,**,%");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number: ");
		double num1 = sc.nextDouble();
		System.out.println("Enter operator: ");
		String operator = sc.next();
		System.out.println("Enter second number: ");				
		double num2 = sc.nextDouble();
		double result = 0;
		switch(operator) {
		case "+": result = num1+num2;
			System.out.println(result);
			break;
		case "-": result = num1-num2;
			System.out.println(result);
			break;
		case "*": result = num1*num2;
			System.out.println(result);
			break;
		case "/": result = num1/num2;
			System.out.println(result);
			break;
		case "**": result = Math.pow(num1, num2);
			System.out.println(result);
			break;
		case "%": result = num1%num2;
			System.out.println(result);
			break;
		default: 
			System.out.println("Operation error");
			break;
		}
	}
}
