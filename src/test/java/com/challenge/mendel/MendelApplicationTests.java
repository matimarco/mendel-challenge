package com.challenge.mendel;

import com.challenge.mendel.model.Transaction;
import com.challenge.mendel.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MendelApplicationTests {

	@Autowired
	TransactionService transactionService;
	Transaction transaction = new Transaction();
	List<Transaction> transactions = new ArrayList<>();

	@Test
	void contextLoads() {
	}

	@Test
	public void createTransactionTest() throws Exception {
		transaction.setTransactionId(1);
		transaction.setAmount(5000);
		transaction.setType("CARS");
		transaction.setParentId(1);
		transactions.add(transactionService.createTransaction(transaction));
		Assert.notEmpty(transactions, "List Record Created !!");

	}

}
