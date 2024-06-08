package com.example.summerpublicapi.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/login")
public class LoginController {


    @GetMapping("/test")
    public void login() throws SQLException {

/*
            System.out.println("默认数据源为：" + dataSource.getClass());
            System.out.println("数据库连接实例：" + dataSource.getConnection());
            //访问数据库user表，查询user表的数据量
            Integer i = jdbcTemplate.queryForObject("SELECT count(*) from `user`", Integer.class);
            System.out.println("user 表中共有" + i + "条数据。");
*/

    }


}
