package presentation;

/**
 * Factory Method (Virtual Constructor) для створення Presenter.
 * Розширюється без зміни клієнтського коду: додаєте новий Presenter — додаєте фабрику.
 */
public abstract class PresenterFactory {

    /**
     * Factory Method: створює об’єкт подання.
     * @return Presenter
     */
    public abstract Presenter create();

    /**
     * Допоміжний метод: створити Presenter.
     * Тут демонстрація dynamic dispatch: викличеться create() конкретної фабрики.
     * @return Presenter
     */
    public Presenter build() {
        return create();
    }

    /**
     * Фабрика текстового подання.
     */
    public static class TextFactory extends PresenterFactory {
        @Override
        public Presenter create() {
            return new TextPresenter();
        }
    }

    /**
     * Фабрика табличного подання з заданим стилем.
     */
    public static class TableFactory extends PresenterFactory {
        private final TableStyle style;

        /**
         * @param style налаштування таблиці
         */
        public TableFactory(TableStyle style) {
            this.style = style;
        }

        @Override
        public Presenter create() {
            return new TablePresenter(style);
        }
    }
}
