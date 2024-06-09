package com.example.summerpublicapi.login.mapper;

import com.example.summerpublicapi.login.dao.param.LoginParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {


    public int login(@Param("login") LoginParam loginParam);


}
