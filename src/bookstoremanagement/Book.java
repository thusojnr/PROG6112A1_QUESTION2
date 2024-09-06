package bookstoremanagement;

/**
 * Book Class
 * Represents a book with title, author, ISBN, price, and submission order.
 */
public class Book 
{
    private String title;
    private String author;
    private String isbn;
    private double price;
    private int submissionNumber;

    // Constructor for creating a book object
    public Book(String title, String author, String isbn, double price) 
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    // Getters
    public String getTitle() 
    {
        return title;
    }

    public String getAuthor() 
    {
        return author;
    }

    public String getIsbn() 
    {
        return isbn;
    }

    public double getPrice() 
    {
        return price;
    }

    public int getSubmissionNumber() 
    {
        return submissionNumber;
    }

    // Setters
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public void setIsbn(String isbn) 
    {
        this.isbn = isbn;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    public void setSubmissionNumber(int submissionNumber) 
    {
        this.submissionNumber = submissionNumber;
    }

    // Displays the book's details, including the submission order
    public String displayInfo() 
    {
        return "Submission #" + submissionNumber + " | Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Price: $" + price;
    }
}
