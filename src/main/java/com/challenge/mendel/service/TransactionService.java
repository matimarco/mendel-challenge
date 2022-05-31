package com.challenge.mendel.service;

import com.challenge.mendel.model.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction createTransaction(Transaction transaction) throws Exception;

    List<Transaction> getAllTransactions();

    Transaction updateTransaction(Transaction transaction);
}
