package ru.bibrus.converter;

import ru.bibrus.Configuration;

import java.math.BigDecimal;

@Deprecated(since = "0.1.0")
public final class ExchangeRate {

    public static final Currency BASE_CURRENCY = Currency.DOLLAR;

    private final Currency base;
    private final Currency derivative;

    public ExchangeRate(Currency base, Currency derivative) {
        this.base = base;
        this.derivative = derivative;
    }

    public ExchangeRate(Currency derivative) {
        this.base = BASE_CURRENCY;
        this.derivative = derivative;
    }

    public BigDecimal getRatio() {
        return derivative.getExchangeRate().divide(base.getExchangeRate(), Configuration.CONVERTER_ROUNDING_MODE);
    }

}