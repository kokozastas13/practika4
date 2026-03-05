package app;

import core.CalcResult;
import core.CalcTask;
import core.Calculator;
import core.ExampleCalculator;
import presentation.BorderStyle;
import presentation.Presenter;
import presentation.PresenterFactory;
import presentation.TableStyle;

import java.util.Scanner;

/**
 * Точка входу. Діалог з користувачем + демонстрація фабрики та поліморфізму.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введіть a (ціле число): ");
        String a = sc.nextLine().trim();

        System.out.println("Введіть b (ціле число): ");
        String b = sc.nextLine().trim();

        CalcTask task = new CalcTask("Sum")
                .addParam("a", a)
                .addParam("b", b);

        Calculator calc = new ExampleCalculator();
        CalcResult result = calc.calculate(task);

        System.out.println("Оберіть формат виводу: 1 - текст, 2 - таблиця");
        int mode = readInt(sc, 1, 2);

        PresenterFactory factory;
        if (mode == 1) {
            factory = new PresenterFactory.TextFactory();
        } else {
            System.out.println("Стиль рамки: 1 - ASCII (+-|), 2 - UNICODE (┌─│)");
            int bmode = readInt(sc, 1, 2);
            BorderStyle border = (bmode == 1) ? BorderStyle.ASCII : BorderStyle.UNICODE;

            System.out.println("Padding (0..5): ");
            int padding = readInt(sc, 0, 5);

            System.out.println("Показувати заголовок? 1 - так, 2 - ні");
            boolean header = readInt(sc, 1, 2) == 1;

            System.out.println("Авто-ширина колонок? 1 - так, 2 - фіксована");
            boolean autoWidth = readInt(sc, 1, 2) == 1;

            int keyW = 10, valW = 10;
            if (!autoWidth) {
                System.out.println("Ширина колонки Field (>=1): ");
                keyW = readInt(sc, 1, 200);
                System.out.println("Ширина колонки Value (>=1): ");
                valW = readInt(sc, 1, 200);
            }

            TableStyle style = new TableStyle(border, padding, header, autoWidth, keyW, valW);
            factory = new PresenterFactory.TableFactory(style);
        }

        Presenter presenter = factory.build();
        String output = presenter.render(result);

        System.out.println("\n=== RESULT ===");
        System.out.println(output);
    }

    private static int readInt(Scanner sc, int min, int max) {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) {
                    System.out.println("Введіть число в діапазоні [" + min + ".." + max + "]:");
                    continue;
                }
                return v;
            } catch (NumberFormatException ex) {
                System.out.println("Некоректне число. Спробуйте ще раз:");
            }
        }
    }
}
