package bookstoremanagement;

import java.util.Scanner;

/**
 * BookstoreManagement Class
 * Manages the bookstore operations, including adding, listing, searching,
 * updating, and removing books. Acts as the main entry point for the application.
 */
public class BookstoreManagement 
{
    public static void main(String[] args)
    {
        // Print Welcome Message
        System.out.println("WELCOME TO THE BOOK MANAGEMENT SYSTEM");
        System.out.println("****************************************************");

        // Initialize Bookstore with a capacity of 100 books
        Bookstore bookstore = new Bookstore(100);
        Scanner scanner = new Scanner(System.in);
        String command;

        // Main loop to handle user input and bookstore operations
        do 
        {
            System.out.println("\nBookstore Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. List Books");
            System.out.println("3. Find Book by Title");
            System.out.println("4. Remove Book by Title");
            System.out.println("5. Update Book Details");
            System.out.println("6. Exit");
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command) 
            {
                case "1":
                    try 
                    {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Enter price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        bookstore.addBook(new Book(title, author, isbn, price));
                        System.out.println("Book added successfully.");
                    } 
                    catch (NumberFormatException e) 
                    {
                        System.out.println("Invalid price format. Please enter a valid number.");
                    }
                    break;

                case "2":
                    bookstore.listBooks();
                    break;

                case "3":
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book book = bookstore.findBookByTitle(searchTitle);
                    if (book != null) 
                    {
                        System.out.println("Found book: " + book.displayInfo());
                    } 
                    else 
                    {
                        System.out.println("Book not found.");
                    }
                    break;

                case "4":
                    System.out.print("Enter title to remove: ");
                    String removeTitle = scanner.nextLine();
                    bookstore.removeBookByTitle(removeTitle);
                    System.out.println("Book removed successfully (if it existed).");
                    break;

                case "5":
                    System.out.print("Enter title of book to update: ");
                    String updateTitle = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new ISBN: ");
                    String newIsbn = scanner.nextLine();
                    double newPrice = 0;
                    boolean validPrice = false;
                    while (!validPrice) 
                    {
                        System.out.print("Enter new price: ");
                        try 
                        {
                            newPrice = Double.parseDouble(scanner.nextLine());
                            validPrice = true;
                        } 
                        catch (NumberFormatException e) 
                        {
                            System.out.println("Invalid price format. Please enter a valid number.");
                        }
                    }
                    bookstore.updateBookDetails(updateTitle, newAuthor, newIsbn, newPrice);
                    System.out.println("Book details updated successfully.");
                    break;

                case "6":
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        } 
        while (!command.equals("6"));

        scanner.close();
    }
}
