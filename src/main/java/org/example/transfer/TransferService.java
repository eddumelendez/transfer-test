package org.example.transfer;

/**
 * @author Eddú Meléndez
 */
public class TransferService {

	private final TransferRepository repository;

	public TransferService(TransferRepository repository) {
		this.repository = repository;
	}
}
