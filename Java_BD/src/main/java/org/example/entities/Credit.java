package org.example.entities;

import java.math.BigInteger;

public class Credit {
    final BigInteger creditId;

    final BigInteger clientId;

    final String openingData;

    final String closingData;

    final Integer creditSum;

    final String creditName;

    public Credit(BigInteger creditId, BigInteger clientId, String opennigData, String closingData, Integer depositSumm, String depositName) {
        this.creditId = creditId;
        this.clientId = clientId;
        this.openingData = opennigData;
        this.closingData = closingData;
        this.creditSum = depositSumm;
        this.creditName = depositName;
    }
}
