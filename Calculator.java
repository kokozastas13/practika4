package core;

/**
 * Інтерфейс обчислювача.
 * Демонструє поліморфізм: різні реалізації дають різні результати.
 */
public interface Calculator {

    /**
     * Виконати обчислення.
     * @param task вхідні параметри
     * @return результат
     */
    CalcResult calculate(CalcTask task);
}
