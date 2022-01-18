package com.api.book.bootrestapibook.services;

import java.util.List;

import com.api.book.bootrestapibook.dao.BookRepository;
import com.api.book.bootrestapibook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    // private static List<Book> list = new ArrayList<>();
    // static {
    // list.add(new Book(12, "java", "muez"));
    // list.add(new Book(13, "python", "mueez"));
    // list.add(new Book(14, "javascript", "muez"));
    // }
    @Autowired
    private BookRepository bookRepository;

    // 1 get all books
    // public List<Book> getAllBooks() {
    // return list;
    // }
    // 3get all books
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // //1 get single book
    // public Book getBookById(int id) {
    // Book book = null;
    // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
    // return book;

    // }
    // 2get single book
    // public Book getBookById(int id) {
    // Book book = null;
    // try {
    // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // return book;
    // }
    // 3get single book
    public Book getBookById(int id) {
        Book book = null;
        try {
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // 1add book
    // public Book addBook(Book b) {
    // list.add(b);
    // return b;
    // }
    // 2add book
    public Book addBook(Book b) {
        Book result = bookRepository.save(b);
        return result;
    }

    // fileter function pori book ko list ko id sy k sath read krta hy
    // 1delete book
    // public void deleteBook(int bid) {

    // list = list.stream().filter(book -> book.getId() !=
    // bid).collect(Collectors.toList());
    // }
    // 3delete book
    public void deleteBook(int bid) {

        bookRepository.deleteById(bid);
    }

    // map function hr aik k pass jaye ga oor check kry ga
    // 1update book
    // public void updateBook(Book book, int bookId) {
    // list = list.stream().map(b -> {
    // if (b.getId() == bookId) {
    // b.setTitle(book.getTitle());
    // b.setAuthor(book.getAuthor());
    // }
    // return b;
    // }).collect(Collectors.toList());

    // }
    public void updateBook(Book book, int bookId) {
        book.setId(bookId);
        bookRepository.save(book);
    }
}
