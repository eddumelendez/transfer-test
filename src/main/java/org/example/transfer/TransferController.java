package org.example.transfer;

import org.json.JSONObject;
import spark.Request;
import spark.Response;

public class TransferController {

	JSONObject performTransfer(Request request, Response response) {
		var json = new JSONObject(request.body());
		return null;
	}

}