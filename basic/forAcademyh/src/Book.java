class Book implements LibraryItem {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDetails() {
        return "Book: " + title + ", Author: " + author;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}