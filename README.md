# Lab: Factory Method (Virtual Constructor) + Table Presenter

## Вимоги
- Java 17+
- Maven 3.8+

## Як запустити (CLI)
```bash
mvn -q -DskipTests package
mvn -q exec:java -Dexec.mainClass=app.Main
```

> Якщо `exec:java` не працює у вашому Maven, запускайте так:
```bash
mvn -q -DskipTests package
java -cp target/classes app.Main
```

## Як запустити тести
```bash
mvn -q test
```

## Як згенерувати Javadoc
```bash
mvn -q javadoc:javadoc
```
Результат буде у `target/site/apidocs/index.html`.
