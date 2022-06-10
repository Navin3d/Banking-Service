package gmc.project.bankingsystem.services;

public interface TransferServices {
	void transferAmount(String amount, String fromAccountId, String toAccountId);
}
