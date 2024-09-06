package bookstoremanagement;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Bookstore Unit Tests
 * Unit tests for the Bookstore class using JUnit 4.
 */
public class BookstoreTest 
{
    private Bookstore bookstore;

    // Sets up a fresh instance of Bookstore before each test
    @Before
    public void setUp() 
    {
        bookstore = new Bookstore(10); // Initialize a bookstore with a capacity of 10 books
    }

    @Test
    public void testAddBook() 
    {
        Book book = new Book("Effective Java", "Joshua Bloch", "9780134685991", 45.99);
        bookstore.addBook(book);

        // Assert that the count of books increased
        assertEquals(1, bookstore.getCount());

        // Assert that the added book is the first book in the list
        Book[] books = bookstore.getBooks();
        assertNotNull(books[0]);
        assertEquals("Effective Java", books[0].getTitle());
    }

    @Test
    public void testFindBookByTitle() 
    {
        Book book = new Book("Clean Code", "Robert C. Martin", "9780132350884", 39.99);
        bookstore.addBook(book);

        // Find the book by its title
        Book foundBook = bookstore.findBookByTitle("Clean Code");

        // Assert that the book was found and its details match
        assertNotNull(foundBook);
        assertEquals("Clean Code", foundBook.getTitle());
        assertEquals("Robert C. Martin", foundBook.getAuthor());
    }

    @Test
    public void testRemoveBookByTitle() 
    {
        Book book1 = new Book("Design Patterns", "Erich Gamma", "9780201633610", 49.99);
        Book book2 = new Book("Refactoring", "Martin Fowler", "9780201485677", 59.99);

        bookstore.addBook(book1);
        bookstore.addBook(book2);

        // Remove the first book by title
        bookstore.removeBookByTitle("Design Patterns");

        // Assert that the count of books decreased
        assertEquals(1, bookstore.getCount());

        // Ensure the first book was removed and only the second book remains
        Book[] books = bookstore.getBooks();
        assertEquals("Refactoring", books[0].getTitle());
        assertNull(books[1]); // The second slot should now be null
    }

    @Test
    public void testUpdateBookDetails() 
    {
        Book book = new Book("The Pragmatic Programmer", "Andrew Hunt", "9780201616224", 39.99);
        bookstore.addBook(book);

        // Update the book details
        bookstore.updateBookDetails("The Pragmatic Programmer", "David Thomas", "9780135957059", 49.99);

        // Find the updated book and assert that the details were changed
        Book updatedBook = bookstore.findBookByTitle("The Pragmatic Programmer");
        assertEquals("David Thomas", updatedBook.getAuthor());
        assertEquals("9780135957059", updatedBook.getIsbn());
        assertEquals(49.99, updatedBook.getPrice(), 0.01);
    }

    @Test
    public void testListBooks() 
    {
        Book book1 = new Book("Book1", "Author1", "ISBN1", 10.99);
        Book book2 = new Book("Book2", "Author2", "ISBN2", 15.99);
        bookstore.addBook(book1);
        bookstore.addBook(book2);

        // Capture the output of listBooks()
        bookstore.listBooks(); // This will print the books, but we assume it's working as per method implementation
        Book[] books = bookstore.getBooks();

        // Assert that both books are listed
        assertEquals(2, bookstore.getCount());
        assertEquals("Book1", books[0].getTitle());
        assertEquals("Book2", books[1].getTitle());
    }
}
