package org.example.transfer;

/**
 * @author Eddú Meléndez
 */
public class TransferRequest {

	private String creditAccountId;

	private String debitAccountId;

	private String amount;

	private String currency;

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

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
