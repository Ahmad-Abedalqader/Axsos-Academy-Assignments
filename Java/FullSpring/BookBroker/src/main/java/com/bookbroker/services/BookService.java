package com.bookbroker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookbroker.models.Book;
import com.bookbroker.models.User;
import com.bookbroker.repositories.BookRepo;

@Service
public class BookService {
	
	 // adding the book repository as a dependency
		private final BookRepo bookRepo;
	 
	 public BookService(BookRepo bookRepo) {
	     this.bookRepo = bookRepo;
	 }
	 
	 // returns all the books
	 public List<Book> allBooks() {
	     return bookRepo.findAll();
	 }
	 
	 // creates a book
	 public Book createBook(Book b, User user) {
		 b.setPostedBy(user);
		 b.setBorrower(null);
	     return bookRepo.save(b);
	 }
	 
	 // retrieves a book
	 public Book findBook(Long id) {
	     Optional<Book> optionalBook = bookRepo.findById(id);
	     if(optionalBook.isPresent()) {
	         return optionalBook.get();
	     } else {
	         return null;
	     }
	 }
	 //Update
	 public void updateBook(Book newBook, Long bookId) {
	     Optional<Book> optionalBook = bookRepo.findById(bookId);
	     if(optionalBook.isPresent()) {
	         Book book = optionalBook.get();
	         book.setTitle(newBook.getTitle());
	         book.setAuthor(newBook.getAuthor());
	         book.setThoughts(newBook.getThoughts());
	         bookRepo.save(book);
	     }
		
	 }
	 //Borrow book
	 public Book borrowBook(Book book, User user) {
		book.setBorrower(user);
		return bookRepo.save(book);
	 }
	 //Return the book you have borrowed
	 public Book returnBook(Book book) {
		 book.setBorrower(null);
		return bookRepo.save(book);
	 }
	 //Delete
	 public void deleteBook(Long id) {
		bookRepo.deleteById(id);
		
	}
}

