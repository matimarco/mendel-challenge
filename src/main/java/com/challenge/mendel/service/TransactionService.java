package com.challenge.mendel.service;

import com.challenge.mendel.model.Transaction;

public interface TransactionService {

    Transaction createTransaction(Transaction transaction) throws Exception;
}
