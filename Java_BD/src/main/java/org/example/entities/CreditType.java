package org.example.entities;

import java.math.BigInteger;

public class CreditType {

    final BigInteger creditId;

    final String creditName;

    final Double percent;

    final Double commission;

    final Integer currencyId;

    final Integer maxSum;

    public CreditType(BigInteger creditId, String creditName, Double percent, Double commission, Integer currencyId, Integer maxSum) {
        this.creditId = creditId;
        this.creditName = creditName;
        this.percent = percent;
        this.commission = commission;
        this.currencyId = currencyId;
        this.maxSum = maxSum;
    }
}
