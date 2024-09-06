package bookstoremanagement;

import java.util.Arrays;

/**
 * Bookstore Class
 * Handles the addition, removal, listing, and management of books within the bookstore.
 */
public class Bookstore 
{
    private Book[] books;
    private int count;
    private int submissionCounter; // Tracks the submission number of each book

    // Constructor to initialize bookstore with a given capacity
    public Bookstore(int capacity) 
    {
        books = new Book[capacity];
        count = 0;
        submissionCounter = 1; // Start submission numbers from 1
    }

    // Adds a book to the bookstore and assigns a unique submission number
    public void addBook(Book book) 
    {
        if (count < books.length) 
        {
            book.setSubmissionNumber(submissionCounter++); // Assign submission number
            books[count] = book;
            count++;
        } 
        else 
        {
            System.out.println("Bookstore is full. Cannot add more books.");
        }
    }

    // Lists all books in the bookstore, with submission numbers
    public void listBooks() 
    {
        System.out.println("Listing all books:");
        for (int i = 0; i < count; i++) 
        {
            System.out.println(books[i].displayInfo());
        }
    }

    // Finds a book by its title
    public Book findBookByTitle(String title) 
    {
        for (int i = 0; i < count; i++) 
        {
            if (books[i].getTitle().equalsIgnoreCase(title)) 
            {
                return books[i];
            }
        }
        return null;
    }

    // Removes a book by its title
    public void removeBookByTitle(String title) 
    {
        for (int i = 0; i < count; i++) 
        {
            if (books[i].getTitle().equalsIgnoreCase(title)) 
            {
                books[i] = books[count - 1]; // Replace with last book
                books[count - 1] = null; // Nullify the last book
                count--;
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Updates book details by title
    public void updateBookDetails(String title, String newAuthor, String newIsbn, double newPrice) 
    {
        Book book = findBookByTitle(title);
        if (book != null) 
        {
            book.setAuthor(newAuthor);
            book.setIsbn(newIsbn);
            book.setPrice(newPrice);
        } 
        else 
        {
            System.out.println("Book not found.");
        }
    }

    // Getter for books
    public Book[] getBooks() 
    {
        return Arrays.copyOf(books, count);
    }

    // Getter for count
    public int getCount() 
    {
        return count;
    }
}
