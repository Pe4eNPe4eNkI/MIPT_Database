package org.example.entities;

import java.math.BigInteger;

public class DepositType {

    final BigInteger depositId;

    final String depositName;

    final Double percent;

    final Double replenishment;

    final Integer currencyId;

    final Integer minSum;

    public DepositType(BigInteger depositId, String depositName, Double percent, Double replenishment, Integer currencyId, Integer minSum) {
        this.depositId = depositId;
        this.depositName = depositName;
        this.percent = percent;
        this.replenishment = replenishment;
        this.currencyId = currencyId;
        this.minSum = minSum;
    }


}
