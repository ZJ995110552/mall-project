package com.mercury.mallproject.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "redis操作接口", tags = "缓存操作接口")
@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @ApiOperation(value = "设置缓存", notes = "传入key和value设置缓存", tags = "设置缓存的key和value")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key", value = "缓存key值", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "value", value = "缓存value值", required = true, dataType = "String", paramType = "path")
    })
    @GetMapping("set/{key}/{value}")
    public String set(@PathVariable("key") String key, @PathVariable("value") String value) {
        //注意这里的 key不能为null spring 内部有检验
        redisTemplate.opsForValue().set(key, value);
        return key + "," + value;
    }

    @ApiOperation(value = "获取缓存", notes = "传入缓存的key获取对应value", tags = "获取缓存的值")
    @ApiImplicitParam(name = "key", value = "缓存key值", required = true, dataType = "String", paramType = "path")
    @GetMapping("get/{key}")
    public String get(@PathVariable("key") String key) {
        return "key=" + key + ",value=" + redisTemplate.opsForValue().get(key);
    }
}