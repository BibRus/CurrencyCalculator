package ru.bibrus.interpreter.tree;

import ru.bibrus.interpreter.Token;

public class CurrencyNode extends ExpressionNode {

    private final Token value;

    public CurrencyNode(Token value) {
        this.value = value;
    }

    public Token getValue() {
        return value;
    }

}