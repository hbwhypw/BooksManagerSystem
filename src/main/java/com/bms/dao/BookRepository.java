package com.bms.dao;

import com.bms.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;

/**
 * @author 杨彭伟
 * @date 2019-06-12 21:37
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Book b set b.bookName = ?1, b.author= ?2, b.introduction = ?3 where b.id = ?4")
    int updateById(String bookName, String author, String introduction, Integer id);
}
