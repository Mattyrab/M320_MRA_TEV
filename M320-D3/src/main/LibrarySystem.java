package main;

import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager libraryManager = new LibraryManager();

        libraryManager.addBook(new Book(1, "Jurassic Park"));
        libraryManager.addBook(new Book(2, "The Lord Of The Rings"));
        libraryManager.addBook(new Book(3, "The Hunger Games"));

        while (true) {
            System.out.println("\nLibrarymanager:");
            System.out.println("1. Show all books");
            System.out.println("2. Lend a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Choose an option");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        libraryManager.displayBooks();
                        break;
                    case 2:
                        System.out.print("Input Id of the lending book: ");
                        int lendBookId = scanner.nextInt();
                        libraryManager.lendBook(lendBookId);
                        break;
                    case 3:
                        System.out.print("Input Id of the returning book: ");
                        int returnBookId = scanner.nextInt();
                        libraryManager.returnBook(returnBookId);
                        break;
                    case 4:
                        System.out.println("Gooybye :)");
                        return;
                    default:
                        System.out.println("False input: Try again :( ");
                        break;
                }
            } catch (InvalidInputException e) {
                System.out.println("Error :( " + e.getMessage());
            }
        }
    }
}
