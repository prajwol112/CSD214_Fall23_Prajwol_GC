package lab3.q3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
    static ArrayList<Publication> publications = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Magazine> magazines = new ArrayList<>();
    ArrayList<DiscMag> discMags = new ArrayList<>();

    public void menu() {
        System.out.println("\n------ Publication CRUD Menu ------");
        System.out.println("1. List All Books");
        System.out.println("2. Add Book");
        System.out.println("3. Edit Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Add Magazine");
        System.out.println("6. List All Magazines");
        System.out.println("7. Add DiscMag");
        System.out.println("8. List All DiscMags");
        System.out.println("0. Exit");
    }


    private static Scanner scanner  = new Scanner(System.in);

    private static int getInput() {
        System.out.println("Enter your choice: ");
        while ((!scanner.hasNextInt()) && (scanner.nextInt() < 0 || scanner.nextInt() > 8)) {
            System.out.println("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }


    public void run() {
        while (true) {
            menu();
            int choice = getInput();
            switch (choice) {
                case 1:
                    listAllBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    editBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    addMagazine();
                    break;
                case 6:
                    listAllMagazines();
                    break;
                case 7:
                    addDiscMag();
                    break;
                case 8:
                    listAllDiscMags();
                    break;
                case 0:
                    System.out.println("Goodbye, Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number: ");
                    break;
            }
        }
    }

    /**
     * Lists all the books in the publications
     */
    private static void listAllBooks() {
        System.out.println("\n------ List of Books ------");
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                Book book = (Book) publication;
                System.out.println(book.getTitle());
            }
        }
    }


    /**
     * Adds a book to the publications
     * */
    private static void addBook() {
        System.out.println("\n------ Add Book ------");
        scanner.nextLine(); // clear the buffer
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Book Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Initial Copies: ");
        int copies = scanner.nextInt();

        Book book = new Book(title, price, copies, author);
        publications.add(book);

        System.out.println("Book added successfully!");
    }

    /**
     * edits a book in the publications
     * */
    private static void editBook() {
        System.out.println("\n------ Edit Book ------");
        System.out.print("Enter the title of the book to edit: ");
        scanner.nextLine(); // Consume the newline character
        String titleToEdit = scanner.nextLine();

        for (Publication publication : publications) {
            if (publication instanceof Book && publication.getTitle().equalsIgnoreCase(titleToEdit)) {
                System.out.print("Enter new Book Title: ");
                String newTitle = scanner.nextLine();
                System.out.print("Enter new Book Author: ");
                String newAuthor = scanner.nextLine();
                System.out.print("Enter new Book Price: ");
                double newPrice = scanner.nextDouble();
                System.out.print("Enter new Copies: ");
                int newCopies = scanner.nextInt();

                ((Book) publication).setTitle(newTitle);
                ((Book) publication).setAuther(newAuthor);
                publication.setPrice(newPrice);
                publication.setCopies(newCopies);

                System.out.println("Book edited successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    /**
     * deletes a book in the publications
     * */
    private static void deleteBook() {
        System.out.println("\n------ Delete Book ------");
        System.out.print("Enter the title of the book to delete: ");
        scanner.nextLine(); // Consume the newline character
        String titleToDelete = scanner.nextLine();

        publications.removeIf(publication ->
                publication instanceof Book && publication.getTitle().equalsIgnoreCase(titleToDelete));

        System.out.println("Book deleted successfully!");
    }

    /**
     * adds a magazine to the publications
     * */
    private static void addMagazine() {
        System.out.println("\n------ Add Magazine ------");
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter Magazine Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Magazine Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Initial Copies: ");
        int copies = scanner.nextInt();
        System.out.print("Enter Order Quantity: ");
        int orderQty = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter Current Issue Date (YYYY-MM-DD): ");
        String dateString = scanner.nextLine();
        Date currIssue = parseDate(dateString);

        Magazine magazine = new Magazine(title, currIssue, price, copies);
        magazine.setOrderQty(orderQty);
        publications.add(magazine);

        System.out.println("Magazine added successfully!");
    }

    /**
     * lists all the magazines in the publications
     * */
    private static void listAllMagazines() {
        System.out.println("\n------ List of Magazines ------");
        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                System.out.println(publication);
            }
        }
    }

    /**
     * adds a discMag to the publications
     * */
    private static void addDiscMag() {
        System.out.println("\n------ Add DiscMag ------");
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter DiscMag Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter DiscMag Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Initial Copies: ");
        int copies = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter New Issue Date (YYYY-MM-DD): ");
        String dateString = scanner.nextLine();
        Date newIssue = parseDate(dateString);

        DiscMag discMag = new DiscMag(title, newIssue, price, copies);
        publications.add(discMag);

        System.out.println("DiscMag added successfully!");
    }

    /**
     * lists all the discMags in the publications
     * */
    private static void listAllDiscMags() {
        System.out.println("\n------ List of DiscMags ------");
        for (Publication publication : publications) {
            if (publication instanceof DiscMag) {
                System.out.println(publication);
            }
        }
    }

    /**
     * parses a date string to a Date object
     * */
    private static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Using the current date.");
            return new Date();
        }
    }

}
