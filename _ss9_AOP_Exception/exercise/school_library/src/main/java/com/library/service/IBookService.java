package com.library.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.library.model.Book;

import java.util.Optional;


public interface IBookService {
    Page<Book> findAll(Pageable pageble);

    void save(Book book);

    Optional<Book> findById(Integer id);

    void update(Book book);

    void remove(Book book);
}
