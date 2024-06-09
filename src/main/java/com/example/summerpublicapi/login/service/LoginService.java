package com.example.summerpublicapi.login.service;

import com.example.summerpublicapi.common.dto.UserInfo;
import com.example.summerpublicapi.login.dao.param.LoginParam;
import com.example.summerpublicapi.login.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
bean管理
 */
@Service
public class LoginService {

    @Resource
    LoginMapper loginMapper;
    public int login(LoginParam loginParam){

        // todo 密码做加密
        return loginMapper.login(loginParam);
    }


    public UserInfo getUserInfo(LoginParam loginParam){
        return loginMapper.getUserInfo(loginParam);
    }

}
