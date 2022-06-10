package gmc.project.bankingsystem.services;

import java.util.List;

import gmc.project.bankingsystem.entities.CustomerEntity;

public interface CustomerServices {
	List<CustomerEntity> getAllCustomers();
	CustomerEntity getACustomer(String customerId);
}
