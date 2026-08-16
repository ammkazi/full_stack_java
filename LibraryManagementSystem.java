import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LibraryManagementSystem {

    static String url = "jdbc:mysql://localhost:3306/lms";
    static String username = "root";
    static String password = "12345678";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            int choice;

            do {
                System.out.println("\n======================================");
                System.out.println("       LIBRARY MANAGEMENT SYSTEM");
                System.out.println("======================================");
                System.out.println("1. Add Book");
                System.out.println("2. Display All Books");
                System.out.println("3. Search Book");
                System.out.println("4. Update Book");
                System.out.println("5. Delete Book");
                System.out.println("6. Exit");
                System.out.println("======================================");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        addBook();
                        break;

                    case 2:
                        displayBooks();
                        break;

                    case 3:
                        searchBook();
                        break;

                    case 4:
                        updateBook();
                        break;

                    case 5:
                        deleteBook();
                        break;

                    case 6:
                        System.out.println("Thank you for using Library Management System!");
                        break;

                    default:
                        System.out.println("Invalid choice!");

                }

            } while (choice != 6);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================================
    // ADD BOOK
    // =========================================

    static void addBook() {

        try {

            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password);

            System.out.print("Enter ISBN: ");
            String isbn = sc.next();

            sc.nextLine();

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            System.out.print("Enter Number of Copies: ");
            int copies = sc.nextInt();

            String query = "INSERT INTO books (isbn, title, author, no_of_copies) VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, isbn);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setInt(4, copies);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Book added successfully!");
            }

            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================================
    // DISPLAY BOOKS
    // =========================================

    static void displayBooks() {

        try {

            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password);

            String query = "SELECT * FROM books";

            PreparedStatement pstmt = con.prepareStatement(query);

            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n============== BOOKS ==============");

            while (rs.next()) {

                System.out.println("ISBN        : " + rs.getString("isbn"));
                System.out.println("Title       : " + rs.getString("title"));
                System.out.println("Author      : " + rs.getString("author"));
                System.out.println("Copies      : " + rs.getInt("no_of_copies"));

                System.out.println("------------------------------------");
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================================
    // SEARCH BOOK
    // =========================================

    static void searchBook() {

        try {

            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password);

            System.out.print("Enter ISBN to search: ");
            String isbn = sc.next();

            String query = "SELECT * FROM books WHERE isbn = ?";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, isbn);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                System.out.println("\nBook Found!");
                System.out.println("ISBN        : " + rs.getString("isbn"));
                System.out.println("Title       : " + rs.getString("title"));
                System.out.println("Author      : " + rs.getString("author"));
                System.out.println("Copies      : " + rs.getInt("no_of_copies"));

            } else {

                System.out.println("Book not found!");

            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================================
    // UPDATE BOOK
    // =========================================

    static void updateBook() {

        try {

            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password);

            System.out.print("Enter ISBN of book to update: ");
            String isbn = sc.next();

            sc.nextLine();

            System.out.print("Enter new title: ");
            String title = sc.nextLine();

            System.out.print("Enter new author: ");
            String author = sc.nextLine();

            System.out.print("Enter new number of copies: ");
            int copies = sc.nextInt();

            String query = """
                    UPDATE books
                    SET title = ?, author = ?, no_of_copies = ?
                    WHERE isbn = ?
                    """;

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setInt(3, copies);
            pstmt.setString(4, isbn);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Book not found!");
            }

            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================================
    // DELETE BOOK
    // =========================================

    static void deleteBook() {

        try {

            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password);

            System.out.print("Enter ISBN of book to delete: ");
            String isbn = sc.next();

            String query = "DELETE FROM books WHERE isbn = ?";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setString(1, isbn);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found!");
            }

            pstmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}