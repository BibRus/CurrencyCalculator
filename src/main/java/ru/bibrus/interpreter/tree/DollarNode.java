package ru.bibrus.interpreter.tree;

import ru.bibrus.interpreter.Token;

public class DollarNode extends CurrencyNode {

    private final Token value;

    public DollarNode(Token value) {
        super(value);
        this.value = value;
    }

}