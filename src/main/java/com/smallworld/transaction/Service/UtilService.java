package com.smallworld.transaction.Service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smallworld.transaction.POJOS.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UtilService {

    ObjectMapper mapper = new ObjectMapper();

    public String readText(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            return everything;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            br.close();
        }

    }

    public List<Transaction> getListOfTransactions() throws IOException {
        List<Transaction> transactions = new ArrayList<Transaction>();

        String jsonResponse = readText("../../transaction/transactions.json");
        transactions = mapper.readValue(jsonResponse, new TypeReference<List<Transaction>>() {
        });

        return transactions;
    }


    public String responseString = "[\r\n" + //
            "  {\r\n" + //
            "    \"mtn\": 663458,\r\n" + //
            "    \"amount\": 430.2,\r\n" + //
            "    \"senderFullName\": \"Tom Shelby\",\r\n" + //
            "    \"senderAge\": 22,\r\n" + //
            "    \"beneficiaryFullName\": \"Alfie Solomons\",\r\n" + //
            "    \"beneficiaryAge\": 33,\r\n" + //
            "    \"issueId\": 1,\r\n" + //
            "    \"issueSolved\": false,\r\n" + //
            "    \"issueMessage\": \"Looks like money laundering\"\r\n" + //
            "  },\r\n" + //
            "  {\r\n" + //
            "    \"mtn\": 1284564,\r\n" + //
            "    \"amount\": 150.2,\r\n" + //
            "    \"senderFullName\": \"Tom Shelby\",\r\n" + //
            "    \"senderAge\": 22,\r\n" + //
            "    \"beneficiaryFullName\": \"Arthur Shelby\",\r\n" + //
            "    \"beneficiaryAge\": 60,\r\n" + //
            "    \"issueId\": 2,\r\n" + //
            "    \"issueSolved\": true,\r\n" + //
            "    \"issueMessage\": \"Never gonna give you up\"\r\n" + //
            "  },\r\n" + //
            "  {\r\n" + //
            "    \"mtn\": 1284564,\r\n" + //
            "    \"amount\": 150.2,\r\n" + //
            "    \"senderFullName\": \"Tom Shelby\",\r\n" + //
            "    \"senderAge\": 22,\r\n" + //
            "    \"beneficiaryFullName\": \"Arthur Shelby\",\r\n" + //
            "    \"beneficiaryAge\": 60,\r\n" + //
            "    \"issueId\": 3,\r\n" + //
            "    \"issueSolved\": false,\r\n" + //
            "    \"issueMessage\": \"Looks like money laundering\"\r\n" + //
            "  },\r\n" + //
            "  {\r\n" + //
            "    \"mtn\": 96132456,\r\n" + //
            "    \"amount\": 67.8,\r\n" + //
            "    \"senderFullName\": \"Aunt Polly\",\r\n" + //
            "    \"senderAge\": 34,\r\n" + //
            "    \"beneficiaryFullName\": \"Aberama Gold\",\r\n" + //
            "    \"beneficiaryAge\": 58,\r\n" + //
            "    \"issueId\": null,\r\n" + //
            "    \"issueSolved\": true,\r\n" + //
            "    \"issueMessage\": null\r\n" + //
            "  },\r\n" + //
            "  {\r\n" + //
            "    \"mtn\": 5465465,\r\n" + //
            "    \"amount\": 985.0,\r\n" + //
            "    \"senderFullName\": \"Arthur Shelby\",\r\n" + //
            "    \"senderAge\": 60,\r\n" + //
            "    \"beneficiaryFullName\": \"Ben Younger\",\r\n" + //
            "    \"beneficiaryAge\": 47,\r\n" + //
            "    \"issueId\": 15,\r\n" + //
            "    \"issueSolved\": false,\r\n" + //
            "    \"issueMessage\": \"Something's fishy\"\r\n" + //
            "  },\r\n" + //
            "  {\r\n" + //
            "    \"mtn\": 1651665,\r\n" + //
            "    \"amount\": 97.66,\r\n" + //
            "    \"senderFullName\": \"Tom Shelby\",\r\n" + //
            "    \"senderAge\": 22,\r\n" + //
            "    \"beneficiaryFullName\": \"Oswald Mosley\",\r\n" + //
            "    \"beneficiaryAge\": 37,\r\n" + //
            "    \"issueId\": 65,\r\n" + //
            "    \"issueSolved\": true,\r\n" + //
            "    \"issueMessage\": \"Never gonna let you down\"\r\n" + //
            "  },\r\n" + //
            "  {\r\n" + //
            "    \"mtn\": 6516461,\r\n" + //
            "    \"amount\": 33.22,\r\n" + //
            "    \"senderFullName\": \"Aunt Polly\",\r\n" + //
            "    \"senderAge\": 34,\r\n" + //
            "    \"beneficiaryFullName\": \"MacTavern\",\r\n" + //
            "    \"beneficiaryAge\": 30,\r\n" + //
            "    \"issueId\": null,\r\n" + //
            "    \"issueSolved\": true,\r\n" + //
            "    \"issueMessage\": null\r\n" + //
            "  },\r\n" + //
            "  {\r\n" + //
            "    \"mtn\": 32612651,\r\n" + //
            "    \"amount\": 666.0,\r\n" + //
            "    \"senderFullName\": \"Grace Burgess\",\r\n" + //
            "    \"senderAge\": 31,\r\n" + //
            "    \"beneficiaryFullName\": \"Michael Gray\",\r\n" + //
            "    \"beneficiaryAge\": 58,\r\n" + //
            "    \"issueId\": 54,\r\n" + //
            "    \"issueSolved\": false,\r\n" + //
            "    \"issueMessage\": \"Something ain't right\"\r\n" + //
            "  },\r\n" + //
            "  {\r\n" + //
            "    \"mtn\": 32612651,\r\n" + //
            "    \"amount\": 666.0,\r\n" + //
            "    \"senderFullName\": \"Grace Burgess\",\r\n" + //
            "    \"senderAge\": 31,\r\n" + //
            "    \"beneficiaryFullName\": \"Michael Gray\",\r\n" + //
            "    \"beneficiaryAge\": 58,\r\n" + //
            "    \"issueId\": 78,\r\n" + //
            "    \"issueSolved\": true,\r\n" + //
            "    \"issueMessage\": \"Never gonna run around and desert you\"\r\n" + //
            "  },\r\n" + //
            "  {\r\n" + //
            "    \"mtn\": 32612651,\r\n" + //
            "    \"amount\": 666.0,\r\n" + //
            "    \"senderFullName\": \"Grace Burgess\",\r\n" + //
            "    \"senderAge\": 31,\r\n" + //
            "    \"beneficiaryFullName\": \"Michael Gray\",\r\n" + //
            "    \"beneficiaryAge\": 58,\r\n" + //
            "    \"issueId\": 99,\r\n" + //
            "    \"issueSolved\": false,\r\n" + //
            "    \"issueMessage\": \"Don't let this transaction happen\"\r\n" + //
            "  },\r\n" + //
            "  {\r\n" + //
            "    \"mtn\": 36448252,\r\n" + //
            "    \"amount\": 154.15,\r\n" + //
            "    \"senderFullName\": \"Billy Kimber\",\r\n" + //
            "    \"senderAge\": 58,\r\n" + //
            "    \"beneficiaryFullName\": \"Winston Churchill\",\r\n" + //
            "    \"beneficiaryAge\": 48,\r\n" + //
            "    \"issueId\": null,\r\n" + //
            "    \"issueSolved\": true,\r\n" + //
            "    \"issueMessage\": null\r\n" + //
            "  },\r\n" + //
            "  {\r\n" + //
            "    \"mtn\": 645645111,\r\n" + //
            "    \"amount\": 215.17,\r\n" + //
            "    \"senderFullName\": \"Billy Kimber\",\r\n" + //
            "    \"senderAge\": 58,\r\n" + //
            "    \"beneficiaryFullName\": \"Major Campbell\",\r\n" + //
            "    \"beneficiaryAge\": 41,\r\n" + //
            "    \"issueId\": null,\r\n" + //
            "    \"issueSolved\": true,\r\n" + //
            "    \"issueMessage\": null\r\n" + //
            "  },\r\n" + //
            "  {\r\n" + //
            "    \"mtn\": 45431585,\r\n" + //
            "    \"amount\": 89.77,\r\n" + //
            "    \"senderFullName\": \"Billy Kimber\",\r\n" + //
            "    \"senderAge\": 58,\r\n" + //
            "    \"beneficiaryFullName\": \"Luca Changretta\",\r\n" + //
            "    \"beneficiaryAge\": 46,\r\n" + //
            "    \"issueId\": null,\r\n" + //
            "    \"issueSolved\": true,\r\n" + //
            "    \"issueMessage\": null\r\n" + //
            "  }\r\n" + //
            "]";

}
