package com.smallworld.transaction.POJOS;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionIssues {

    private int mtn;
    private double amount;
    private String senderFullName;
    private int senderAge;
    private String beneficiaryFullName;
    private int beneficiaryAge;
    private int issueId;
    private Boolean issueSolved;
    private String issueMessage;

}
