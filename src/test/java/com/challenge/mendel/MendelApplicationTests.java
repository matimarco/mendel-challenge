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
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MendelApplicationTests {

	@Autowired
	TransactionService transactionService;
	Transaction transaction = new Transaction();
	List<Transaction> transactions = new ArrayList<>();


	public Transaction firstTransaction() {
		transaction.setTransactionId(1);
		transaction.setAmount(1000);
		transaction.setType("SHOPPING");
		transaction.setParentId(1);
		transactions.add(transaction);
		return transaction;
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void createSuccessTransactionTest() throws Exception {
		transaction.setAmount(5000);
		transaction.setType("CARS");
		transaction.setParentId(2);
		transactions.add(transactionService.createTransaction(transaction));
		Assert.notEmpty(transactions, "List Record Created !!");

	}

	@Test
	public void getAllTransactionsTest() throws Exception {
		createSuccessTransactionTest();
		transactionService.getAllTransactions();
		Assert.notEmpty(transactions, "Success !!");
	}

	@Test
	public void updateTransactionTest() throws Exception {
		createSuccessTransactionTest();
		transaction.setType("MOTOS");
		Transaction result = transactionService.updateTransaction(transaction);

		assertThat(result.getType(), is("MOTOS"));
	}


}
