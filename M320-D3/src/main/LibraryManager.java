package main;

import java.util.*;

public class LibraryManager {
    private List<Book> books;

    public LibraryManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void lendBook(int bookId) throws InvalidInputException {
        Book book = findBookById(bookId);
        if (book == null) {
            throw new InvalidInputException("Buch mit ID " + bookId + " nicht gefunden.");
        }
        if (!book.isAvailable()) {
            throw new InvalidInputException("Das Buch '" + book.getTitle() + "' ist bereits ausgeliehen.");
        }
        book.lend();
        System.out.println("Das Buch '" + book.getTitle() + "' wurde ausgeliehen.");
    }

    public void returnBook(int bookId) throws InvalidInputException {
        Book book = findBookById(bookId);
        if (book == null) {
            throw new InvalidInputException("Buch mit ID " + bookId + " nicht gefunden.");
        }
        if (book.isAvailable()) {
            throw new InvalidInputException("Das Buch '" + book.getTitle() + "' wurde noch nicht ausgeliehen.");
        }
        book.returnBook();
        System.out.println("Das Buch '" + book.getTitle() + "' wurde zurückgegeben.");
    }

    private Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library");
        } else {
            for (Book book : books) {
                System.out.println("ID: " + book.getBookId() + ", Title: " + book.getTitle() + ", Available: " + (book.isAvailable() ? "Yes" : "No"));
            }
        }
    }
}
