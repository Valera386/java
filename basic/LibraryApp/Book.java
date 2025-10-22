/**
 * Класс, представляющий книгу в библиотеке.
 * Содержит информацию о книге, включая ID, название, автора и статус доступности.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    /**
     * Создает новую книгу с указанными параметрами.
     * @param id уникальный идентификатор книги
     * @param title название книги
     * @param author автор книги
     */
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // По умолчанию книга доступна
    }

    /**
     * Возвращает ID книги.
     * @return ID книги
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает название книги.
     * @return название книги
     */
    public String getTitle() {
        return title;
    }

    /**
     * Возвращает автора книги.
     * @return автор книги
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Проверяет, доступна ли книга.
     * @return true, если книга доступна, иначе false
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Устанавливает статус доступности книги.
     * @param available true для отметки книги как доступной, false в противном случае
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * Возвращает строковое представление книги.
     * @return строка с информацией о книге
     */
    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "', author='" + author + "', available=" + isAvailable + "}";
    }
}