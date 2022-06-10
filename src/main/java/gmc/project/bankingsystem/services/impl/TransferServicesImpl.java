package gmc.project.bankingsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmc.project.bankingsystem.dao.CustomerDao;
import gmc.project.bankingsystem.entities.CustomerEntity;
import gmc.project.bankingsystem.services.TransferServices;

@Service
public class TransferServicesImpl implements TransferServices {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public void transferAmount(String amount, String fromAccountId, String toAccountId) {
		Long actualAmount = Long.valueOf(amount);
		
		CustomerEntity fromCustomer = customerDao.findById(fromAccountId).get();
		CustomerEntity toCustomer = customerDao.findById(fromAccountId).get();

		fromCustomer.setCurrentBalance(fromCustomer.getCurrentBalance() - actualAmount);
		toCustomer.setCurrentBalance(toCustomer.getCurrentBalance() + actualAmount);

		customerDao.save(fromCustomer);
		customerDao.save(toCustomer);
		
	}

}
