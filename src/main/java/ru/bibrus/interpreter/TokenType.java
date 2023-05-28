package ru.bibrus.interpreter;

public enum TokenType {

    LEFT_PARENTHESIS("(", "\\("),
    RIGHT_PARENTHESIS(")", "\\)"),
    PLUS("+", "\\+"),
    SUB("-", "\\-"),
    SPACE(" ", "\\s"),
    RUBLE_FLOAT("p", "\\d*\\.\\d{1,2}р{1}"),
    RUBLE("p", "\\d*р"),
    TO_RUBLES("toRubles", "toRubles"),
    DOLLAR_FLOAT("$", "\\$\\d*\\.\\d{1,2}"),
    DOLLAR("$", "\\$\\d*"),
    TO_DOLLARS("toDollars", "toDollars");

    private final String name;
    private final String template;

    TokenType(String name, String template) {
        this.name = name;
        this.template = template;
    }

    public String getName() {
        return name;
    }

    public String getTemplate() {
        return template;
    }

}
