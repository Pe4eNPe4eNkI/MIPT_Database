package org.example.entities;

import java.math.BigInteger;

public class CurrencyType {
    final BigInteger currencyId;

    final String currencyName;

    public CurrencyType(BigInteger currencyId, String currencyName) {
        this.currencyId = currencyId;
        this.currencyName = currencyName;
    }
}
