package presentation;

import core.CalcResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тести табличного подання.
 */
public class TablePresenterTest {

    @Test
    void tableRendersBorders() {
        TableStyle style = new TableStyle(BorderStyle.ASCII, 1, true, true, 10, 10);
        TablePresenter p = new TablePresenter(style);

        CalcResult r = new CalcResult().put("x", "1").put("y", "2");
        String out = p.render(r);

        assertTrue(out.contains("+"));
        assertTrue(out.contains("|"));
        assertTrue(out.contains("Field"));
        assertTrue(out.contains("Value"));
    }
}
