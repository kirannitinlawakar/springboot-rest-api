package com.SpringBootRestAPI.controllers;

import com.SpringBootRestAPI.entities.Book;
import com.SpringBootRestAPI.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

//    @RequestMapping(value = "/books",method = RequestMethod.GET)
//    @ResponseBody
    @GetMapping("/books")
    public List<Book> getBooks(){
        System.out.println("Inside getBooks Methods");
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id){
        return bookService.getBookById(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        Book b = this.bookService.addBook(book);
        return b;
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable ("bookId") int bookId){
        this.bookService.deleteBook(bookId);
    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
        this.bookService.updateBook(book,bookId);
        return book;
    }
}
