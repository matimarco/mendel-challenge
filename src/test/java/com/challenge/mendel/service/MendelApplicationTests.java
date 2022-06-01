package com.challenge.mendel.service;

import com.challenge.mendel.model.Transaction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.util.Assert;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MendelApplicationTests {

	@Autowired
	TransactionService transactionService;




	private final Transaction trans1 = new Transaction(10, 1000, "cars", null);
	private final Transaction trans2 = new Transaction(11, 2000, "cars", 10L);
	private final Transaction trans3 = new Transaction(12, 3000, "cars", 11L);


    @BeforeEach
	public void init() throws Exception {
    	if(transactionService.getAllTransactions().isEmpty()) {
			transactionService.createTransaction(trans1);
			transactionService.createTransaction(trans2);
			transactionService.createTransaction(trans3);
		}

	}

	@Test
	public void createSuccessTransactionTest() throws Exception {
		List<Transaction> transactions = new ArrayList<>();
		Transaction transaction = new Transaction();
		transaction.setTransactionId(1);
		transaction.setAmount(5000);
		transaction.setType("CARS");
		transaction.setParentId(2L);
		transactions.add(transactionService.createTransaction(transaction));
		Assert.notEmpty(transactions, "List Record Created !!");

	}

	@Test
	public void getAllTransactionsTest() throws Exception {
		List<Transaction> result = transactionService.getAllTransactions();
		Assert.notEmpty(result, "Success !!");
	}

	@Test
	public void getAllTransactionsByTypeTest() throws Exception {
		List<Long> result = transactionService.getAllTransactionsByType("cars");
		Assert.notEmpty(result, "Long Array");

	}


	@Test
	void getTransactionsSum() {
		Double result = transactionService.getSumTransactionsByParent(10L);
		assertThat(result.toString(), is("1000.0"));
	}


}
