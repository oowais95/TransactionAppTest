package com.smallworld.transaction.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Set;

@SpringBootTest
public class TransactionServiceTest {


    @Autowired
    TransactionService transactionService;

    @Test
    void test(){
        System.out.println("test ran");
    }


    @Test
    public void MaxTransactionAmountTest() throws IOException {

        double expectedMaxAmount = 985;

         double actualSum = transactionService.getMaxTransactionAmount();

        // Assert
        Assertions.assertEquals(expectedMaxAmount, actualSum, "Result is incorrect");
    }



    @Test
    public void topSenderTest() throws IOException {

        String expected = "Grace Burgess";

        // Act
        String actual = transactionService.getTopSender();

        // Assert
        Assertions.assertEquals(expected, actual, "Result  is incorrect");
    }


    @Test
    public void getTotalTransactionAmount() throws IOException {

        double expected = 4371.37;

        // Act
        double actual = transactionService.getTotalTransactionAmount();

        // Assert
        Assertions.assertEquals(expected, actual, "Result  is incorrect");
    }

    @Test
    public void countUniqueClients() throws IOException {

        long expected = 14;

        // Act
        long actual = transactionService.countUniqueClients();

        // Assert
        Assertions.assertEquals(expected, actual, "Result  is incorrect");
    }


    @Test
    public void getTotalTransactionAmountSentBy() throws IOException {

        double expected = 459.09;

        // Act
        double actual = transactionService.getTotalTransactionAmountSentBy("Billy Kimber");

        // Assert
        Assertions.assertEquals(expected, actual, "Result  is incorrect");
    }


 
    @Test
    public void hasOpenComplianceIssues() throws IOException {

        Boolean expected = true;

        // Act
        Boolean actual = transactionService.hasOpenComplianceIssues("Grace Burgess");

        // Assert
        Assertions.assertEquals(expected, actual, "Result  is incorrect");
    }


     
    @Test
    public void getUnsolvedIssueIds() throws IOException {

         Set<Integer> expected = Set.of(1, 3, 99, 54, 15);


        // Act
        Set<Integer> actual = transactionService.getUnsolvedIssueIds();

        // Assert
        Assertions.assertEquals(expected, actual, "Result  is incorrect");
    }


}
