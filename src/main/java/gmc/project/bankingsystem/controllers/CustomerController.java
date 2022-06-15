package gmc.project.bankingsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gmc.project.bankingsystem.entities.CustomerEntity;
import gmc.project.bankingsystem.services.CustomerServices;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
	
	@Autowired
	private CustomerServices customerServices;
	
	@GetMapping
	private ResponseEntity<List<CustomerEntity>> getAllCustomers() {
		List<CustomerEntity> returnValue = customerServices.getAllCustomers();
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
	
	@GetMapping(path = "/{customerId}")
	private ResponseEntity<CustomerEntity> getACustomers(@PathVariable String customerId) {
		CustomerEntity returnValue = customerServices.getACustomer(customerId);
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}

}
