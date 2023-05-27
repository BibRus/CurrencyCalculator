package ru.bibrus;

import ru.bibrus.converter.Currency;
import ru.bibrus.converter.CurrencyConverter;
import ru.bibrus.converter.Money;
import ru.bibrus.converter.SimpleCurrencyConverter;

public class Main {

    public static void main(String[] args) {
        CurrencyConverter converter = new SimpleCurrencyConverter();
        Money rubles = converter.convert(Money.of(5124, Currency.RUBLE), Currency.DOLLAR);
        Money dollars = converter.convert(Money.of(85.4, Currency.DOLLAR), Currency.RUBLE);
        System.out.println("rubles = " + rubles.getFormatted());
        System.out.println("dollars = " + dollars.getFormatted());
    }

}