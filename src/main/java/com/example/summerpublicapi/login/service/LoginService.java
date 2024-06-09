package com.example.summerpublicapi.login.service;

import com.example.summerpublicapi.login.dao.param.LoginParam;
import com.example.summerpublicapi.login.mapper.LoginMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
bean管理
 */
@Service
public class LoginService {
    @Resource
    private LoginMapper loginMapper;

    public int login(LoginParam loginParam){
        // todo 密码做加密
        return loginMapper.login(loginParam);
    }

}
