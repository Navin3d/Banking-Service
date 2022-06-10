package gmc.project.bankingsystem.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmc.project.bankingsystem.dao.CustomerDao;
import gmc.project.bankingsystem.entities.CustomerEntity;
import gmc.project.bankingsystem.services.CustomerServices;

@Service
public class CustomerServicesimpl implements CustomerServices {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<CustomerEntity> getAllCustomers() {
		List<CustomerEntity> returnVlaue = customerDao.findAll();
		return returnVlaue;
	}

	@Override
	public CustomerEntity getACustomer(String customerId) {
		CustomerEntity returnVlaue = customerDao.findById(customerId).get();
		return returnVlaue;
	}

}
