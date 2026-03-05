package presentation;

/**
 * Налаштування відображення таблиці, що задаються користувачем.
 */
public class TableStyle {
    private final BorderStyle borderStyle;
    private final int padding;
    private final boolean header;
    private final boolean autoWidth;
    private final int fixedKeyWidth;
    private final int fixedValWidth;

    /**
     * @param borderStyle стиль рамки (ASCII/UNICODE)
     * @param padding відступи всередині клітинки
     * @param header показувати заголовок
     * @param autoWidth автоматично рахувати ширину колонок
     * @param fixedKeyWidth ширина колонки Field, якщо autoWidth=false
     * @param fixedValWidth ширина колонки Value, якщо autoWidth=false
     */
    public TableStyle(BorderStyle borderStyle,
                      int padding,
                      boolean header,
                      boolean autoWidth,
                      int fixedKeyWidth,
                      int fixedValWidth) {
        this.borderStyle = borderStyle;
        this.padding = padding;
        this.header = header;
        this.autoWidth = autoWidth;
        this.fixedKeyWidth = fixedKeyWidth;
        this.fixedValWidth = fixedValWidth;
    }

    public BorderStyle getBorderStyle() { return borderStyle; }
    public int getPadding() { return padding; }
    public boolean isHeader() { return header; }
    public boolean isAutoWidth() { return autoWidth; }
    public int getFixedKeyWidth() { return fixedKeyWidth; }
    public int getFixedValWidth() { return fixedValWidth; }
}
