import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BooksDatabase {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/lms";
        String username = "root";
        String password = "12345678";

        try {
            // Establish connection
            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password);

            System.out.println("Database connected successfully!");

            // Create statement
            Statement stmt = con.createStatement();

            // SQL query
            String query = "SELECT * FROM books";

            // Execute query
            ResultSet rs = stmt.executeQuery(query);

            // Display data
            System.out.println("\nBooks Information");
            System.out.println("---------------------------------------------");

            while (rs.next()) {

                String isbn = rs.getString("isbn");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int copies = rs.getInt("no_of_copies");

                System.out.println("ISBN       : " + isbn);
                System.out.println("Title      : " + title);
                System.out.println("Author     : " + author);
                System.out.println("Copies     : " + copies);
                System.out.println("---------------------------------------------");
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}