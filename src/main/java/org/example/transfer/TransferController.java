package org.example.transfer;

import org.json.JSONObject;
import spark.Request;
import spark.Response;

public class TransferController {

	private final TransferService service;

	public TransferController(TransferService service) {
		this.service = service;
	}

	public String performTransfer(Request request, Response response) {
		var json = new JSONObject(request.body());

		var transferRequest = new TransferRequest();
		transferRequest.setCreditAccountId(json.getString("credit_account_id"));
		transferRequest.setDebitAccountId(json.getString("debit_account_id"));
		transferRequest.setAmount(json.getString("amount"));
		transferRequest.setCurrency(json.getString("currency"));

		this.service.transfer(transferRequest);

		response.status(200);
		return "You have transferred successfully!";
	}

}
