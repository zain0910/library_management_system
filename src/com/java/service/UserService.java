package com.java.service;

import java.util.ArrayList;
import java.util.List;

import com.java.Library;
//import com.java.Userservice;
import com.java.exception.BookNotFound;
import com.java.model.Book;

public class UserService {
	Library library = new Library();


	public String name;
	public List<Book> issuedBooks = new ArrayList<Book>();

	public UserService(String name) {
		this.name = name;
	}

	public String getname() {
		return name;
	}

	public void issueBook(Book book) {
		issuedBooks.add(book);
	}

	public void calculateFine() {
		for (Book book : issuedBooks) {
			double fine = 0.02 * Double.parseDouble(book.getprice());
			if (fine > 0) {
				System.out.println(name + " owes " + fine + " for book with ISBN " + book.getIsbn());
			}
		}
	}

	public String getLibraryCard() {
		String libraryCard = "Library Card for " + name + ":\n";
		for (Book book : issuedBooks) {
			libraryCard += book.toString() + "\n";
		}
		return libraryCard;
	}

	public void showIssuedBooks() {
		for (Book book : issuedBooks) {
			System.out.println(book);
		}
	}
}
