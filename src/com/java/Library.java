package com.java;

import java.util.ArrayList;
import java.util.List;
import com.java.exception.*;
import com.java.model.Book;
import com.java.service.UserService;

public class Library {

	List<Book> books = new ArrayList<Book>();
	List<UserService> users = new ArrayList<UserService>();

	private Book searchbyisbn(String ISBN) {
		for (Book book : books) {
			if (book.getIsbn().equals(ISBN)) {
				return book;
			}
		}
		return null;
	}

	public void addbook(Book book) {
		books.add(book);
		System.out.println("Book added to the library");
	}

	public void searchbytitle(String Title) throws BookNotFound {
		int a = 0;
		for (Book book : books) {
			if (book.gettitle().equalsIgnoreCase(Title)) {
				System.out.println(book);
				a++;
			}
		}
		if (a == 0) {
			throw new BookNotFound("Book with title " + Title + " not found");
		}

	}

	public void searchbyauthor(String Author) throws BookNotFound {
		int a = 0;
		for (Book book : books) {
			if (book.getauthor().equalsIgnoreCase(Author)) {
				System.out.println(book);
				a++;
			}
		}
		if (a == 0) {
			throw new BookNotFound("Book with author " + Author + " not found");
		}

	}

	public void searchbygenre(String Genre) throws BookNotFound {
		int a = 0;
		for (Book book : books) {
			if (book.getgenre().equalsIgnoreCase(Genre)) {
				System.out.println(book);
				a++;
			}
		}
		if (a == 0) {
			throw new BookNotFound("Book with genre " + Genre + " not found");
		}

	}

	public void borrowbook(String ISBN) throws BookUnavailable, BookNotFound {
		int a = 0;
		for (Book book : books) {
			if (book.getIsbn().equals(ISBN)) {
//		Book book1 = searchbyisbn(ISBN);
				if (book.isAvailable(ISBN)) {
					book.setAvailable(false);
					System.out.println("\nBook with ISBN " + ISBN + " has been borrowed.");

				} else {
					throw new BookUnavailable("Book with ISBN " + ISBN + " is unavailable.");
				}
				a++;
			}
		}
		if (a == 0) {
			throw new BookNotFound("Book with ISBN " + ISBN + " not found.");
		}
	}

	public void returnbook(String ISBN) throws BookNotFound, BookPresentAlready {
		int a = 0;
		for (Book book : books) {
			if (book.getIsbn().equals(ISBN)) {
				if (!book.isAvailable(ISBN)) {
					book.setAvailable(true);
					System.out.println("\nBook with ISBN " + ISBN + " has been returned.");

				} else {
					throw new BookPresentAlready("Book with ISBN " + ISBN + " was never borrowed.");
				}
				a++;
			}
		}
		if (a == 0) {
			throw new BookNotFound("Book with ISBN " + ISBN + " not found");
		}

	}

	public void displayallbooks() {
		for (Book book : books) {
			System.out.println(book);
		}

	}

	public void adduser(UserService user) {
		users.add(user);
		System.out.println("User has been added");
	}

	public void issuedtouser(String ISBN, String user) throws BookUnavailable {
		UserService user1 = searchbyname(user);
		if (user1 == null) {
			System.out.println("User not found");
		} else {
			Book book = searchbyisbn(ISBN);
			if (book.isAvailable(ISBN)) {
				user1.issuedBooks.add(book);
				book.setAvailable(false);
				System.out.println("Book with ISBN " + ISBN + " issued to user " + user1.getname());
			} else {
				throw new BookUnavailable("Book with ISBN " + ISBN + " is unavailable.");
			}

		}
	}

	public void displayAvailable() {
		int a = 0;
		for (Book book : books) {
			if (book.isAvailable(book.getIsbn())) {
				System.out.println(book);
				a++;
			}
		}
		if (a == 0) {
			System.out.println("No book avalable");
		}
	}

	public void calculateFine() {
		for (UserService user : users) {
			user.calculateFine();
		}
	}

	public void displayLibraryCards() {
		for (UserService user : users) {
			System.out.println(user.getLibraryCard());
		}
	}

	public void displayallusers() {
		for (UserService user : users) {
			System.out.println(user.getname());
		}
	}

	public UserService searchbyname(String name) {
		for (UserService user : users) {
			if (user.getname().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;

	}

}
