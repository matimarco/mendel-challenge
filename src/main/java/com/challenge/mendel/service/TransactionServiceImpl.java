package com.challenge.mendel.service;

import com.challenge.mendel.Helper.Helper;
import com.challenge.mendel.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final static Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

    List<Transaction> transactions = new ArrayList<>();

    @Override
    public Transaction createTransaction(Transaction transaction) throws Exception{
        return saveTransaction(transaction);
    }

    public Transaction saveTransaction(Transaction transaction) throws Exception {
        try {
            transaction.setTransactionId(Helper.getGeneratedLong());
            transactions.add(transaction);
        } catch (Exception ex) {
            LOGGER.error("There was a problem Trying to save Transaction " + ex.getMessage(), ex);
            throw new Exception("Number of Transaction" + transaction.getTransactionId());

        }
        return transaction;
    }
}
