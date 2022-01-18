package com.api.book.bootrestapibook.controller;

import java.util.List;
import java.util.Optional;

import com.api.book.bootrestapibook.entities.Book;
import com.api.book.bootrestapibook.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    // @RequestMapping(value = "/books", method = RequestMethod.GET)

    @Autowired
    private BookService bookservice;

    // get sbook
    // @GetMapping("/books")
    // public List<Book> getBook() {
    // return this.bookservice.getAllBooks();
    // }

    // // get single book
    // @GetMapping("/books/{id}")
    // public Book getBookbyId(@PathVariable("id") int id) {
    // return this.bookservice.getBookById(id);
    // }

    // // new book
    // @PostMapping("/books")
    // public Book addBook(@RequestBody Book book) {

    // Book b = this.bookservice.addBook(book);
    // return b;
    // }
    // // delete book
    // @DeleteMapping("/books/{bookId}")
    // public void deleteBook(@PathVariable("bookId") int bookId) {
    // this.bookservice.deleteBook(bookId);
    // }

    // get book
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBook() {
        List<Book> list = bookservice.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookbyId(@PathVariable("id") int id) {
        Book book = bookservice.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of((Optional.of(book)));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book b = null;
        try {
            b = this.bookservice.addBook(book);
            System.out.println(book);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // update book
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
        try {
            this.bookservice.updateBook(book, bookId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(book);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // delete book
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
        try {
            this.bookservice.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            // return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
