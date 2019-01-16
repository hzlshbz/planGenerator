package com.lendico.plangenerator;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lendico.plangenerator.model.LoanDetails;
import com.lendico.plangenerator.service.PlanCalculationService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanGeneratorApplicationTests {
	@Autowired
	PlanCalculationService planCalculationService;
	
	@Test
	public void contextLoads() {
		LoanDetails details = new LoanDetails();
		details.setDuration(24);
		details.setLoanAmount(5000);
		details.setNominalRate(5);
		details.setStartDate("2018-01-01T00:00:01Z");
		Assert.assertEquals("not equals",planCalculationService.getPaymentDetails(details).size(), 24);
	}

}

