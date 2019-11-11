package org.example.account;

import java.math.BigDecimal;
import java.util.UUID;

public class Account {

	private String id;

	private String accountNumber;

	private BigDecimal balance;

	public Account(String accountNumber) {
		this.id = UUID.randomUUID().toString();
		this.accountNumber = accountNumber;
		this.balance = BigDecimal.valueOf(100.00);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
