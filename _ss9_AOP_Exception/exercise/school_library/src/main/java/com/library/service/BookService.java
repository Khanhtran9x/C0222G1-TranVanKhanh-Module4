package com.library.service;

import com.library.model.Book;
import com.library.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository  bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageble) {
        return bookRepository.findAll(pageble);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Book book) {

    }
}
