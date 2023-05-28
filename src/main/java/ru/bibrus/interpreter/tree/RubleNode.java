package ru.bibrus.interpreter.tree;

import ru.bibrus.interpreter.Token;

public class RubleNode extends CurrencyNode {

    private final Token value;

    public RubleNode(Token value) {
        super(value);
        this.value = value;
    }

}