/**
 * Представляет библиотеку, управляющую коллекцией библиотечных элементов, таких как книги и журналы.
 */
class Library {
    private java.util.List<LibraryItem> items;

    /**
     * Создает пустую библиотеку с инициализированным списком элементов.
     */
    public Library() {
        items = new java.util.ArrayList<>();
    }

    /**
     * Добавляет библиотечный элемент в коллекцию.
     * @param item библиотечный элемент для добавления
     */
    public void addItem(LibraryItem item) {
        items.add(item);
    }

    /**
     * Отображает все доступные элементы в библиотеке.
     * Выводит подробности каждого элемента, который в данный момент доступен.
     */
    public void displayAvailableItems() {
        System.out.println("Доступные элементы в библиотеке:");
        for (LibraryItem item : items) {
            if (item.isAvailable()) {
                System.out.println(item.getDetails());
            }
        }
    }

    /**
     * Занимает элемент из библиотеки по его названию, если он доступен.
     * Обновляет статус доступности элемента и выводит результат заимствования.
     * @param title название элемента для заимствования
     */
    public void borrowItem(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title) && item.isAvailable()) {
                if (item instanceof Book) {
                    ((Book) item).setAvailable(false);
                } else if (item instanceof Magazine) {
                    ((Magazine) item).setAvailable(false);
                }
                System.out.println("Занято: " + item.getDetails());
                return;
            }
        }
        System.out.println("Элемент '" + title + "' не найден или недоступен.");
    }
}