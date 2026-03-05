package presentation;

import core.CalcResult;

/**
 * Абстракція подання результату.
 * Реалізації: текст, таблиця тощо.
 */
public interface Presenter {

    /**
     * Перетворити результат у рядок для виводу.
     * @param result результат обчислення
     * @return форматований текст
     */
    String render(CalcResult result);
}
