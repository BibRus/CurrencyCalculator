package ru.bibrus.interpreter;

public class Token {

    private final int position;
    private final TokenType type;
    private final String value;

    public Token(int position, TokenType type, String value) {
        this.position = position;
        this.type = type;
        this.value = value;
    }

    public int getPosition() {
        return position;
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Token {" +
                "position=" + position +
                ", type=" + type +
                ", value='" + value + '\'' +
                '}';
    }

}
