package presentation;

import core.CalcResult;

import java.util.Map;
import java.util.StringJoiner;

/**
 * Подання результатів у вигляді простого тексту.
 */
public class TextPresenter implements Presenter {

    @Override
    public String render(CalcResult result) {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        for (Map.Entry<String, String> e : result.getValues().entrySet()) {
            sj.add(e.getKey() + ": " + e.getValue());
        }
        return sj.toString();
    }
}
