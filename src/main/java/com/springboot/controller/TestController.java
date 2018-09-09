package com.springboot.controller;


import com.springboot.bean.User;
import com.springboot.config.RedisConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@SuppressWarnings("unchecked")
public class TestController {

    @Autowired
    private RedisTemplate redisCacheTemplate;


    @RequestMapping("/log")
    public String testLog(){
        log.info("#########  info  #########");
        log.debug("#########  debug  #########");
        log.error("#########  error  #########");
        return "ss";
    }

    @RequestMapping("/setString")
    public String setString(String key, String value){
        User user = new User();
        user.setName("xc");
        redisCacheTemplate.opsForValue().set("qwe", user);
        User map2 = (User) redisCacheTemplate.opsForValue().get("qwe");
        System.out.println(map2.getName());
        return "done";
    }

}
