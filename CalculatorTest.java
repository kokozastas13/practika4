package core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тести основної функціональності обчислення.
 */
public class CalculatorTest {

    @Test
    void sumCalculatorWorks() {
        ExampleCalculator calc = new ExampleCalculator();
        CalcTask task = new CalcTask("Sum").addParam("a", "2").addParam("b", "3");

        CalcResult r = calc.calculate(task);

        assertEquals("5", r.getValues().get("sum"));
        assertEquals("2", r.getValues().get("a"));
        assertEquals("3", r.getValues().get("b"));
    }

    @Test
    void overloadedCalculateWorks() {
        ExampleCalculator calc = new ExampleCalculator();
        CalcResult r = calc.calculate(10, 7);
        assertEquals("17", r.getValues().get("sum"));
    }
}
