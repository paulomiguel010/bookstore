package com.example.bookstore.Controller;

import com.example.bookstore.data.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class BookController {

 private final BookService bookService;

 @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> bookList(){
        return bookService.findAll();
    }


    @GetMapping("/books/{bookId}")
    public Optional<Book> getBook(@PathVariable int bookId){
        Optional<Book> book= bookService.findById(bookId);
        if(book.isEmpty()){
            throw new RuntimeException("Book not found");
        }
        return book;
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook){
         theBook.setId(0);
         bookService.save(theBook);
         return theBook;
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book theBook) {
     bookService.save(theBook);
     return theBook;

    }

    @DeleteMapping("/books/{bookId}")
    public String deleteCustomer(@PathVariable int bookId) {

         Optional<Book> book = bookService.findById(bookId);
         if(book.isEmpty()){
             throw new RuntimeException("book does not exist");
         }
         bookService.deleteById(bookId);
        return "Deleted book id - " + bookId;
    }



}
