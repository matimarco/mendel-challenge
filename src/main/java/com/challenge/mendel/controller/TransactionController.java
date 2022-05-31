package com.challenge.mendel.controller;

import com.challenge.mendel.model.Transaction;
import com.challenge.mendel.service.TransactionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "TransactionController", description = "REST Apis related to Transaction Entity!!!!")
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transactions")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) throws Exception {
        return ResponseEntity.ok().body(this.transactionService.createTransaction(transaction));
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok().body(transactionService.getAllTransactions());
    }

    @PutMapping("/transactions/{transactionId}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long transactionId, @RequestBody Transaction transaction) throws Exception {
        transaction.setTransactionId(transactionId);
        return ResponseEntity.ok().body(transactionService.updateTransaction(transaction));
    }

    @GetMapping("/transactions/types/{type}")
    public ResponseEntity<List<Long>> getAllTransactionsByType(@PathVariable String type) {
        return ResponseEntity.ok().body(transactionService.getAllTransactionsByType(type));
    }

    @GetMapping("/transactions/sum/{transactionId}")
    public ResponseEntity<Double> getSumTransactionsByParent(@PathVariable long transactionId) {
        return ResponseEntity.ok().body(transactionService.getSumTransactionsByParent(transactionId));
    }

}
