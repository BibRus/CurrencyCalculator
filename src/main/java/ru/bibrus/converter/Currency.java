package ru.bibrus.converter;

import ru.bibrus.Configuration;

import java.math.BigDecimal;

public enum Currency {

    RUBLE,
    DOLLAR;

    public String getSymbol() {
        String key = String.join(".", "converter", "currency", this.name().
                                                    toLowerCase().replace('_', '-'), "symbol");
        return Configuration.get().value(key);
    }

    public String getFormatted(Money money) {
        String key = String.join(".", getConfigurationPropertyPrefix(), "template");
        return String.format(Configuration.get().value(key), getSymbol(), money.getAmount().doubleValue());
    }

    public BigDecimal getExchangeRate() {
        String key = String.join(".", getConfigurationPropertyPrefix(), "rate");
        return BigDecimal.valueOf(Long.parseLong(Configuration.get().value(key)));
    }

    private String getConfigurationPropertyPrefix() {
        return String.join(".", "converter", "currency",
                                        this.name().toLowerCase().replace('_', '-'));
    }

}