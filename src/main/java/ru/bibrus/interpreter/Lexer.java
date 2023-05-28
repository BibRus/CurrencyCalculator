package ru.bibrus.interpreter;

import ru.bibrus.interpreter.exception.LexerAnalysisException;

import java.util.List;

public interface Lexer {

    List<Token> analyse();
    boolean nextToken() throws LexerAnalysisException;

}
