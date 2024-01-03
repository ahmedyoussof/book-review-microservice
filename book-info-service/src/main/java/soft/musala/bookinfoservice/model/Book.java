package soft.musala.bookinfoservice.model;

public class Book {

    private String bookId;
    private String name;

    public Book(String bookId, String name) {
        this.bookId = bookId;
        this.name = name;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
