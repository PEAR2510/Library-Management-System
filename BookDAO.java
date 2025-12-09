import java.sql.*;
import java.util.*;

public class BookDAO {

    public static void addBook(String title, String author, int quantity) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO books(title, author, quantity) VALUES (?, ?, ?)");
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, quantity);
            ps.executeUpdate();

            System.out.println("Book added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewBooks() {
        try (Connection con = DBConnection.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Title: " + rs.getString("title") +
                        ", Author: " + rs.getString("author") +
                        ", Qty: " + rs.getInt("quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
