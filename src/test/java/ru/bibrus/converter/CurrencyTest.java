package ru.bibrus.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrencyTest {

    @Test
    public void loadExchangeRateFromConfiguration() {
        Assertions.assertEquals(60, Currency.RUBLE.getExchangeRate().doubleValue());
        Assertions.assertEquals(1, Currency.DOLLAR.getExchangeRate().doubleValue());
    }

}
