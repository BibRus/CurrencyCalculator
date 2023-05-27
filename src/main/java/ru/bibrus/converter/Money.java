package ru.bibrus.converter;

import ru.bibrus.Configuration;

import java.math.BigDecimal;

public class Money {

    private Currency currency;
    private BigDecimal amount;

    private Money(Builder builder) {
        this.currency = builder.currency;
        this.amount = builder.amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getFormatted() {
        return this.currency.getFormatted(this);
    }

    public static Money of(double amount, Currency currency) {
        return new Builder(amount, currency).build();
    }

    public static class Builder {

        BigDecimal amount;
        Currency currency;

        public Builder(double amount, Currency currency) {
            this.amount =  new BigDecimal(amount).setScale(Configuration.CONVERTER_ROUNDING_SCALE,
                    Configuration.CONVERTER_ROUNDING_MODE);
            this.currency = currency;
        }

        public Money build() {
            return new Money(this);
        }

    }

}