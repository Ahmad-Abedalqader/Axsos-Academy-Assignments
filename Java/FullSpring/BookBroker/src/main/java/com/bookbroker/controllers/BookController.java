package com.bookbroker.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookbroker.models.Book;
import com.bookbroker.models.User;
import com.bookbroker.services.BookService;
import com.bookbroker.services.UserService;

@Controller
public class BookController {
    
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;
    
	// home, all books (shelves)
    @GetMapping ("/books")
    public String home(Model model, HttpSession session){
    	if (session.getAttribute("userId")!= null){
    		Long userId = (Long) session.getAttribute("userId");
    		User currentUser = userService.findUserById(userId);
    		model.addAttribute("currentUser", currentUser);
    		
        	List<Book> allBooks = bookService.allBooks();
        	model.addAttribute("allBooks", allBooks);
    		return "Home.jsp";
    	}
    	return "redirect:/";
    	  		
    }
	
	// Book Market
    @GetMapping ("/bookmarket")
    public String bookMarket(Model model, HttpSession session){
    	if (session.getAttribute("userId")!= null){
    		Long userId = (Long) session.getAttribute("userId");
    		User currentUser = userService.findUserById(userId);
    		model.addAttribute("currentUser", currentUser);
    		
        	List<Book> allBooks = bookService.allBooks();
        	ArrayList<Book> unBorrowedBooks = new ArrayList<Book>();
        	for (Book book: allBooks) {
        		if (book.getBorrower() == null) {
        			unBorrowedBooks.add(book);
        		}
        	}
        	
        	model.addAttribute("unBorrowedBooks", unBorrowedBooks);
    		return "BookMarket.jsp";
    	}
    	return "redirect:/";
    	  		
    }
  
    // Book Details
    @RequestMapping("/books/{id}")
    public String showBook(Model model, @PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User currentUser = userService.findUserById(userId);
		model.addAttribute("currentUser", currentUser);
		
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "BookDetails.jsp";
    }
    
    //Adding book to the shelf
    // adding new book "Get Method"
    @GetMapping("/books/new")
    public String index( @ModelAttribute("book") Book book) {
    	
        return "AddBook.jsp";
    }
    // adding new book "Post Method"
    @PostMapping("/books/new")
    public String addSong(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "AddBook.jsp";
        } else {
        	Long id = (Long) session.getAttribute("userId");
        	User user = userService.findUserById(id);
        	bookService.createBook(book, user);
        	return "redirect:/books";
        }
    }
    
    //Edit Get Method:
    @GetMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "Edit.jsp";
    }
    
    //Edit Put Method:
    @PutMapping("/books/{id}")
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result,
    					@PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "Edit.jsp";
        } else {
            bookService.updateBook(book, id);
            return "redirect:/books";
        }
    }
    
    //Borrow a book:
    @GetMapping("/books/{id}/borrow")
    public String borrow(@PathVariable("id") Long id, HttpSession session) {
    	
    	Long borrowerId = (Long) session.getAttribute("userId");
    	User borrower = userService.findUserById(borrowerId);
    	
    	Book book = bookService.findBook(id);
    	
    	bookService.borrowBook(book, borrower);
        return "redirect:/bookmarket";
    }
    
    //Return the book you have borrowed:
    @GetMapping("/books/{id}/return")
    public String returnBook(@PathVariable("id") Long id) {
    	Book book = bookService.findBook(id);
    	bookService.returnBook(book);
        return "redirect:/bookmarket";
    }
    
    //Delete a book:
    @DeleteMapping("/books/{id}")
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    
}
