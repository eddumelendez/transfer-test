package org.example.transfer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Eddú Meléndez
 */
public class AccountRepository {

	private Map<String, Account> accounts = new ConcurrentHashMap<>();

	public void add(Account account) {
		this.accounts.put(account.getAccountNumber(), account);
	}

	public Account getAccount(String accountNumber) {
		if (this.accounts.containsKey(accountNumber)) {
			return this.accounts.get(accountNumber);
		}
		throw new AccountNumberNotFoundException();
	}

	public void save(Account account) {
		this.accounts.put(account.getAccountNumber(), account);
	}

}
