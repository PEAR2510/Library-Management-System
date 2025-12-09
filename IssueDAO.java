import java.sql.*;
import java.time.LocalDate;

public class IssueDAO {

    public static void issueBook(int bookId, int memberId) {
        try (Connection con = DBConnection.getConnection()) {

            // Reduce quantity
            PreparedStatement check = con.prepareStatement("SELECT quantity FROM books WHERE id=?");
            check.setInt(1, bookId);
            ResultSet rs = check.executeQuery();
            if (rs.next() && rs.getInt("quantity") > 0) {

                PreparedStatement issue = con.prepareStatement(
                        "INSERT INTO issued_books(book_id, member_id, issue_date) VALUES (?, ?, ?)");
                issue.setInt(1, bookId);
                issue.setInt(2, memberId);
                issue.setDate(3, Date.valueOf(LocalDate.now()));
                issue.executeUpdate();

                PreparedStatement update = con.prepareStatement(
                        "UPDATE books SET quantity = quantity - 1 WHERE id=?");
                update.setInt(1, bookId);
                update.executeUpdate();

                System.out.println("Book issued successfully!");

            } else {
                System.out.println("Book not available.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void returnBook(int issueId) {
        try (Connection con = DBConnection.getConnection()) {

            // Update return date
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE issued_books SET return_date=? WHERE id=?");
            ps.setDate(1, Date.valueOf(LocalDate.now()));
            ps.setInt(2, issueId);
            ps.executeUpdate();

            System.out.println("Book returned!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
