package com.challenge.mendel.service;

import com.challenge.mendel.Helper.Helper;
import com.challenge.mendel.exception.ResourceNotFoundException;
import com.challenge.mendel.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {

        Optional<Transaction> transactionList = findTransactionById(transaction);

        if(transactionList.isPresent()){
            for (Transaction trans : transactions) {
                if(trans.getTransactionId() == (transaction.getTransactionId())){
                    trans.setAmount(transaction.getAmount());
                    trans.setType(transaction.getType());
                    trans.setParentId(transaction.getParentId());
                }
            }
            return transaction;
        } else {
            throw new ResourceNotFoundException("Transaction not found with id "+ transaction.getTransactionId());
        }
    }

    public List<Long> getAllTransactionsByType(String type) {
        return transactions.stream().filter(x -> type.equalsIgnoreCase(x.getType())).mapToLong(Transaction::getTransactionId)
                .boxed()
                .collect(Collectors.toList());
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

    public Optional<Transaction> findTransactionById(Transaction transaction) {
        return transactions.stream()
                .filter(x -> transaction.getTransactionId() == x.getTransactionId()).findAny();
    }
}
