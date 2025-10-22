/**
 * Класс, представляющий библиотеку, управляющую книгами, пользователями и выданными книгами.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<User> users;
    private Map<Integer, Integer> borrowedBooks; // userId -> bookId

    /**
     * Создает новую библиотеку с пустыми списками книг, пользователей и выданных книг.
     */
    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        borrowedBooks = new HashMap<>();
    }

    /**
     * Добавляет книгу в библиотеку.
     * @param book книга для добавления
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Удаляет книгу из библиотеки по ID.
     * @param bookId ID книги для удаления
     * @return true, если удаление успешно, иначе false
     */
    public boolean removeBook(int bookId) {
        Book book = books.stream().filter(b -> b.getId() == bookId).findFirst().orElse(null);
        if (book != null && book.isAvailable()) {
            books.remove(book);
            return true;
        }
        return false;
    }

    /**
     * Ищет книги по названию.
     * @param title часть названия для поиска
     * @return список найденных книг
     */
    public List<Book> findBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Ищет книги по автору.
     * @param author часть имени автора для поиска
     * @return список найденных книг
     */
    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Добавляет пользователя в библиотеку.
     * @param user пользователь для добавления
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Удаляет пользователя из библиотеки по ID.
     * @param userId ID пользователя для удаления
     * @return true, если удаление успешно, иначе false
     */
    public boolean removeUser(int userId) {
        if (borrowedBooks.containsKey(userId)) {
            return false; // Нельзя удалить пользователя, у которого есть книги
        }
        User user = users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }

    /**
     * Выдает книгу пользователю.
     * @param userId ID пользователя
     * @param bookId ID книги
     * @return true, если выдача успешна, иначе false
     */
    public boolean borrowBook(int userId, int bookId) {
        Book book = books.stream().filter(b -> b.getId() == bookId).findFirst().orElse(null);
        User user = users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
        if (book != null && user != null && book.isAvailable() && !borrowedBooks.containsKey(userId)) {
            book.setAvailable(false);
            borrowedBooks.put(userId, bookId);
            return true;
        }
        return false;
    }

    /**
     * Возвращает книгу в библиотеку.
     * @param bookId ID книги для возврата
     * @return true, если возврат успешный, иначе false
     */
    public boolean returnBook(int bookId) {
        Book book = books.stream().filter(b -> b.getId() == bookId).findFirst().orElse(null);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            borrowedBooks.values().removeIf(id -> id == bookId);
            return true;
        }
        return false;
    }

    /**
     * Возвращает список всех книг в библиотеке.
     * @return копия списка книг
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Возвращает список всех пользователей библиотеки.
     * @return копия списка пользователей
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    /**
     * Возвращает карту выданных книг (userId -> bookId).
     * @return копия карты выданных книг
     */
    public Map<Integer, Integer> getBorrowedBooks() {
        return new HashMap<>(borrowedBooks);
    }
}