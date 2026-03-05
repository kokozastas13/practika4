package core;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Результати обчислення (іменовані поля).
 */
public class CalcResult {
    private final Map<String, String> values = new LinkedHashMap<>();

    /**
     * @return карта результатів (ключ->значення)
     */
    public Map<String, String> getValues() { return values; }

    /**
     * Додати/оновити значення.
     * @param key ім'я поля
     * @param value значення
     * @return this (для ланцюжка викликів)
     */
    public CalcResult put(String key, String value) {
        values.put(key, value);
        return this;
    }
}
