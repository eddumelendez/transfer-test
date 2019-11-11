package org.example.transfer;

import org.json.JSONObject;

import static spark.Spark.before;
import static spark.Spark.halt;
import static spark.Spark.post;

public class Main {

	public static void main(String[] args) {
		var transferRepository = new TransferRepository();
		var transferService = new TransferService(transferRepository);
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
	}
}
