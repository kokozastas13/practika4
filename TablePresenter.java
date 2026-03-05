package presentation;

import core.CalcResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Подання результатів у вигляді текстової таблиці.
 * Демонструє overriding (render) і overloading (repeat()).
 */
public class TablePresenter implements Presenter {

    private final TableStyle style;

    /**
     * @param style налаштування таблиці
     */
    public TablePresenter(TableStyle style) {
        this.style = style;
    }

    @Override // overriding
    public String render(CalcResult result) {
        List<String[]> rows = new ArrayList<>();
        for (Map.Entry<String, String> e : result.getValues().entrySet()) {
            rows.add(new String[]{e.getKey(), e.getValue()});
        }

        int pad = Math.max(0, style.getPadding());
        int keyW, valW;

        if (style.isAutoWidth()) {
            keyW = "Field".length();
            valW = "Value".length();
            for (String[] r : rows) {
                keyW = Math.max(keyW, r[0].length());
                valW = Math.max(valW, r[1].length());
            }
        } else {
            keyW = Math.max(1, style.getFixedKeyWidth());
            valW = Math.max(1, style.getFixedValWidth());
        }

        int cellKeyW = keyW + pad * 2;
        int cellValW = valW + pad * 2;

        BorderChars bc = BorderChars.of(style.getBorderStyle());

        StringBuilder sb = new StringBuilder();

        sb.append(bc.tl).append(repeat(bc.h, cellKeyW)).append(bc.tm)
          .append(repeat(bc.h, cellValW)).append(bc.tr).append('\n');

        if (style.isHeader()) {
            sb.append(bc.v).append(cell("Field", keyW, pad)).append(bc.v)
              .append(cell("Value", valW, pad)).append(bc.v).append('\n');

            sb.append(bc.ml).append(repeat(bc.h, cellKeyW)).append(bc.mm)
              .append(repeat(bc.h, cellValW)).append(bc.mr).append('\n');
        }

        for (String[] r : rows) {
            sb.append(bc.v).append(cell(r[0], keyW, pad)).append(bc.v)
              .append(cell(r[1], valW, pad)).append(bc.v).append('\n');
        }

        sb.append(bc.bl).append(repeat(bc.h, cellKeyW)).append(bc.bm)
          .append(repeat(bc.h, cellValW)).append(bc.br);

        return sb.toString();
    }

    // overloading helper
    private String repeat(char c, int n) {
        return String.valueOf(c).repeat(Math.max(0, n));
    }

    // overloading helper (інша сигнатура)
    private String repeat(String s, int n) {
        return s.repeat(Math.max(0, n));
    }

    private String cell(String text, int contentWidth, int pad) {
        String t = text == null ? "" : text;
        if (t.length() > contentWidth) t = t.substring(0, contentWidth);
        String leftPad = repeat(" ", pad);
        String rightPad = repeat(" ", pad);
        String inside = padRight(t, contentWidth);
        return leftPad + inside + rightPad;
    }

    private String padRight(String s, int width) {
        int missing = width - s.length();
        return missing <= 0 ? s : (s + repeat(" ", missing));
    }

    /**
     * Символи рамки для ASCII/UNICODE.
     */
    private static class BorderChars {
        final char tl, tr, bl, br, tm, bm, mm, ml, mr, h, v;

        private BorderChars(char tl, char tr, char bl, char br,
                            char tm, char bm, char mm, char ml, char mr,
                            char h, char v) {
            this.tl = tl; this.tr = tr; this.bl = bl; this.br = br;
            this.tm = tm; this.bm = bm; this.mm = mm; this.ml = ml; this.mr = mr;
            this.h = h; this.v = v;
        }

        static BorderChars of(BorderStyle style) {
            return switch (style) {
                case UNICODE -> new BorderChars('┌','┐','└','┘','┬','┴','┼','├','┤','─','│');
                case ASCII -> new BorderChars('+','+','+','+','+','+','+','+','+','-','|');
            };
        }
    }
}
