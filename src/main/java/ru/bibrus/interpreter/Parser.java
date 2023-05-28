package ru.bibrus.interpreter;

import ru.bibrus.interpreter.exception.RequireTokenException;
import ru.bibrus.interpreter.tree.BinaryOperationNode;
import ru.bibrus.interpreter.tree.DollarNode;
import ru.bibrus.interpreter.tree.ExpressionNode;
import ru.bibrus.interpreter.tree.StatementsNode;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Parser {

    private int position;
    private final List<Token> tokens;
    private HashMap<String, String> buffer;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.buffer = new HashMap<>();
    }

    private Token match(TokenType... expected) {
        if (this.position < this.tokens.size()) {
            Token currentToken = this.tokens.get(this.position);
            if (Stream.of(expected).anyMatch(type -> type.equals(currentToken.getType()))) {
                this.position += 1;
                return currentToken;
            }
        }
        return null;
    }

    private void require(TokenType... expected) throws RequireTokenException {
        Token token = this.match(expected);
        if (token == null) {
            throw new RequireTokenException(String.format("Parser requires a token %s at the position %d", expected[0], this.position));
        }
    }

    private ExpressionNode parseParentheses() {
        if (this.match(TokenType.LEFT_PARENTHESIS) != null) {
            ExpressionNode node = this.parseFormula();
            try {
                this.require(TokenType.RIGHT_PARENTHESIS);
            } catch (RequireTokenException exception) {
                exception.printStackTrace();
            }
            return node;
        } else {
            return this.parseCurrency();
        }
    }

    private ExpressionNode parseCurrency() {
        return this.parseDollar();
    }

    private DollarNode parseDollar() {
        Token dollar = match(TokenType.DOLLAR);
        if (dollar != null) {
            DollarNode node = new DollarNode(dollar);
            return node;
        }
        return null;
    }

    private ExpressionNode parseFormula() {
        ExpressionNode leftNode = this.parseParentheses();
        Token operator = this.match(TokenType.SUB, TokenType.PLUS);
        while (operator != null) {
            ExpressionNode rightNode = this.parseParentheses();
            leftNode = new BinaryOperationNode(operator, leftNode, rightNode);
            operator = this.match(TokenType.SUB, TokenType.PLUS);
        }
        return leftNode;
    }

    private ExpressionNode parseExpression() {
        return parseFormula();
    }

    public ExpressionNode parseCode() {
        StatementsNode root = new StatementsNode();
        while (this.position < this.tokens.size()) {
            ExpressionNode codeSnippet = this.parseExpression();
            root.getCodeSnippets().add(codeSnippet);
        }
        return root;
    }

}