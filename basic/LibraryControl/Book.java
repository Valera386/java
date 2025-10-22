/**
 * Представляет книгу в библиотеке, реализующую интерфейс LibraryItem.
 */
class Book implements LibraryItem {
    private String title;
    private String author;
    private boolean available;

    /**
     * Создает книгу с указанным названием и автором.
     * Книга изначально доступна.
     * @param title название книги
     * @param author автор книги
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    /**
     * Возвращает название книги.
     * @return название книги
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Предоставляет строковое представление подробностей книги.
     * @return строка, содержащая название и автора книги
     */
    @Override
    public String getDetails() {
        return "Книга: " + title + ", Автор: " + author;
    }

    /**
     * Проверяет, доступна ли книга для заимствования.
     * @return true, если книга доступна, false в противном случае
     */
    @Override
    public boolean isAvailable() {
        return available;
    }

    /**
     * Устанавливает статус доступности книги.
     * @param available true, чтобы отметить книгу как доступную, false в противном случае
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }
}