package com.java;

import com.java.exception.*;
import com.java.model.*;
import com.java.service.UserService;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws BookUnavailable {

		Library library = new Library();
		Scanner scan = new Scanner(System.in);
		Book book = new Book(null, null, null, null, null);
		int choice;

		library.addbook(new Book("Book1", "Author1", "123456", "Fiction", "20.0"));
		library.addbook(new Book("Book2", "Author2", "234567", "Non-Fiction", "25.0"));
		library.addbook(new Book("Book3", "Author3", "345678", "Mystery", "30.0"));
		library.adduser(new UserService("user1"));
		library.adduser(new UserService("user2"));
		library.adduser(new UserService("user3"));

		do {
			System.out.println("\nMenu:");
			System.out.println("0. Add books");
			System.out.println("1. Display all books");
			System.out.println("2. Search by Title");
			System.out.println("3. Search by Author");
			System.out.println("4. Search by Genre");
			System.out.println("5. Borrow a book");
			System.out.println("6. Return a book");
			System.out.println("7. Display available books");
			System.out.println("8. Add user");
			System.out.println("9. Issue book");
			System.out.println("10. Calculate fine for a user");
			System.out.println("11. Display all library cards");
			System.out.println("12. Display all users");
			System.out.println("13. Exit Application");
			System.out.print("Enter your choice: ");

			choice = scan.nextInt();
			scan.nextLine();

			switch (choice) {

			case 0:
				System.out.print("Enter title: ");
				String title1 = scan.nextLine();
				System.out.print("Enter author: ");
				String author1 = scan.nextLine();
				System.out.print("Enter ISBN: ");
				String isbn1 = scan.nextLine();
				System.out.print("Enter genre: ");
				String genre1 = scan.nextLine();
				System.out.print("Enter price: ");
				String price1 = scan.nextLine();

				library.addbook(new Book(title1, author1, isbn1, genre1, price1));
				break;
			case 1:
				library.displayallbooks();
				break;
			case 2:
				try {

					System.out.println("\nEnter title to search the book");
					String title = scan.nextLine();
					library.searchbytitle(title);
				} catch (BookNotFound e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					System.out.println("\nEnter Author to search the book");
					String author = scan.nextLine();
					library.searchbyauthor(author);
				} catch (BookNotFound e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					System.out.println("\nEnter genre to search for the book");
					String genre = scan.nextLine();
					library.searchbygenre(genre);
				} catch (BookNotFound e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try {
					System.out.println("Enter ISBN to borrow the book");
					String isbn = scan.nextLine();
					library.borrowbook(isbn);
				} catch (BookUnavailable | BookNotFound e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				try {
					System.out.println("Enter ISBN to return the book");
					String isbn2 = scan.nextLine();
					library.returnbook(isbn2);
				} catch (BookNotFound | BookPresentAlready e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				library.displayAvailable();
				break;
			case 8:
				System.out.print("Enter name of the user: ");
				String name1 = scan.nextLine();
				library.adduser(new UserService(name1));
				break;
			case 9:
				System.out.println("Enter ISBN of the book");
				String isbn = scan.nextLine();
				System.out.println("Enter User name");
				String name = scan.nextLine();
				try {
					library.issuedtouser(isbn, name);
				} catch (BookUnavailable e) {
					System.out.println(e.getMessage());
				}
				break;
			case 10:
				library.calculateFine();
				break;
			case 11:
				library.displayLibraryCards();
				break;
			case 12:
				library.displayallusers();
				break;
			case 13:
				scan.close();
				break;
			default:
				System.out.println("Enter numbers between 1 and 14");
			}
		} while (choice != 13);

	}
}
