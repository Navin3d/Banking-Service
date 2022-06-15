package gmc.project.bankingsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gmc.project.bankingsystem.entities.TransferEntity;
import gmc.project.bankingsystem.services.TransferServices;

@RestController
@RequestMapping(path = "/bank")
public class BankController {
	
	@Autowired
	private TransferServices transferServcices;
	
	@GetMapping
	private ResponseEntity<List<TransferEntity>> getAllTransfers() {
		List<TransferEntity> returnValue = transferServcices.getAllTransactions();
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
	
	@GetMapping(path = "/transfer/{amount}/{fromAccountId}/{toAccountId}")
	private String transferAmmount(@PathVariable String amount, @PathVariable String fromAccountId, @PathVariable String toAccountId) {
		transferServcices.transferAmount(amount, fromAccountId, toAccountId);
		return "Transfered Successfully";
	}

}
