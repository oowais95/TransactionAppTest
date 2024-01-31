package com.smallworld.transaction.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smallworld.transaction.POJOS.Transaction;
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
        // String jsonResponse =
        // utilService.readText("../../transaction/transactions.json");
        String jsonResponse = utilService.responseString;

        List<Transaction> transactions = mapper.readValue(jsonResponse,
                new TypeReference<List<Transaction>>() {
                });

        for (Transaction tIssues : transactions) {
            totalTotalTransactionAmout += tIssues.getAmount();
        }

        return totalTotalTransactionAmout;
    }

    /**
     * Returns the sum of the amounts of all transactions sent by the specified
     * client
     * 
     * @throws IOException
     */
    public double getTotalTransactionAmountSentBy(String senderFullName) throws IOException {

        double amount = 0;
        // String jsonResponse =
        // utilService.readText("../../transaction/transactions.json");
        String jsonResponse = utilService.responseString;
        List<Transaction> transactions = mapper.readValue(jsonResponse,
                new TypeReference<List<Transaction>>() {
                });

        for (Transaction tIssues : transactions) {

            if (tIssues.getSenderFullName().equals(senderFullName)) {
                amount += tIssues.getAmount();
            }
        }
        return amount;
    }

    /**
     * Returns the highest transaction amount
     * 
     * @throws IOException
     */
    public double getMaxTransactionAmount() throws IOException {

        double MaxAmount = 0;
        // String jsonResponse =
        // utilService.readText("../../transaction/transactions.json");
        String jsonResponse = utilService.responseString;
        List<Transaction> transactions = mapper.readValue(jsonResponse,
                new TypeReference<List<Transaction>>() {
                });

        for (Transaction tIssues : transactions) {

            if (tIssues.getAmount() > MaxAmount)
                MaxAmount = tIssues.getAmount();
        }

        return MaxAmount;
    }

    /**
     * Counts the number of unique clients that sent or received a transaction
     * 
     * @throws IOException
     */
    public long countUniqueClients() throws IOException {

        String sendersName, recieversName;
        // String jsonResponse =
        // utilService.readText("../../transaction/transactions.json");
        String jsonResponse = utilService.responseString;
        List<Transaction> transactions = mapper.readValue(jsonResponse,
                new TypeReference<List<Transaction>>() {
                });

        Set<String> uniqueNames = new HashSet<String>();

        for (Transaction tIssues : transactions) {

            sendersName = tIssues.getSenderFullName();
            uniqueNames.add(sendersName);
            recieversName = tIssues.getBeneficiaryFullName();
            uniqueNames.add(recieversName);

        }

        long countOfUniqueClients = uniqueNames.size();

        return countOfUniqueClients;

    }

    /**
     * Returns whether a client (sender or beneficiary) has at least one transaction
     * with a compliance
     * issue that has not been solved
     * 
     * @throws IOException
     */
    public boolean hasOpenComplianceIssues(String clientFullName) throws IOException {

        // String jsonResponse =
        // utilService.readText("../../transaction/transactions.json");
        String jsonResponse = utilService.responseString;
        List<Transaction> transactions = mapper.readValue(jsonResponse,
                new TypeReference<List<Transaction>>() {
                });
        Boolean response = false;

        for (Transaction tIssues : transactions) {
            if (tIssues.getIssueSolved() == true) {
                response = true;
                break;
            }
        }
        return response;
    }

    /**
     * Returns all transactions indexed by beneficiary name
     * 
     * @throws IOException
     */
    public Map<String, Transaction> getTransactionsByBeneficiaryName() throws IOException {

        // String jsonResponse =
        // utilService.readText("../../transaction/transactions.json");
        String jsonResponse = utilService.responseString;
        List<Transaction> transactions = mapper.readValue(jsonResponse, new TypeReference<List<Transaction>>() {
        });

        Map<String, Transaction> map = new HashMap<String, Transaction>();
        // here only one trasaction pr key(beneficiaryName) would be saved - will see
        // for a work around at end
        // Map<String,List<TransactionIssue>> map = new
        // HashMap<String,List<TransactionIssue>>();

        for (Transaction tIssues : transactions) {
            map.put(tIssues.getBeneficiaryFullName(), tIssues);
        }
        return map;

    }

    /**
     * Returns the identifiers of all open compliance issues
     * 
     * @throws IOException
     */
    public Set<Integer> getUnsolvedIssueIds() throws IOException {

        // String jsonResponse =
        // utilService.readText("../../transaction/transactions.json");
        String jsonResponse = utilService.responseString;
        List<Transaction> transactions = mapper.readValue(jsonResponse, new TypeReference<List<Transaction>>() {
        });
        Set<Integer> unresolvedIssueIds = new HashSet<Integer>();

        for (Transaction tIssue : transactions) {
            if (tIssue.getIssueSolved() == false) {
                // as issue identifier is IssueId
                unresolvedIssueIds.add(tIssue.getIssueId());
            }
        }
        return unresolvedIssueIds;
    }

    /**
     * Returns a list of all solved issue messages
     * 
     * @throws IOException
     */
    public List<String> getAllSolvedIssueMessages() throws IOException {

        // String jsonResponse =
        // utilService.readText("../../transaction/transactions.json");
        String jsonResponse = utilService.responseString;
        List<Transaction> transactions = mapper.readValue(jsonResponse, new TypeReference<List<Transaction>>() {
        });
        List<String> solvedIssueMessages = new ArrayList<String>();

        for (Transaction tIssue : transactions) {
            if (tIssue.getIssueSolved() == true) {
                solvedIssueMessages.add(tIssue.getIssueMessage());
            }
        }
        return solvedIssueMessages;
    }

    /**
     * Returns the 3 transactions with highest amount sorted by amount descending
     * 
     * @throws IOException
     */
    public List<Transaction> getTop3TransactionsByAmount() throws IOException {

        // String jsonResponse =
        // utilService.readText("../../transaction/transactions.json");
        String jsonResponse = utilService.responseString;
        List<Transaction> transactions = mapper.readValue(jsonResponse, new TypeReference<List<Transaction>>() {
        });

        transactions.sort(Comparator.comparingDouble(Transaction::getAmount).reversed());
        transactions.subList(0, 3);

        return transactions;

    }

    /**
     * Returns the sender with the most total sent amount
     */
    public String getTopSender() throws IOException {

        // String jsonResponse =
        // utilService.readText("../../transaction/transactions.json");
        String jsonResponse = utilService.responseString;
        List<Transaction> transactions = mapper.readValue(jsonResponse, new TypeReference<List<Transaction>>() {
        });

        Map<String, Double> map = new HashMap<String, Double>();
        Double amount = 0d;
        String name = "";

        for (Transaction tIssues : transactions) {

            name = tIssues.getSenderFullName();
            if (map.containsKey(name)) {

                amount = map.get(name);
                amount += tIssues.getAmount();
                map.put(name, amount);
                amount = 0d;
            } else {
                map.put(name, tIssues.getAmount());
            }

        }

        String keyWithLargestValue = null;
        Double largestValue = 0d;

        for (Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() > largestValue) {
                largestValue = entry.getValue();
                keyWithLargestValue = entry.getKey();
            }
        }

        return keyWithLargestValue;

    }

}
