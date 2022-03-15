package com.codingdojo.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookController {
    
	@Autowired
	BookService bookService;
    
    @RequestMapping("/books")
    public String index(Model model) {
    	List<Book> allBooks = bookService.allBooks();
    	model.addAttribute("allBooks", allBooks);
        return "Books.jsp";
    }
    
//    @RequestMapping(value="/api/books", method=RequestMethod.POST)
//    public Book create( @RequestParam(value="title") String title,
//			    		@RequestParam(value="description") String desc,
//			    		@RequestParam(value="language") String lang,
//			    		@RequestParam(value="pages") Integer numOfPages ) {
//        Book book = new Book(title, desc, lang, numOfPages);
//        return bookService.createBook(book);
//    }
    
    @RequestMapping("/books/{id}")
    public String showBook(Model model, @PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        model.addAttribute("title", book.getTitle());
        model.addAttribute("desc", book.getDescription());
        model.addAttribute("lang", book.getLanguage());
        model.addAttribute("pages", book.getNumberOfPages());
        return "BookDetails.jsp";
    }
    
//    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
//    public Book update( @PathVariable("id") Long id,
//						@RequestParam(value="title") String title,
//						@RequestParam(value="description") String desc,
//						@RequestParam(value="language") String lang,
//						@RequestParam(value="pages") Integer numOfPages ) {
//        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
//        return book;
//    }
    
//    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
//    public void destroy(@PathVariable("id") Long id) {
//        bookService.deleteBook(id);
//    }
}
