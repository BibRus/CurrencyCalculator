package ru.bibrus.interpreter.tree;

public class ToDollarNode extends ExpressionNode {

    private final DollarNode argument;

    public ToDollarNode(DollarNode argument) {
        this.argument = argument;
    }

    public DollarNode getArgument() {
        return argument;
    }

}