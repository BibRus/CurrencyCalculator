package ru.bibrus.interpreter.tree;

import java.util.List;

public class StatementsNode extends ExpressionNode {

    private List<ExpressionNode> codeSnippets;

    public List<ExpressionNode> getCodeSnippets() {
        return codeSnippets;
    }

}