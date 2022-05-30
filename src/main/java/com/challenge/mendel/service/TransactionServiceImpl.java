package com.challenge.mendel.service;

import com.challenge.mendel.Helper.Helper;
import com.challenge.mendel.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    List<Transaction> transactions = new ArrayList<>();

    @Override
    public Transaction createTransaction(Transaction transaction){
        return saveTransaction(transaction);
    }

    public Transaction saveTransaction(Transaction transaction) {
        transaction.setTransactionId(Helper.getGeneratedLong());
        transactions.add(transaction);
        return transaction;
    }
}
