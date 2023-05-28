package ru.bibrus.interpreter;

import ru.bibrus.interpreter.exception.LexerAnalysisException;

import java.util.List;

public interface Lexer {

    List<Token> analyse(String code);
    boolean nextToken() throws LexerAnalysisException;

}
