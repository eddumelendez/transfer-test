package org.example.transfer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Eddú Meléndez
 */
public class Transfer {

	private String creditAccountId;

	private String debitAccountId;

	private BigDecimal amount;

	private String currency;

	private LocalDateTime dateTime;

	public Transfer() {
		this.dateTime = LocalDateTime.now();
	}

	public String getCreditAccountId() {
		return this.creditAccountId;
	}

	public void setCreditAccountId(String creditAccountId) {
		this.creditAccountId = creditAccountId;
	}

	public String getDebitAccountId() {
		return this.debitAccountId;
	}

	public void setDebitAccountId(String debitAccountId) {
		this.debitAccountId = debitAccountId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDateTime getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
