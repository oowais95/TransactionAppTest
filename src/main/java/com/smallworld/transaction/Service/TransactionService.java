package com.smallworld.transaction.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smallworld.transaction.POJOS.TransactionIssue;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    UtilService utilService;


    /**
     * Returns the sum of the amounts of all transactions
     */
    public double getTotalTransactionAmount() throws IOException {

        double totalTotalTransactionAmout = 0;
        String  jsonResponse = utilService.readText("../../transaction/transactions.json");
        //JsonNode jsonNode =  mapper.readTree(jsonResponse);

        List<TransactionIssue> transactionIssues  = mapper.readValue(jsonResponse, new TypeReference<List<TransactionIssue>>() {});

        for (TransactionIssue tIssues : transactionIssues) {
            totalTotalTransactionAmout =  tIssues.getAmount();
        }

        return totalTotalTransactionAmout;
        //throw new UnsupportedOperationException();
    }

    /**
     * Returns the sum of the amounts of all transactions sent by the specified client
     * @throws IOException 
     */
    public double getTotalTransactionAmountSentBy(String senderFullName) throws IOException {

        double amount = 0; 
        String  jsonResponse = utilService.readText("../../transaction/transactions.json");
        List<TransactionIssue> transactionIssues  = mapper.readValue(jsonResponse, new TypeReference<List<TransactionIssue>>() {});


        for (TransactionIssue tIssues : transactionIssues) {
             
            if(tIssues.getSenderFullName().equals(senderFullName))
            {
                amount+=tIssues.getAmount();
            }
        }
        return amount;
    }



    /**
     * Returns the highest transaction amount
     * @throws IOException 
     */
    public double getMaxTransactionAmount() throws IOException {

        double MaxAmount = 0; 
        String  jsonResponse = utilService.readText("../../transaction/transactions.json");
        List<TransactionIssue> transactionIssues  = mapper.readValue(jsonResponse, new TypeReference<List<TransactionIssue>>() {});
        

        for (TransactionIssue tIssues : transactionIssues) {

            if(tIssues.getAmount()>MaxAmount)
                MaxAmount = tIssues.getAmount();
        }

        return MaxAmount;
     }

    /**
     * Counts the number of unique clients that sent or received a transaction
     * @throws IOException 
     */
    public long countUniqueClients() throws IOException {
 
        String sendersName, recieversName;
        String  jsonResponse = utilService.readText("../../transaction/transactions.json");
        List<TransactionIssue> transactionIssues  = mapper.readValue(jsonResponse, new TypeReference<List<TransactionIssue>>() {});
        
         Set<String> uniqueNames = new HashSet<String>(); 

        for (TransactionIssue tIssues : transactionIssues) {

         sendersName = tIssues.getSenderFullName();
         uniqueNames.add(sendersName);   
         recieversName = tIssues.getBeneficiaryFullName();
         uniqueNames.add(recieversName);   
         

        }

        long countOfUniqueClients =  uniqueNames.size();

        return countOfUniqueClients;

     }

    /**
     * Returns whether a client (sender or beneficiary) has at least one transaction with a compliance
     * issue that has not been solved
     * @throws IOException 
     */
    public boolean hasOpenComplianceIssues(String clientFullName) throws IOException {

        String  jsonResponse = utilService.readText("../../transaction/transactions.json");
        List<TransactionIssue> transactionIssues  = mapper.readValue(jsonResponse, new TypeReference<List<TransactionIssue>>() {});
         Boolean response = false;
        
        for (TransactionIssue tIssues : transactionIssues) {
            if(tIssues.getIssueSolved() == true)
               {
                 response = true;
                break;
                }
        }

        return response;

    }

    /**
     * Returns all transactions indexed by beneficiary name
     */
    public Map<String, Object> getTransactionsByBeneficiaryName() {



        throw new UnsupportedOperationException();
    }

    /**
     * Returns the identifiers of all open compliance issues
     */
    public Set<Integer> getUnsolvedIssueIds() {

        throw new UnsupportedOperationException();
    }

    /**
     * Returns a list of all solved issue messages
     */
    public List<String> getAllSolvedIssueMessages() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the 3 transactions with highest amount sorted by amount descending
     */
    public List<Object> getTop3TransactionsByAmount() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the sender with the most total sent amount
     */
    public Optional<Object> getTopSender() {
        throw new UnsupportedOperationException();
    }


}
