import java.util.LinkedList;

class Book {
    private String isbn;
    private String title;
    private String author;
    private double price;

    public Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + "]";
    }

}

public class UnderStandLinkedList {
    public static void main(String[] args) {
        LinkedList<Book> bookList = new LinkedList<Book>();

        bookList.add(new Book("B101", "Java", "Aiman Kazi", 9.99));
        bookList.add(new Book("B102", "Python", "Aiman Kazi", 19.99));
        bookList.add(new Book("B103", "C++", "Aiman Kazi", 4.99));

        for (Book b : bookList) {
            System.out.println(b.toString());
        }

    }

}
