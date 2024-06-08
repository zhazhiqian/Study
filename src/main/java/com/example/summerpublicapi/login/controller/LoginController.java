package com.example.summerpublicapi.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

@RestController
@RequestMapping("/login")
public class LoginController {

    //数据源
    @Autowired
    DataSource dataSource;
    //用于访问数据库的组件
    @Autowired
    JdbcTemplate jdbcTemplate;

    /*
    汽车管理系统：

    1.配置一个常量类：存放常量的类：
    车辆出租状态：
        1.正常（未出租）
        2.待出租（交付中）
        3.已出租（已交付）
        4.待退租（车辆检查）
        5.已退租

     车辆车况状态：
        1.完好
        2.99新
        3.9成新
        4.8成新
        5.破损
        6.损坏

      车辆上架状态：
        1.上架
        2.审核
        3.下架


     */

     /* *
     *
     * @throws SQLException
     */
    @GetMapping("/test")
    public void login() throws SQLException {


            System.out.println("默认数据源为：" + dataSource.getClass());
            System.out.println("数据库连接实例：" + dataSource.getConnection());
            //访问数据库user表，查询user表的数据量
            Integer i = jdbcTemplate.queryForObject("SELECT count(*) from `user`", Integer.class);
            System.out.println("user 表中共有" + i + "条数据。");


    }


}
