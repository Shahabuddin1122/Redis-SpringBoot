package com.dsi.redis.service;


import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Component
public class ObjectMapping {

    @Resource(name = "redisTemplate")
    HashOperations<String, byte[], byte[]> hashOperations;

    HashMapper<Object, byte[], byte[]> mapper = new ObjectHashMapper();


    //single json object

    public void writeHash(String key, Person person) {

        Map<byte[], byte[]> mappedHash = mapper.toHash(person);
        hashOperations.putAll(key, mappedHash);
    }

    public Person loadHash(String key) {

        Map<byte[], byte[]> loadedHash = hashOperations.entries(key);
        return (Person) mapper.fromHash(loadedHash);
    }








}