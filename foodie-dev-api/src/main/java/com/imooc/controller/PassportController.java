package com.imooc.controller;

import com.imooc.pojo.Stu;
import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.StuService;
import com.imooc.service.UserService;
import com.imooc.utils.CookieUtils;
import com.imooc.utils.JSONResult;
import com.imooc.utils.JsonUtils;
import com.imooc.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("passport")
@Api(value = "注册登录", tags = {"用于注册登录的相关接口"})
public class PassportController {

    @Autowired
    UserService userService;

    @GetMapping("/usernameIsExist")
    // 该注解代表的是请求类型的参数，而不是路径参数
    @ApiOperation(value = "用户存在", notes = "用户存在", httpMethod = "GET")
    public JSONResult usernameIsExist(@RequestParam String username){
        // 1. 判断用户名不能为空
        if (StringUtils.isBlank(username)){
            return JSONResult.errorMsg("用户名不能为空");
        }
        // 2. 查找注册的用户名是否存在
        boolean b = userService.queryUserIsExist(username);
        if (b) return JSONResult.errorMsg("用户名已经存在");

        // 3. 请求成功，用户名合法
        return JSONResult.ok();

    }

    // 注册
    @PostMapping("/regist")
    @ApiOperation(value = "用户注册", notes = "用户注册", httpMethod = "POST")
    public JSONResult regist(@RequestBody UserBO userBO,
                             HttpServletRequest request,
                             HttpServletResponse response){
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        // 0. 判断用户名和密码不为空
        if (StringUtils.isBlank(username) ||
            StringUtils.isBlank(password)||
            StringUtils.isBlank(confirmPwd)
        ){
            return JSONResult.errorMsg("用户名或密码不能为空");
        }

        // 1. 查询用户名是否存在
        boolean b = userService.queryUserIsExist(username);
        if (b) return JSONResult.errorMsg("用户名已经存在");
        // 2. 密码长度不能少于6位
        if (password.length() < 6){
            return JSONResult.errorMsg("密码长度不能少于6");
        }

        // 3. 判断两次密码是否一致
        if (!password.equalsIgnoreCase(confirmPwd)){
            return JSONResult.errorMsg("两次密码不一致");
        }

        // 4. 实现注册
        Users userResult = userService.createUser(userBO);

        // 去除敏感信息
        userResult = setNullProperty(userResult);

        // 在服务端将脱敏后的信息发到cookie中去
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(userResult), true);


        return JSONResult.ok();

    }

    // 登录
    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    public JSONResult login(@RequestBody UserBO userBO,
                            HttpServletRequest request,
                            HttpServletResponse response
                            ) throws Exception {
//        String username = userBO.getUsername();
//        String password = userBO.getPassword();
//
//        // 0. 判断用户名和密码不为空
//        if (StringUtils.isBlank(username) ||
//                StringUtils.isBlank(password)
//        ){
//            return JSONResult.errorMsg("用户名或密码不能为空");
//        }
//        // 2. 密码长度不能少于6位
//        if (password.length() < 6){
//            return JSONResult.errorMsg("密码长度不能少于6");
//        }
//        // 4. 实现注册
//        Users userResult = null;
//        try {
//            // System.out.println(MD5Utils.getMD5Str(password));
//            userResult = userService.queryUserForLogin(username, MD5Utils.getMD5Str(password));
//
//            System.out.println(userResult);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // 5. 查询结果判空
//        if (userResult == null){
//            return JSONResult.errorMsg("用户名或密码不正确");
//        }
//
//        return JSONResult.ok(userResult);
//
        String username = userBO.getUsername();
        String password = userBO.getPassword();


        // 0. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password)) {
            return JSONResult.errorMsg("用户名或密码不能为空");
        }

        // 1. 实现登录
        Users userResult = userService.queryUserForLogin(username,
                MD5Utils.getMD5Str(password));

        if (userResult == null) {
            return JSONResult.errorMsg("用户名或密码不正确");
        }

        // 去除敏感信息
        userResult = setNullProperty(userResult);

        // 在服务端将脱敏后的信息发到cookie中去
        CookieUtils.setCookie(request, response, "user", JsonUtils.objectToJson(userResult), true);


        // TODO 生成用户token, 存入redis会话
        // TODO 同步购物车数据
        return JSONResult.ok(userResult);



    }

    private Users setNullProperty(Users userResult){
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }

    // 注销 /logout
    @PostMapping("/logout")
    @ApiOperation(value = "用户注销", notes = "用户注销", httpMethod = "POST")
    public JSONResult logout(@RequestParam String userId,
                             HttpServletRequest request,
                             HttpServletResponse response){
        // 清除用户相关的cookie
        CookieUtils.deleteCookie(request, response, "user");
        // TODO 用户退出登录，需要清空购物车
        // TODO 分布式会话中需要清除用户数据
        return JSONResult.ok();

    }




}
