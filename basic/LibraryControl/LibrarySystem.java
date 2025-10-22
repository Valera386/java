/**
 * Основной класс для демонстрации работы библиотечной системы.
 */
public class LibrarySystem {
    /**
     * Главный метод для запуска демонстрации библиотечной системы.
     * Создает библиотеку, добавляет элементы, отображает доступные элементы, занимает элемент и обрабатывает недоступные элементы.
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        Library library = new Library();

        // Добавление книг и журналов
        library.addItem(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        library.addItem(new Book("1984", "George Orwell"));
        library.addItem(new Magazine("National Geographic", 123));

        // Отображение доступных элементов
        library.displayAvailableItems();

        // Заимствование книги
        library.borrowItem("1984");

        // Отображение доступных элементов после заимствования
        library.displayAvailableItems();

        // Попытка занять несуществующий элемент
        library.borrowItem("Unknown Book");
    }
}