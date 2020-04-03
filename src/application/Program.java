package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double whithDrawLimite = sc.nextDouble();
		
		Account account = new Account(number, holder, balance, whithDrawLimite);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		account.withDraw(amount);
		System.out.println("New balance: " + account.toString());
		
		System.out.println();
		System.out.print("Enter amount for deposit: ");
		amount = sc.nextDouble();
		account.deposit(amount);
		System.out.println("New balance: " + account.toString());
		
		}
		catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error!");
		} 
		sc.close();
		

	}

}
