package org.example.transfer;

import org.json.JSONObject;
import spark.Request;
import spark.Response;

public class TransferController {

	private final TransferService repository;

	public TransferController(TransferService repository) {
		this.repository = repository;
	}

	JSONObject performTransfer(Request request, Response response) {
		var json = new JSONObject(request.body());
		return null;
	}

}
