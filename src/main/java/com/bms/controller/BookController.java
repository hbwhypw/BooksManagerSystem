package com.bms.controller;

import com.bms.common.Result;
import com.bms.domain.Book;
import com.bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("list")
    public Result<List<Book>> getList() {
        return Result.success(bookService.getBookList());
    }

    @GetMapping("edit")
    public String edit() {
        return "book/edit";
    }
    @PostMapping("edit")
    public String edit(Book book) {
        bookService.update(book);
        return "redirect:/main";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        bookService.delete(id);
        return "redirect:/main";
    }
}
