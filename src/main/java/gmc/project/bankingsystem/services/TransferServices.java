package gmc.project.bankingsystem.services;

import java.util.List;

import gmc.project.bankingsystem.entities.TransferEntity;

public interface TransferServices {
	void transferAmount(String amount, String fromAccountId, String toAccountId);
	List<TransferEntity> getAllTransactions();
}
