package com.example.summerpublicapi.login.controller;

import com.example.summerpublicapi.login.dao.param.LoginParam;
import com.example.summerpublicapi.login.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/loginMathod")
public class LoginController {

    @Resource
    LoginService loginService;
     /* *
     * 判断你当前登录用户是否存在于数据库
     * @throws SQLException
     */
    @PostMapping("/login")
    public String login(@RequestBody LoginParam loginParam) throws Exception {
        // 需要校验数据是否有传
        if(loginParam == null ){
            throw new Exception("请求参数不允许为空");
        }
        if(loginParam.getLoginName() == null || loginParam.getLoginName() == ""){
            throw new Exception("请输入登录名");
        }
        if(loginParam.getPassword() == null || loginParam.getPassword() == ""){
            throw new Exception("请输入密码");
        }
        int count = loginService.login(loginParam);
        if(count > 0){
            // 当前用户存在
            return "登陆成功";
        }
        else{
            // 当前用户不存在
            throw new Exception("请检查用户名或密码！");
            // todo 当前用户登录超过最大登录次数，锁定账户
        }



    }


}
