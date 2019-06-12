package com.bms.dao;

import com.bms.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 杨彭伟
 * @date 2019-06-12 21:37
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
}
