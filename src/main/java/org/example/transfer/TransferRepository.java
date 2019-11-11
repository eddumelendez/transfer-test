package org.example.transfer;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Eddú Meléndez
 */
public class TransferRepository {

	Map<String, List<Transfer>> transfers = new ConcurrentHashMap<>();

	public void save(Transfer transfer) {
		var debitAccountId = transfer.getDebitAccountId();

		if (this.transfers.containsKey(debitAccountId)) {
			List<Transfer> transfers = this.transfers.getOrDefault(debitAccountId, Collections.emptyList());
			transfers.add(transfer);
			this.transfers.put(debitAccountId, transfers);
		}
		else {
			var transfers = List.of(transfer);
			this.transfers.put(debitAccountId, transfers);
		}
	}

}
