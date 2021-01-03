package com.imooc.controller;

import com.imooc.utils.RedisOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@Controller
@ApiIgnore
@RestController
@RequestMapping("redis")
public class RedisController {
    // 注入redis模板类
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisOperator redisOperator;

    final static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @GetMapping("/set")
    public String set(String key, String value) {
//        redisTemplate.opsForValue().set(key, value);
        redisOperator.set(key, value);
        return "OK";

    }

    @GetMapping("/get")
    public String get(String key) {

//        return (String) redisTemplate.opsForValue().get(key);
        return redisOperator.get(key);
    }

    @GetMapping("/delete")
    public Object delete(String key) {
        //redisTemplate.delete(key);
        redisOperator.del(key);
        return "OK";
    }



}
