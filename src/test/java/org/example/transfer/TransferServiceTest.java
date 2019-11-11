package org.example.transfer;

import java.math.BigDecimal;

import org.example.account.AccountRepository;
import org.example.account.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Eddú Meléndez
 */
public class TransferServiceTest {

	private AccountService accountService;

	private TransferRepository transferRepository;

	private TransferService transferService;

	@BeforeEach
	void setup () {
		var accountRepository = new AccountRepository();
		this.accountService = new AccountService(accountRepository);

		this.transferRepository = mock(TransferRepository.class);
		this.transferService = new TransferService(this.accountService, this.transferRepository);
	}

	@Test
	void debitAccountHasEnoughFunds() {
		var debitAccountId = setupAccount("111-1111", BigDecimal.valueOf(100.00));
		var creditAccountId = setupAccount("222-2222", BigDecimal.valueOf(100.00));

		TransferRequest transferRequest = new TransferRequest();
		transferRequest.setDebitAccountId(debitAccountId);
		transferRequest.setCreditAccountId(creditAccountId);
		transferRequest.setAmount("100.00");
		transferRequest.setCurrency("USD");
		this.transferService.transfer(transferRequest);

		var debitAccount = this.accountService.findAccount(debitAccountId);
		var creditAccount = this.accountService.findAccount(creditAccountId);

		assertThat(debitAccount.getBalance()).isEqualTo(new BigDecimal("0.00"));
		assertThat(creditAccount.getBalance()).isEqualTo(new BigDecimal("200.00"));

		verify(this.transferRepository).save(any());
	}

	@Test
	void debitAccountDoesNotHaveEnoughFunds() {
		var debitAccountId = setupAccount("111-1111", BigDecimal.valueOf(50));
		var creditAccountId = setupAccount("222-2222", BigDecimal.valueOf(100));

		TransferRequest transferRequest = new TransferRequest();
		transferRequest.setDebitAccountId(debitAccountId);
		transferRequest.setCreditAccountId(creditAccountId);
		transferRequest.setAmount("100.00");
		transferRequest.setCurrency("USD");

		assertThatThrownBy(() -> this.transferService.transfer(transferRequest))
				.isInstanceOf(IllegalStateException.class)
				.hasMessageContaining("Debit Account doesn't have enough funds.");
	}

	private String setupAccount(String accountNumber, BigDecimal amount) {
		var account = this.accountService.createAccount(accountNumber);
		account.setBalance(amount);
		this.accountService.saveAccount(account);

		return account.getId();
	}

}
