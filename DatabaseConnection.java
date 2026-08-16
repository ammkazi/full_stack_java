import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/lms";
        String username = "root";
        String password = "12345678";

        try {

            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password);

            System.out.println("Connected to MySQL successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}