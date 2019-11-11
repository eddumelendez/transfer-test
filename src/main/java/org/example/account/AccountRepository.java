package org.example.account;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Eddú Meléndez
 */
public class AccountRepository {

	private Map<String, Account> accounts = new ConcurrentHashMap<>();

	public void save(Account account) {
		this.accounts.put(account.getId(), account);
	}

	public Account findAccount(String accountId) {
		if (this.accounts.containsKey(accountId)) {
			return this.accounts.get(accountId);
		}
		throw new AccountNumberNotFoundException();
	}

}
