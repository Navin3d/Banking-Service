package gmc.project.bankingsystem.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmc.project.bankingsystem.dao.CustomerDao;
import gmc.project.bankingsystem.dao.TransferDao;
import gmc.project.bankingsystem.entities.CustomerEntity;
import gmc.project.bankingsystem.entities.TransferEntity;
import gmc.project.bankingsystem.services.TransferServices;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransferServicesImpl implements TransferServices {

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private TransferDao transferDao;
	
	@Override
	public void transferAmount(String amount, String fromAccountId, String toAccountId) {
		Long actualAmount = Long.valueOf(amount);
		
		CustomerEntity fromCustomer = customerDao.findById(fromAccountId).get();
		CustomerEntity toCustomer = customerDao.findById(toAccountId).get();

		fromCustomer.setCurrentBalance(fromCustomer.getCurrentBalance() - actualAmount);
		toCustomer.setCurrentBalance(toCustomer.getCurrentBalance() + actualAmount);

		TransferEntity transfered = new TransferEntity();
		transfered.setTransferAmount(actualAmount);
		transfered.setTransferedFrom(fromCustomer);
		transfered.setTransferedTo(toCustomer);
		
		log.error("Autual Amount: {}.", actualAmount);
		
		transferDao.save(transfered);
		customerDao.save(fromCustomer);
		customerDao.save(toCustomer);
		
	}

	@Override
	public List<TransferEntity> getAllTransactions() {
		List<TransferEntity> returnValue = transferDao.findAll();
		return returnValue;
	}

}
