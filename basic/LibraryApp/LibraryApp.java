/**
 * Класс приложения для управления библиотекой.
 * Предоставляет пользовательский интерфейс для выполнения операций с книгами и пользователями.
 */
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LibraryApp {
    private Library library;
    private Scanner scanner;

    /**
     * Создает новое приложение библиотеки с инициализированным объектом Library и Scanner.
     */
    public LibraryApp() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    /**
     * Точка входа в приложение.
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }

    /**
     * Запускает основной цикл приложения, отображающий меню и обрабатывающий ввод пользователя.
     */
    private void run() {
        while (true) {
            showMenu();
            int choice = getIntInput("Выберите действие: ");
            if (choice == 0) {
                System.out.println("Программа завершена.");
                break;
            }
            handleMenu(choice);
        }
        scanner.close();
    }

    /**
     * Отображает меню доступных действий в консоли.
     */
    private void showMenu() {
        System.out.println("\n=== Система управления библиотекой ===");
        System.out.println("1. Добавить книгу");
        System.out.println("2. Удалить книгу");
        System.out.println("3. Найти книги по названию");
        System.out.println("4. Найти книги по автору");
        System.out.println("5. Добавить пользователя");
        System.out.println("6. Удалить пользователя");
        System.out.println("7. Выдать книгу");
        System.out.println("8. Вернуть книгу");
        System.out.println("9. Показать все книги");
        System.out.println("10. Показать всех пользователей");
        System.out.println("11. Показать выданные книги");
        System.out.println("0. Выход");
    }

    /**
     * Обрабатывает выбор пользователя из меню и вызывает соответствующий метод.
     * @param choice выбранное действие
     */
    private void handleMenu(int choice) {
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                removeBook();
                break;
            case 3:
                findBooksByTitle();
                break;
            case 4:
                findBooksByAuthor();
                break;
            case 5:
                addUser();
                break;
            case 6:
                removeUser();
                break;
            case 7:
                borrowBook();
                break;
            case 8:
                returnBook();
                break;
            case 9:
                showAllBooks();
                break;
            case 10:
                showAllUsers();
                break;
            case 11:
                showBorrowedBooks();
                break;
            default:
                System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }

    /**
     * Запрашивает у пользователя целое число и возвращает его.
     * @param prompt сообщение для запроса ввода
     * @return введенное целое число или -1 при ошибке
     */
    private int getIntInput(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите число.");
            return -1;
        }
    }

    /**
     * Добавляет новую книгу в библиотеку на основе введенных данных.
     */
    private void addBook() {
        int id = getIntInput("Введите ID книги: ");
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();
        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine();
        library.addBook(new Book(id, title, author));
        System.out.println("Книга добавлена.");
    }

    /**
     * Удаляет книгу из библиотеки по указанному ID.
     */
    private void removeBook() {
        int id = getIntInput("Введите ID книги для удаления: ");
        if (library.removeBook(id)) {
            System.out.println("Книга удалена.");
        } else {
            System.out.println("Книга не найдена или уже выдана.");
        }
    }

    /**
     * Ищет книги по названию и отображает результаты.
     */
    private void findBooksByTitle() {
        System.out.print("Введите название книги для поиска: ");
        String title = scanner.nextLine();
        List<Book> books = library.findBooksByTitle(title);
        if (books.isEmpty()) {
            System.out.println("Книги не найдены.");
        } else {
            books.forEach(System.out::println);
        }
    }

    /**
     * Ищет книги по автору и отображает результаты.
     */
    private void findBooksByAuthor() {
        System.out.print("Введите автора книги для поиска: ");
        String author = scanner.nextLine();
        List<Book> books = library.findBooksByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("Книги не найдены.");
        } else {
            books.forEach(System.out::println);
        }
    }

    /**
     * Добавляет нового пользователя в библиотеку.
     */
    private void addUser() {
        int id = getIntInput("Введите ID пользователя: ");
        System.out.print("Введите имя пользователя: ");
        String name = scanner.nextLine();
        library.addUser(new User(id, name));
        System.out.println("Пользователь добавлен.");
    }

    /**
     * Удаляет пользователя из библиотеки по указанному ID.
     */
    private void removeUser() {
        int id = getIntInput("Введите ID пользователя для удаления: ");
        if (library.removeUser(id)) {
            System.out.println("Пользователь удалён.");
        } else {
            System.out.println("Пользователь не найден или у него есть книги.");
        }
    }

    /**
     * Выдает книгу пользователю.
     */
    private void borrowBook() {
        int userId = getIntInput("Введите ID пользователя: ");
        int bookId = getIntInput("Введите ID книги: ");
        if (library.borrowBook(userId, bookId)) {
            System.out.println("Книга выдана.");
        } else {
            System.out.println("Ошибка: книга или пользователь не найдены, или книга уже выдана.");
        }
    }

    /**
     * Возвращает книгу в библиотеку.
     */
    private void returnBook() {
        int bookId = getIntInput("Введите ID книги для возврата: ");
        if (library.returnBook(bookId)) {
            System.out.println("Книга возвращена.");
        } else {
            System.out.println("Ошибка: книга не найдена или не была выдана.");
        }
    }

    /**
     * Отображает список всех книг в библиотеке.
     */
    private void showAllBooks() {
        List<Book> books = library.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста.");
        } else {
            books.forEach(System.out::println);
        }
    }

    /**
     * Отображает список всех пользователей библиотеки.
     */
    private void showAllUsers() {
        List<User> users = library.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("Пользователи отсутствуют.");
        } else {
            users.forEach(System.out::println);
        }
    }

    /**
     * Отображает список выданных книг с указанием пользователей.
     */
    private void showBorrowedBooks() {
        Map<Integer, Integer> borrowedBooks = library.getBorrowedBooks();
        if (borrowedBooks.isEmpty()) {
            System.out.println("Нет выданных книг.");
        } else {
            borrowedBooks.forEach((userId, bookId) -> {
                User user = library.getAllUsers().stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
                Book book = library.getAllBooks().stream().filter(b -> b.getId() == bookId).findFirst().orElse(null);
                if (user != null && book != null) {
                    System.out.println("Пользователь " + user.getName() + " (ID: " + userId + ") взял книгу: " + book.getTitle() + " (ID: " + bookId + ")");
                }
            });
        }
    }
}