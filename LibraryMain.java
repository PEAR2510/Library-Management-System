import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Member");
            System.out.println("4. View Members");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    sc.nextLine();
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    BookDAO.addBook(title, author, qty);
                    break;

                case 2:
                    BookDAO.viewBooks();
                    break;

                case 3:
                    System.out.print("Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    MemberDAO.addMember(name, email);
                    break;

                case 4:
                    MemberDAO.viewMembers();
                    break;

                case 5:
                    System.out.print("Book ID: ");
                    int bid = sc.nextInt();
                    System.out.print("Member ID: ");
                    int mid = sc.nextInt();
                    IssueDAO.issueBook(bid, mid);
                    break;

                case 6:
                    System.out.print("Issue ID: ");
                    int iid = sc.nextInt();
                    IssueDAO.returnBook(iid);
                    break;

                case 7:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
