package com.mercury.mallproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisTestController {
 
    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("set/{key}/{value}")
    public String set(@PathVariable("key")String key, @PathVariable("value") String value) {
        //注意这里的 key不能为null spring 内部有检验
        redisTemplate.opsForValue().set(key, value);
        return key + "," + value;
    }
     
    @GetMapping("get/{key}")
    public String get(@PathVariable("key") String key) {
         
        return "key=" + key + ",value=" + redisTemplate.opsForValue().get(key);
    }
}