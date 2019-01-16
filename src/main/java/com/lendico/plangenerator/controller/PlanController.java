package com.lendico.plangenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lendico.plangenerator.model.*;
import com.lendico.plangenerator.service.PlanCalculationService;

@RestController
@RequestMapping("/generate-plan")
public class PlanController {
	
	@Autowired
	PlanCalculationService planCalculationService;
	
	@RequestMapping(method=RequestMethod.POST , value="/" , produces="application/json", consumes="application/json")
	public List<PaymentDetails> calculatePaymentDetails(@RequestBody LoanDetails loanDetails){
		 return planCalculationService.getPaymentDetails(loanDetails);
		
	}
}
