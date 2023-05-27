package ru.bibrus.converter;

import ru.bibrus.Configuration;

import java.math.BigDecimal;

public class SimpleCurrencyConverter implements CurrencyConverter {

    @Override
    public Money convert(Money money, Currency to) {
        BigDecimal amount = money.getAmount().multiply(
                to.getExchangeRate()).divide(money.getCurrency().getExchangeRate(),
                                                Configuration.CONVERTER_ROUNDING_MODE);
        return Money.of(amount.doubleValue(), money.getCurrency());
    }

}