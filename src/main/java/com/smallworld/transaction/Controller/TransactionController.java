package com.smallworld.transaction.Controller;

import com.smallworld.transaction.POJOS.Transaction;
import com.smallworld.transaction.Service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Set;

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

    @GetMapping("/hasOpenComplianceIssues{name}")
    public boolean hasOpenComplianceIssues(@PathVariable("name") String name) throws IOException {

       return tService.hasOpenComplianceIssues(name);
    }



    @GetMapping("/getTopSender")
    public String getTopSender() throws IOException {

       return tService.getTopSender();
    }

    @GetMapping("/getUnsolvedIssueIds")
    public Set<Integer> getUnsolvedIssueIds() throws IOException {

       return tService.getUnsolvedIssueIds();
    }


    
    @GetMapping("/getTop3TransactionsByAmount")
    public List<Transaction> getTop3TransactionsByAmount() throws IOException {

       return tService.getTop3TransactionsByAmount();
    }
    

    //other not implemented as it wasnt a requirement

}
