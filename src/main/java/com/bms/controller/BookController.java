package com.bms.controller;

import com.bms.common.Result;
import com.bms.domain.Book;
import com.bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("getList")
    public Result<List<Book>> getList() {
        return Result.success(bookService.getBookList());
    }
}
