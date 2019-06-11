package com.bms.service;

import com.bms.domain.Book;
import com.bms.utils.FileUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public List<Book> getBookList() {
        List<Book> list = new ArrayList<>();
        String path = getClass().getResource("/").getPath() + "user.txt";

        List<String> strings = FileUtil.readFileList(path, 0);
        for (String content : strings) {
            String[] split = content.split(",");
            if (split.length == 4) {
                list.add(new Book(split[0], split[1], split[2], split[3]));
            }
        }
        return list;
    }

    public void add(Book book) {
        String path = getClass().getResource("/").getPath() + "user.txt";
        //  TODO 行号
        String lineNumber = FileUtil.readFile(path, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.parseInt(lineNumber)).append(",")
                .append(book.getBookName()).append(",")
                .append(book.getAuthor()).append(",")
                .append(book.getIntroduction()).append(",")
                .append(book.getCreateTime());
        FileUtil.writeAppendFile(path, sb.toString());

    }

    public void update(Book book) {
        String path = getClass().getResource("/").getPath() + "user.txt";
        //  TODO 行号
        String lineNumber = FileUtil.readFile(path, 0);


    }

    public void delete(Integer id) {
        String path = getClass().getResource("/").getPath() + "user.txt";


    }
}
