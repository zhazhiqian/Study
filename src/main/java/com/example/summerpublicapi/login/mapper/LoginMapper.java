package com.example.summerpublicapi.login.mapper;

import com.example.summerpublicapi.login.dao.param.LoginParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginMapper {

        public int login(@Param("login") LoginParam param);


}
