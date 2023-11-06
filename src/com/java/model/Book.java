package com.java.model;

public class Book {

	public String Title;
	public String Author;
	public String ISBN;
	public String Genre;
	public String Price;
	public Boolean Availability;

	public Book(String title, String author, String isbn, String genre, String price) {
		this.Title = title;
		this.Author = author;
		this.ISBN = isbn;
		this.Genre = genre;
		this.Price = price;
		this.Availability = true;
	}

	public String getprice() {
		return Price;
	}

	public String getgenre() {
		return Genre;
	}

	public String getauthor() {
		return Author;
	}

	public String gettitle() {
		return Title;
	}

	public boolean isAvailable(String isbn) {
		return Availability;
	}

	public void setAvailable(boolean Availability) {
		this.Availability = Availability;
	}

	public String getIsbn() {
		return ISBN;
	}

	public String toString() {
		return "Book{" + "title='" + Title + '\'' + ", author='" + Author + '\'' + ", isbn='" + ISBN + '\''
				+ ", genre='" + Genre + '\'' + ", available=" + Availability + ", price='" + Price + '\'' + '}';
	}

}
