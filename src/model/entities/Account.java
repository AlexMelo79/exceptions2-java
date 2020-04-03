package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double whithDrawLimite;
	
	public Account(Integer number, String holder, Double balance, Double whithDrawLimite) {
		
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.whithDrawLimite = whithDrawLimite;
	}
	
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWhithDrawLimite() {
		return whithDrawLimite;
	}

	public void withDraw(double amount) {
		balance -= amount; 
		
		if(amount > whithDrawLimite) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		else if(amount > balance) {
			throw new DomainException("Not enough balance");
		}
		
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	@Override
	public String toString() {
		return String.format("%.2f", balance);
	}

}
