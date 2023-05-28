package ru.bibrus;

import ru.bibrus.converter.Currency;
import ru.bibrus.converter.CurrencyConverter;
import ru.bibrus.converter.Money;
import ru.bibrus.converter.SimpleCurrencyConverter;

import ru.bibrus.interpreter.Lexer;
import ru.bibrus.interpreter.SimpleLexer;

public class Main {

    public static void main(String[] args) {
        CurrencyConverter converter = new SimpleCurrencyConverter();
        Money rubles = converter.convert(Money.of(5124, Currency.RUBLE), Currency.DOLLAR);
        Money dollars = converter.convert(Money.of(85.4, Currency.DOLLAR), Currency.RUBLE);

        System.out.println("rubles = " + rubles.getFormatted());
        System.out.println("dollars = " + dollars.getFormatted());

        Lexer lexer = new SimpleLexer();
        lexer.analyse("toDollars(737.0р + 34р + toRubles($85.4) + toRubles($85.4))").forEach(System.out::println);
    }

}