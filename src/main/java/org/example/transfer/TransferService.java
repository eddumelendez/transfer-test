package org.example.transfer;

import java.math.BigDecimal;

import org.example.account.Account;
import org.example.account.AccountService;

/**
 * @author Eddú Meléndez
 */
public class TransferService {

	private final AccountService accountService;

	private final TransferRepository repository;

	public TransferService(AccountService accountService, TransferRepository repository) {
		this.accountService = accountService;
		this.repository = repository;
	}

	public void transfer(TransferRequest transferRequest) {
		var transferAmount = new BigDecimal(transferRequest.getAmount());
		var debitAccount = this.accountService.findAccount(transferRequest.getDebitAccountId());
		if (hasEnoughFunds(debitAccount, transferAmount)) {
			var creditAccount = this.accountService.findAccount(transferRequest.getCreditAccountId());

			calculateBalance(debitAccount, transferAmount.negate());
			calculateBalance(creditAccount, transferAmount);

			var transfer = new Transfer();
			transfer.setCreditAccountId(creditAccount.getId());
			transfer.setDebitAccountId(debitAccount.getId());
			transfer.setAmount(transferAmount);
			transfer.setCurrency(transferRequest.getCurrency());
			this.repository.save(transfer);
			return;
		}
		throw new IllegalStateException("Debit Account doesn't have enough funds.");
	}

	private boolean hasEnoughFunds(Account debitAccount, BigDecimal amount) {
		return debitAccount.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) >= 0;
	}

	private void calculateBalance(Account account, BigDecimal amount) {
		BigDecimal currentBalance = account.getBalance();
		BigDecimal newBalance = currentBalance.add(amount);
		account.setBalance(newBalance);
		this.accountService.saveAccount(account);
	}
}
