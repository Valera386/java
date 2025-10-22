class Magazine implements LibraryItem {
    private String title;
    private int issueNumber;
    private boolean available;

    public Magazine(String title, int issueNumber) {
        this.title = title;
        this.issueNumber = issueNumber;
        this.available = true;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDetails() {
        return "Magazine: " + title + ", Issue: #" + issueNumber;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}