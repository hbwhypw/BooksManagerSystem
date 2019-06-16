package com.bms.service;

import com.bms.dao.BookRepository;
import com.bms.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.StringMatcher.CONTAINING;

/**
 * @author ypw
 */
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    public List<Book> findBook(Book book) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(CONTAINING)
                .withIgnoreNullValues();
        Example<Book> example = Example.of(book, matcher);
        return bookRepository.findAll(example);
    }

    public void add(Book book) {
        bookRepository.save(book);
    }

    public void update(Book book) {
        bookRepository.save(book);
    }

    public Book getOne(Integer id) {
        return bookRepository.getOne(id);
    }

    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}
