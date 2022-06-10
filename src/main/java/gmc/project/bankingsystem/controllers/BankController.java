package gmc.project.bankingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import gmc.project.bankingsystem.services.TransferServices;

@Controller
@RequestMapping(path = "/bank")
public class BankController {
	
	@Autowired
	private TransferServices transferServcices;
	
	@GetMapping(path = "/tranfer/{amount}/{fromAccountId}/{toAccountId}")
	private String transferAmmount(@PathVariable String amount, @PathVariable String fromAccountId, @PathVariable String toAccountId) {
		transferServcices.transferAmount(amount, fromAccountId, toAccountId);
		return "redirect:/index";
	}

}
