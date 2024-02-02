package com.smallworld.transaction.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

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


 


}
