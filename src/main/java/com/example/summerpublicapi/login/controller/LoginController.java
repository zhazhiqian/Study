package com.example.summerpublicapi.login.controller;

import com.example.summerpublicapi.common.RedisKey;
import com.example.summerpublicapi.common.dto.UserInfo;
import com.example.summerpublicapi.login.dao.param.LoginParam;
import com.example.summerpublicapi.login.service.LoginService;
import com.example.summerpublicapi.returndto.ReturnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.redis.core.RedisTemplate;
import javax.annotation.Resource;

@RestController
@RequestMapping("/loginMathod")
public class LoginController {

    @Resource
    LoginService loginService;

    @Autowired
    RedisTemplate<String, String> redisTemplate;
     /* *
     * 判断你当前登录用户是否存在于数据库
     * @throws SQLException
     */
    @PostMapping("/login")
    public ReturnDto login(@RequestBody LoginParam loginParam) throws Exception {
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
            // todo 正常一个功能需要将当前用户信息存储到redis，因为后续判断权限需要用当前用户信息
            // redis无则插入返回false，有则返回true （redisTemplate需要好好学习使用）
            UserInfo userInfo = loginService.getUserInfo(loginParam);
            // 将当前用户信息存储
            redisTemplate.opsForHash().putIfAbsent(RedisKey.loginUserInfo,loginParam.getLoginName(),userInfo);
            return ReturnDto.success("请求成功","登陆成功");
        }
        else{
            // todo 当前用户登录超过最大登录次数，锁定账户，通过redis判断，正常需要判断电脑ip，我们现在不做这些

            throw new Exception("请检查用户名或密码！");

        }



    }


}
