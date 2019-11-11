package org.example;

import java.util.List;

import org.example.account.AccountRepository;
import org.example.account.AccountService;
import org.example.transfer.TransferController;
import org.example.transfer.TransferRepository;
import org.example.transfer.TransferService;
import org.json.JSONObject;

import static spark.Spark.before;
import static spark.Spark.exception;
import static spark.Spark.halt;
import static spark.Spark.post;

public class Main {

	public static void main(String[] args) {
		var accountRepository = new AccountRepository();
		var accountService = new AccountService(accountRepository);

		List.of("111-1111", "222-2222")
				.forEach(accountService::createAccount);

		var transferRepository = new TransferRepository();
		var transferService = new TransferService(accountService, transferRepository);
		var transferController = new TransferController(transferService);

		before(((request, response) -> {
			if (request.requestMethod().equals("POST") &&
					!"application/json".equals(request.contentType())) {
				halt(406, new JSONObject().put(
						"error", "Only application/json supported"
				).toString());
			}
		}));

		post("/transfers", transferController::performTransfer);

		exception(IllegalStateException.class, (exception, request, response) -> response.body(exception.getMessage()));
	}
}
