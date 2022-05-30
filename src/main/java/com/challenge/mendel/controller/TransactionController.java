package com.challenge.mendel.controller;

import com.challenge.mendel.model.Transaction;
import com.challenge.mendel.service.TransactionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "TransactionController", description = "REST Apis related to Transaction Entity!!!!")
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transactions")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
        return ResponseEntity.ok().body(this.transactionService.createTransaction(transaction));
    }
}
