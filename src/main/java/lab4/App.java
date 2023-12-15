package lab4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
    static ArrayList<Publication> publications = new ArrayList<>();
    private static CashTill cashTill = new CashTill();
    private static ArrayList<SaleableItem> saleableItems = new ArrayList<>();

    private static Scanner scanner  = new Scanner(System.in);


    public void menu() {
        System.out.println("\n-------------------------Main-------------------------");
        System.out.println("1. Books");
        System.out.println("2. Tickets");
        System.out.println("3. Magazines");
        System.out.println("4. Pencils");
        System.out.println("0. Exit");
    }



/**
 * Getting the input from the user as a choice that theu selevt from 0 to 8
 * */
    private static int getInput() {
        System.out.println("Enter your choice: ");
        while ((!scanner.hasNextInt()) && (scanner.nextInt() < 0 || scanner.nextInt() > 8)) {
            System.out.println("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }



    /**
     * menu for the Pencin
     * */
    private void pencilMenu() {
        System.out.println("\n-------------------------Pencils-------------------------");
        System.out.println("1. Sell a Pencil");
        System.out.println("2. Exit");

        int choice = getInput();
        switch (choice) {
            case 1:
                sellPencil();
                break;
            case 2:
                System.out.println("Exiting Pencils Menu");
                break;
            default:
                System.out.println("Invalid input. Please enter a number: ");
                break;
        }
    }


    /**
     * The menu for the books
     * */

    private void bookMenu() {
        System.out.println("\n-------------------------Books-------------------------");
        System.out.println("1. To Kill a Mockingbird");
        System.out.println("2. Da Vinci Code");
        System.out.println("3. Add a Book");
        System.out.println("4. Edit a Book");
        System.out.println("5. Delete a Book");
        System.out.println("6. Sell a book");
        System.out.println("7. Quit");

        int choice = getInput();
        switch (choice) {
            case 1:
                // Handle To Kill a Mockingbird
                break;
            case 2:
                // Handle Da Vinci Code
                break;
            case 3:
                addBook();
                break;
            case 4:
                editBook();
                break;
            case 5:
                deleteBook();
                break;
            case 6:
                sellBook();
                break;
            case 7:
                System.out.println("Exiting Books Menu");
                break;
            default:
                System.out.println("Invalid input. Please enter a number: ");
                break;
        }
    }

    /**
     * The menu for the tickets
     * */

    private void ticketMenu() {
        System.out.println("\n-------------------------Tickets-------------------------");
        System.out.println("1. Sell a Ticket");
        System.out.println("2. Exit");

        int choice = getInput();
        switch (choice) {
            case 1:
                sellTicket();
                break;
            case 2:
                System.out.println("Exiting Tickets Menu");
                break;
            default:
                System.out.println("Invalid input. Please enter a number: ");
                break;
        }
    }

    private void magazineMenu() {
        System.out.println("\n-------------------------Magazines-------------------------");
        System.out.println("1. List All Magazines");
        System.out.println("2. Add a Magazine");
        System.out.println("3. Sell a Magazine");
        System.out.println("4. Exit");

        int choice = getInput();
        switch (choice) {
            case 1:
                listAllMagazines();
                break;
            case 2:
                addMagazine();
                break;
            case 3:
                sellMagazine();
                break;
            case 4:
                System.out.println("Exiting Magazines Menu");
                break;
            default:
                System.out.println("Invalid input. Please enter a number: ");
                break;
        }
    }



    public void run() {
        while (true) {
            menu();
            int choice = getInput();
            switch (choice) {
                case 1:
                    bookMenu();
                    break;
                case 2:
                    ticketMenu();
                    break;
                case 3:
                    magazineMenu();
                    break;
                case 4:
                    pencilMenu();
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
 * Methods to sell books
 * */
    private void sellBook() {
        System.out.println("\n-------------------------Sell a Book-------------------------");

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        // Assume you have a method to find a book by title in your publications list
        Book book = findBookByTitle(title);

        if (book != null) {
            System.out.println("Book found:");
            System.out.println(book);

            // You can add more prompts or logic here if needed

            // Update CashTill
            cashTill.sellItem(book);
            System.out.println("Book sold successfully!");
        } else {
            System.out.println("Book not found.");
        }
    }


    /**
     * Finding a book by title to sell.
     * */
    private Book findBookByTitle(String title) {
        for (Publication publication : publications) {
            if (publication instanceof Book && publication.getTitle().equalsIgnoreCase(title)) {
                return (Book) publication;
            }
        }
        return null;
    }


    /**
     * function to sell ticker
     * */
    private void sellTicket() {
        System.out.println("\n-------------------------Sell a Ticket-------------------------");

        System.out.print("Enter Event Name: ");
        String eventName = scanner.nextLine();

        // Assume you have a method to find a ticket by event name in your saleableItems list
        Ticket ticket = findTicketByEventName(eventName);

        if (ticket != null) {
            System.out.println("Ticket found:");
            System.out.println(ticket);

            // Update CashTill
            cashTill.sellItem(ticket);
            System.out.println("Ticket sold successfully!");
        } else {
            System.out.println("Ticket not found.");
        }
    }

    private Ticket findTicketByEventName(String eventName) {
        for (SaleableItem item : saleableItems) {
            if (item instanceof Ticket && ((Ticket) item).getEventName().equalsIgnoreCase(eventName)) {
                return (Ticket) item;
            }
        }
        return null;
    }


    /**
     * sells an item from the saleableItems
     * */
    private void sellItem() {
        System.out.println("\n------ Sell Item ------");
        System.out.print("Enter the title of the item to sell: ");
        scanner.nextLine(); // Consume the newline character
        String titleToSell = scanner.nextLine();

        for (SaleableItem item : saleableItems) {
            if (item instanceof Publication && ((Publication) item).getTitle().equalsIgnoreCase(titleToSell)) {
                cashTill.sellItem(item);
                return;
            }
        }
        System.out.println("Item not found.");
    }

    private void sellMagazine() {
        System.out.println("\n-------------------------Sell a Magazine-------------------------");

        System.out.print("Enter Magazine Title: ");
        String title = scanner.nextLine();

        // Assume you have a method to find a magazine by title in your publications list
        Magazine magazine = findMagazineByTitle(title);

        if (magazine != null) {
            System.out.println("Magazine found:");
            System.out.println(magazine);

            // You can add more prompts or logic here if needed

            // Update CashTill
            cashTill.sellItem(magazine);
            System.out.println("Magazine sold successfully!");
        } else {
            System.out.println("Magazine not found.");
        }
    }
    private Magazine findMagazineByTitle(String title) {
        for (Publication publication : publications) {
            if (publication instanceof Magazine && publication.getTitle().equalsIgnoreCase(title)) {
                return (Magazine) publication;
            }
        }
        return null;
    }

    private void sellPencil() {
        System.out.println("\n-------------------------Sell a Pencil-------------------------");

        System.out.print("Enter Pencil Color: ");
        String color = scanner.nextLine();


        Pencil pencil = findPencilByColor(color);

        if (pencil != null) {
            System.out.println("Pencil found:");
            System.out.println(pencil);

            // You can add more prompts or logic here if needed

            // Update CashTill
            cashTill.sellItem(pencil);
            System.out.println("Pencil sold successfully!");
        } else {
            System.out.println("Pencil not found.");
        }
    }

    private Pencil findPencilByColor(String color) {
        for (SaleableItem item : saleableItems) {
            if (item instanceof Pencil && ((Pencil) item).getColor().equalsIgnoreCase(color)) {
                return (Pencil) item;
            }
        }
        return null;
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
