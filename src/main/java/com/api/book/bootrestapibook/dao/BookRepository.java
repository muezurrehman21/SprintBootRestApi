package com.api.book.bootrestapibook.dao;

import com.api.book.bootrestapibook.entities.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findById(int id);
}
