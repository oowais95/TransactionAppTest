package com.smallworld.transaction.Service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TransactionService.class})
@ExtendWith(SpringExtension.class)
class TransactionServiceDiffblueTest {
  @Autowired
  private TransactionService transactionService;

  @MockBean
  private UtilService utilService;

  /**
   * Method under test: {@link TransactionService#getTotalTransactionAmount()}
   */
  @Test
  void testGetTotalTransactionAmount() throws IOException {
    // Arrange
    when(utilService.readText(Mockito.<String>any())).thenThrow(new IOException("../../transaction/transactions.json"));

    // Act and Assert
    assertThrows(IOException.class, () -> transactionService.getTotalTransactionAmount());
    verify(utilService).readText(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link TransactionService#getTotalTransactionAmountSentBy(String)}
   */
  @Test
  void testGetTotalTransactionAmountSentBy() throws IOException {
    // Arrange
    when(utilService.readText(Mockito.<String>any())).thenThrow(new IOException("../../transaction/transactions.json"));

    // Act and Assert
    assertThrows(IOException.class, () -> transactionService.getTotalTransactionAmountSentBy("Dr Jane Doe"));
    verify(utilService).readText(Mockito.<String>any());
  }

  /**
   * Method under test: {@link TransactionService#getMaxTransactionAmount()}
   */
  @Test
  void testGetMaxTransactionAmount() throws IOException {
    // Arrange
    when(utilService.readText(Mockito.<String>any())).thenThrow(new IOException("../../transaction/transactions.json"));

    // Act and Assert
    assertThrows(IOException.class, () -> transactionService.getMaxTransactionAmount());
    verify(utilService).readText(Mockito.<String>any());
  }

  /**
   * Method under test: {@link TransactionService#countUniqueClients()}
   */
  @Test
  void testCountUniqueClients() throws IOException {
    // Arrange
    when(utilService.readText(Mockito.<String>any())).thenThrow(new IOException("../../transaction/transactions.json"));

    // Act and Assert
    assertThrows(IOException.class, () -> transactionService.countUniqueClients());
    verify(utilService).readText(Mockito.<String>any());
  }

  /**
   * Method under test: {@link TransactionService#hasOpenComplianceIssues(String)}
   */
  @Test
  void testHasOpenComplianceIssues() throws IOException {
    // Arrange
    when(utilService.readText(Mockito.<String>any())).thenThrow(new IOException("../../transaction/transactions.json"));

    // Act and Assert
    assertThrows(IOException.class, () -> transactionService.hasOpenComplianceIssues("Dr Jane Doe"));
    verify(utilService).readText(Mockito.<String>any());
  }

  /**
   * Method under test:
   * {@link TransactionService#getTransactionsByBeneficiaryName()}
   */
  @Test
  void testGetTransactionsByBeneficiaryName() throws IOException {
    // Arrange
    when(utilService.readText(Mockito.<String>any())).thenThrow(new IOException("../../transaction/transactions.json"));

    // Act and Assert
    assertThrows(IOException.class, () -> transactionService.getTransactionsByBeneficiaryName());
    verify(utilService).readText(Mockito.<String>any());
  }

  /**
   * Method under test: {@link TransactionService#getUnsolvedIssueIds()}
   */
  @Test
  void testGetUnsolvedIssueIds() throws IOException {
    // Arrange
    when(utilService.readText(Mockito.<String>any())).thenThrow(new IOException("../../transaction/transactions.json"));

    // Act and Assert
    assertThrows(IOException.class, () -> transactionService.getUnsolvedIssueIds());
    verify(utilService).readText(Mockito.<String>any());
  }

  /**
   * Method under test: {@link TransactionService#getAllSolvedIssueMessages()}
   */
  @Test
  void testGetAllSolvedIssueMessages() throws IOException {
    // Arrange
    when(utilService.readText(Mockito.<String>any())).thenThrow(new IOException("../../transaction/transactions.json"));

    // Act and Assert
    assertThrows(IOException.class, () -> transactionService.getAllSolvedIssueMessages());
    verify(utilService).readText(Mockito.<String>any());
  }

  /**
   * Method under test: {@link TransactionService#getTop3TransactionsByAmount()}
   */
  @Test
  void testGetTop3TransactionsByAmount() throws IOException {
    // Arrange
    when(utilService.readText(Mockito.<String>any())).thenThrow(new IOException("../../transaction/transactions.json"));

    // Act and Assert
    assertThrows(IOException.class, () -> transactionService.getTop3TransactionsByAmount());
    verify(utilService).readText(Mockito.<String>any());
  }

  /**
   * Method under test: {@link TransactionService#getTopSender()}
   */
  @Test
  void testGetTopSender() throws IOException {
    // Arrange
    when(utilService.readText(Mockito.<String>any())).thenThrow(new IOException("../../transaction/transactions.json"));

    // Act and Assert
    assertThrows(IOException.class, () -> transactionService.getTopSender());
    verify(utilService).readText(Mockito.<String>any());
  }
}
