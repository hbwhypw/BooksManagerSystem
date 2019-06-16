package com.bms.controller;

import com.bms.domain.Book;
import com.bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("list")
    public String getList(Model model) {
        List<Book> list = bookService.getBookList();
        model.addAttribute("list", list);
        return "book/list";
    }

    @PostMapping("find")
    public String get(Model model, @ModelAttribute Book book) {
        List<Book> list = bookService.findBook(book);
        model.addAttribute("list", list);
        model.addAttribute("book", book);
        return "book/list";
    }

    @RequestMapping("/toList")
    public String toList() {
        return "redirect:/main";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Book book = bookService.getOne(id);
        model.addAttribute("book", book);
        return "book/edit";
    }

    @PostMapping("/edit")
    public String edit(Book book) {
        book.setUpdateTime(LocalDate.now());
        bookService.update(book);
        return "redirect:/main";
    }

    @GetMapping("/add")
    public String add() {
        return "book/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Book book) {
        book.setCreateTime(LocalDate.now());
        bookService.add(book);
        return "redirect:/main";
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        bookService.delete(id);
        return "redirect:/main";
    }
}
