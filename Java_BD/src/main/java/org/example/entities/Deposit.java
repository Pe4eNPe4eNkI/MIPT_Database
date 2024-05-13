package org.example.entities;

import java.math.BigInteger;

public class Deposit {
    final BigInteger depositId;

    final BigInteger clientId;

    final String openingData;

    final String closingData;

    final Integer depositSum;

    final String depositName;

    public Deposit(BigInteger creditId, BigInteger clientId, String opennigData, String closingData, Integer depositSumm, String depositName) {
        this.depositId = creditId;
        this.clientId = clientId;
        this.openingData = opennigData;
        this.closingData = closingData;
        this.depositSum = depositSumm;
        this.depositName = depositName;
    }

}
