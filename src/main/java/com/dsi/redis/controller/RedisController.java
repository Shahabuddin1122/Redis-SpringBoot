package com.dsi.redis.controller;


import com.dsi.redis.service.ObjectMapping;
import com.dsi.redis.service.Person;
import com.dsi.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    public RedisService redisService;

    @Autowired
    public ObjectMapping objectMapping;

    @GetMapping
    public void Check(){
        redisService.get();
    }

    @PostMapping("/json")
    public void post(@RequestBody Person person){
        objectMapping.writeHash("userObject",person);
    }

    @GetMapping("/json")
    public Person get(){
        return objectMapping.loadHash("userObject");
    }

}
