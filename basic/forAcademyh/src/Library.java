class Library {
    private java.util.List<LibraryItem> items;

    public Library() {
        items = new java.util.ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void displayAvailableItems() {
        System.out.println("Available Items in the Library:");
        for (LibraryItem item : items) {
            if (item.isAvailable()) {
                System.out.println(item.getDetails());
            }
        }
    }

    public void borrowItem(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title) && item.isAvailable()) {
                if (item instanceof Book) {
                    ((Book) item).setAvailable(false);
                } else if (item instanceof Magazine) {
                    ((Magazine) item).setAvailable(false);
                }
                System.out.println("Borrowed: " + item.getDetails());
                return;
            }
        }
        System.out.println("Item '" + title + "' not found or unavailable.");
    }
}