package com.challenge.mendel;

import com.challenge.mendel.model.Transaction;
import com.challenge.mendel.service.TransactionService;
import org.assertj.core.matcher.AssertionMatcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.util.Assert;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MendelApplicationTests {

	@Autowired
	TransactionService transactionService;


	public void Transaction1() throws Exception {
		Transaction transactions = new Transaction();
		transactions.setTransactionId(10);
		transactions.setAmount(5000);
		transactions.setType("cars");
		transactions.setParentId(0);
		transactionService.createTransaction(transactions);
	}

	public void Transaction2() throws Exception {
		Transaction transactions = new Transaction();
		transactions.setTransactionId(11);
		transactions.setAmount(10000);
		transactions.setType("shopping");
		transactions.setParentId(10);
		transactionService.createTransaction(transactions);
	}

	public void Transaction3() throws Exception {
		Transaction transactions = new Transaction();
		transactions.setTransactionId(12);
		transactions.setAmount(5000);
		transactions.setType("shopping");
		transactions.setParentId(11);
		transactionService.createTransaction(transactions);
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void createSuccessTransactionTest() throws Exception {
		List<Transaction> transactions = new ArrayList<>();
		Transaction transaction = new Transaction();
		transaction.setAmount(5000);
		transaction.setType("CARS");
		transaction.setParentId(2);
		transactions.add(transactionService.createTransaction(transaction));
		Assert.notEmpty(transactions, "List Record Created !!");

	}

	@Test
	public void getAllTransactionsTest() throws Exception {
		List<Transaction> transactions = new ArrayList<>();
		createSuccessTransactionTest();
		transactionService.getAllTransactions();
		Assert.notEmpty(transactions, "Success !!");
	}

	@Test
	public void updateTransactionTest() throws Exception {
		Transaction transaction = new Transaction();
		createSuccessTransactionTest();
		transaction.setType("MOTOS");
		Transaction result = transactionService.updateTransaction(transaction);

		assertThat(result.getType(), is("MOTOS"));
	}

	@Test
	public void getAllTransactionsByTypeTets() throws Exception {
		createSuccessTransactionTest();
		List<Long> result = transactionService.getAllTransactionsByType("CARS");
		Assert.notEmpty(result, "Long Array");

	}

	@Test
	public void getSumTransactionsByParentTest1() throws Exception {
		Transaction1();
		Transaction2();
		Transaction3();
		Double result = transactionService.getSumTransactionsByParent(10);

		assertThat(result.toString(), is("20000.0"));

		Double result1 = transactionService.getSumTransactionsByParent(11);

		assertThat(result1.toString(), is("15000.0"));

	}


}
