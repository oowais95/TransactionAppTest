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

        return tService.getTotalTransactionAmount();

    }


    @GetMapping("/getTotalTransactionAmountSentBy{name}")
    public double getTotalTransactionAmountSentBy(@PathVariable("name") String name) throws IOException {
 
       return tService.getTotalTransactionAmountSentBy(name);
    }

    @GetMapping("/getMaxTransactionAmount")
    public double getMaxTransactionAmount() throws IOException {

         
       return  tService.getMaxTransactionAmount();

    }

    
    @GetMapping("/countUniqueClients")
    public long countUniqueClients() throws IOException {

       return tService.countUniqueClients();
    }

    @GetMapping("/hasOpenComplianceIssues")
    public boolean hasOpenComplianceIssues(@PathVariable("name") String name) throws IOException {

       return tService.hasOpenComplianceIssues(name);
    }



    @GetMapping("/getTopSender")
    public String getTopSender() throws IOException {

       return tService.getTopSender();
    }

    //other not implemented as it wasnt a requirement

}
