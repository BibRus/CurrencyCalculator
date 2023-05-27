package ru.bibrus.converter;


@FunctionalInterface
public interface CurrencyConverter {

    Money convert(Money money, Currency to);

}
