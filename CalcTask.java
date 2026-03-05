package core;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Вхідні параметри задачі обчислення.
 * Використано LinkedHashMap, щоб зберігати порядок полів при виводі.
 */
public class CalcTask {
    private final String name;
    private final Map<String, String> params = new LinkedHashMap<>();

    /**
     * @param name назва задачі
     */
    public CalcTask(String name) {
        this.name = name;
    }

    /**
     * @return назва задачі
     */
    public String getName() { return name; }

    /**
     * @return параметри задачі (ключ->значення)
     */
    public Map<String, String> getParams() { return params; }

    /**
     * Додати параметр.
     * @param key ім'я параметра
     * @param value значення параметра
     * @return this (для ланцюжка викликів)
     */
    public CalcTask addParam(String key, String value) {
        params.put(key, value);
        return this;
    }
}
