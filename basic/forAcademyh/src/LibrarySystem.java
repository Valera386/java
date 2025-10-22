// Главный класс для демонстрации работы
public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Добавляем книги и журналы
        library.addItem(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        library.addItem(new Book("1984", "George Orwell"));
        library.addItem(new Magazine("National Geographic", 123));

        // Показываем доступные элементы
        library.displayAvailableItems();

        // Занимаем книгу
        library.borrowItem("1984");

        // Показываем доступные элементы после займа
        library.displayAvailableItems();

        // Пробуем занять несуществующий элемент
        library.borrowItem("Unknown Book");
    }
}