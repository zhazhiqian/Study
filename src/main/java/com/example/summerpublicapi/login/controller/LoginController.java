package com.example.summerpublicapi.login.controller;

import com.example.summerpublicapi.login.dao.param.LoginParam;
import com.example.summerpublicapi.login.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loginMathod")
public class LoginController {

    @Resource
    private LoginService loginService;
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
