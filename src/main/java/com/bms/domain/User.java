package com.bms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户名
     */
    @Column(nullable = false)
    private String username;
    /**
     * 密码
     */
    @Column(nullable = false)
    private String password;
    /**
     * 性别
     */
    @Column(nullable = false)
    private Integer gender;

    /**
     * 出生日期
     */
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username) {
        this.username = username;
    }
}
