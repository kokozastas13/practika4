package core;

/**
 * Приклад реалізації калькулятора.
 * Тут проста демонстрація (сума двох цілих чисел).
 *
 * У вашій роботі замініть логіку на задачу з попередньої лабораторної,
 * залишивши інтерфейс Calculator та формат CalcResult.
 */
public class ExampleCalculator implements Calculator {

    @Override // overriding
    public CalcResult calculate(CalcTask task) {
        int a = Integer.parseInt(task.getParams().getOrDefault("a", "0"));
        int b = Integer.parseInt(task.getParams().getOrDefault("b", "0"));
        int sum = a + b;

        return new CalcResult()
                .put("Task", task.getName())
                .put("a", String.valueOf(a))
                .put("b", String.valueOf(b))
                .put("sum", String.valueOf(sum));
    }

    /**
     * Перевантаження (overloading): той самий метод з іншими параметрами.
     * @param a перше число
     * @param b друге число
     * @return результат
     */
    public CalcResult calculate(int a, int b) {
        CalcTask task = new CalcTask("Sum")
                .addParam("a", String.valueOf(a))
                .addParam("b", String.valueOf(b));
        return calculate(task);
    }
}
