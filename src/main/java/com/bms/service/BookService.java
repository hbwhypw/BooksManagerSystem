package com.bms.service;

import com.bms.dao.BookRepository;
import com.bms.domain.Book;
import com.bms.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
