/**
 * Представляет журнал в библиотеке, реализующий интерфейс LibraryItem.
 */
class Magazine implements LibraryItem {
    private String title;
    private int issueNumber;
    private boolean available;

    /**
     * Создает журнал с указанным названием и номером выпуска.
     * Журнал изначально доступен.
     * @param title название журнала
     * @param issueNumber номер выпуска журнала
     */
    public Magazine(String title, int issueNumber) {
        this.title = title;
        this.issueNumber = issueNumber;
        this.available = true;
    }

    /**
     * Возвращает название журнала.
     * @return название журнала
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Предоставляет строковое представление подробностей журнала.
     * @return строка, содержащая название и номер выпуска журнала
     */
    @Override
    public String getDetails() {
        return "Журнал: " + title + ", Выпуск: #" + issueNumber;
    }

    /**
     * Проверяет, доступен ли журнал для заимствования.
     * @return true, если журнал доступен, false в противном случае
     */
    @Override
    public boolean isAvailable() {
        return available;
    }

    /**
     * Устанавливает статус доступности журнала.
     * @param available true, чтобы отметить журнал как доступный, false в противном случае
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
}