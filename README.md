### Тестовое задание Java SE / вариант задания 2

#### Бибаев Руслан

### Описание

Калькулятор валют представляет собой комбинацию интерпритатора и конвертера валют.
Интерпритатор на стадии доработки парсера, лексический анализатор готов

Пример работоспосбности лексера
```java
import ru.bibrus.interpreter.Lexer;
import ru.bibrus.interpreter.SimpleLexer;

public class Interpreter {

    public static void main(String[] args) {
        Lexer lexer = new SimpleLexer();
        lexer.analyse("toDollars(737.0р + 34р + toRubles($85.4) + toRubles($85.4))").
                                                            forEach(System.out::println);
    }

}
```

Вывод
```
Token {position=0, type=TO_DOLLARS, value='toDollars'}
Token {position=9, type=LEFT_PARENTHESIS, value='('}
Token {position=10, type=RUBLE_FLOAT, value='737.0р'}
Token {position=18, type=PLUS, value='+'}
Token {position=20, type=RUBLE, value='34р'}
Token {position=25, type=PLUS, value='+'}
Token {position=27, type=TO_RUBLES, value='toRubles'}
Token {position=35, type=LEFT_PARENTHESIS, value='('}
Token {position=36, type=DOLLAR_FLOAT, value='$85.4'}
Token {position=41, type=RIGHT_PARENTHESIS, value=')'}
Token {position=43, type=PLUS, value='+'}
Token {position=45, type=TO_RUBLES, value='toRubles'}
Token {position=53, type=LEFT_PARENTHESIS, value='('}
Token {position=54, type=DOLLAR_FLOAT, value='$85.4'}
Token {position=59, type=RIGHT_PARENTHESIS, value=')'}
Token {position=60, type=RIGHT_PARENTHESIS, value=')'}
```

Пример использования конвертера
```java
import ru.bibrus.converter.Currency;
import ru.bibrus.converter.CurrencyConverter;
import ru.bibrus.converter.Money;
import ru.bibrus.converter.SimpleCurrencyConverter;

public class Converter {

    public static void main(String[] args) {
        CurrencyConverter converter = new SimpleCurrencyConverter();
        Money rubles = converter.convert(Money.of(5124, Currency.RUBLE), Currency.DOLLAR);
        Money dollars = converter.convert(Money.of(85.4, Currency.DOLLAR), Currency.RUBLE);

        System.out.println("rubles = " + rubles.getFormatted());
        System.out.println("dollars = " + dollars.getFormatted());
    }

}
```

Вывод
```
rubles = 85,40p
dollars = $5124,00
```

### Требования

* Java 11
* Gradle 8.0

### Запуск

Для запуска выполните команду
```
gradlew :run
```

Или
```
./gradlew :run
```