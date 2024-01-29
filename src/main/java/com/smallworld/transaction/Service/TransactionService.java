package com.smallworld.transaction.Service;

import java.io.IOException;
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
     */
    public double getTotalTransactionAmountSentBy(String senderFullName) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the highest transaction amount
     */
    public double getMaxTransactionAmount() {
        throw new UnsupportedOperationException();
    }

    /**
     * Counts the number of unique clients that sent or received a transaction
     */
    public long countUniqueClients() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns whether a client (sender or beneficiary) has at least one transaction with a compliance
     * issue that has not been solved
     */
    public boolean hasOpenComplianceIssues(String clientFullName) {
        throw new UnsupportedOperationException();
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
