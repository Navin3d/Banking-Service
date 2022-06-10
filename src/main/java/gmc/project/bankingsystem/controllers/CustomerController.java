package gmc.project.bankingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import gmc.project.bankingsystem.entities.CustomerEntity;
import gmc.project.bankingsystem.services.CustomerServices;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
	
	@Autowired
	private CustomerServices customerServices;
	
	@GetMapping
	private String getAllCustomers(Model model) {
		customerServices.getAllCustomers();
		return "index";
	}
	
	@GetMapping(path = "/{customerId}")
	private String getAllCustomers(Model model, @PathVariable String customerId) {
		CustomerEntity foundCustomer = customerServices.getACustomer(customerId);
		model.addAttribute("customer", foundCustomer);
		return "/customer/single";
	}

}
