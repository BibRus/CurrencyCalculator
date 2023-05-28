module ru.bibrus.calculator {

    exports ru.bibrus.converter;
    exports ru.bibrus.interpreter;

    provides ru.bibrus.converter.CurrencyConverter with
                ru.bibrus.converter.SimpleCurrencyConverter;

    provides ru.bibrus.interpreter.Lexer with
            ru.bibrus.interpreter.SimpleLexer;

}