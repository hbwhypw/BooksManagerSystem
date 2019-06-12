package com.bms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author ypw
 * @date 2019-06-12
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 书名
     */
    @Column(nullable = false)
    private String bookName;
    /**
         * 作者
     */
    @Column(nullable = false)
    private String author;
    /**
     * 简介
     */
    @Column(nullable = false)
    private String introduction;
    /**
     * 创建时间
     */
    @Column(nullable = false)
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTime;

    /**
     * 创建时间
     */
    @Column(nullable = true)
    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateTime;

}
