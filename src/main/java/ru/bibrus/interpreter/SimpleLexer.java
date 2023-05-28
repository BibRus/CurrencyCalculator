package ru.bibrus.interpreter;

import ru.bibrus.interpreter.exception.LexerAnalysisException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleLexer implements Lexer {

    private String code;
    private int position;

    private final List<Token> tokens = new ArrayList<>();

    @Override
    public List<Token> analyse(String code) {
        this.code = code;
        while (true) {
            try {
                if (!this.nextToken()) break;
            } catch (LexerAnalysisException exception) {
                exception.printStackTrace();
                break;
            }
        }
        this.tokens.removeIf(token -> token.getType().equals(TokenType.SPACE));
        return this.tokens;
    }

    @Override
    public boolean nextToken() throws LexerAnalysisException {
        if (this.position >= this.code.length()) {
            return false;
        }
        TokenType[] types = TokenType.values();
        for (TokenType type : types) {
            String template = "^" + type.getTemplate();
            List<String> snippet = this.matches(this.code.substring(this.position), template);
            if (!snippet.isEmpty()) {
                if (!snippet.get(0).isEmpty()) {
                    Token token = new Token(this.position, type, snippet.get(0));
                    this.position += snippet.get(0).length();
                    this.tokens.add(token);
                    return true;
                }
            }
        }
        throw new LexerAnalysisException(String.format("Lexical error was found at position %d", this.position));
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private List<String> matches(String text, String regex) {
        List<String> matches = new ArrayList<>();
        Matcher matcher = Pattern.compile("(?=(" + regex + "))").matcher(text);
        while(matcher.find()) {
            matches.add(matcher.group(1));
        }
        return matches;
    }

}