package com.smallworld.transaction.Controller;

import com.smallworld.transaction.Service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TransactionController {

    @Autowired
    TransactionService tService;

    @GetMapping("/getTotalTransactionAmount")
    public double getTotalTransactionAmount() throws IOException {

       double result = tService.getTotalTransactionAmount();

       return result;
    }


    @GetMapping("/getTotalTransactionAmountSentBy{name}")
    public double getTotalTransactionAmountSentBy(@PathVariable("name") String name) throws IOException {

       double result = tService.getTotalTransactionAmountSentBy(name);

       return result;
    }
}
