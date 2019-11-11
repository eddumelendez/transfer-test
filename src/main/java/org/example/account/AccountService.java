package org.example.account;

import java.util.logging.Logger;

/**
 * @author Eddú Meléndez
 */
public class AccountService {

	private static Logger logger = Logger.getLogger(AccountService.class.getName());

	private final AccountRepository repository;

	public AccountService(AccountRepository repository) {
		this.repository = repository;
	}

	public Account createAccount(String accountNumber) {
		Account account = new Account(accountNumber);
		logger.info("Account " + accountNumber + " created with id " + account.getId());
		this.repository.save(account);
		return account;
	}

	public Account findAccount(String accountId) {
		return this.repository.findAccount(accountId);
	}

	public void saveAccount(Account account) {
		this.repository.save(account);
	}
}
