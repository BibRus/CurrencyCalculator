package ru.bibrus.interpreter.tree;

import ru.bibrus.interpreter.Token;

public class BinaryOperationNode extends ExpressionNode {

    private Token operator;
    private ExpressionNode leftNode;
    private ExpressionNode rightNode;

    public BinaryOperationNode(Token operator, ExpressionNode leftNode, ExpressionNode rightNode) {
        this.operator = operator;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

}
