package ru.bibrus.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleCurrencyConverterTest {

    private final CurrencyConverter converter = new SimpleCurrencyConverter();

    @Test
    public void convert() {
        Money rubles = converter.convert(Money.of(5124, Currency.RUBLE), Currency.DOLLAR);
        Money dollars = converter.convert(Money.of(85.4, Currency.DOLLAR), Currency.RUBLE);
        Assertions.assertEquals(rubles.getAmount().doubleValue(), 85.4);
        Assertions.assertEquals(dollars.getAmount().doubleValue(), 5124);
    }

}
