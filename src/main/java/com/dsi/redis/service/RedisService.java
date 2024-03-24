package com.dsi.redis.service;

import com.dsi.redis.RedisApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    private static final Log LOG = LogFactory.getLog(RedisApplication.class);

////    @Autowired
////    public RedisTemplate<String,String> redisTemplate;
//
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
//
//    @Cacheable("myCache")
//    public String getData(){
//        String data =  redisTemplate.opsForValue().get("name");
//        return data;
////        return redisTemplate.opsForList().range("message",0,-1);
////        return redisTemplate.opsForZSet().getOperations();
////        return "hello from redis";
//    }

    public void get(){
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory();
        connectionFactory.afterPropertiesSet();

        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultSerializer(StringRedisSerializer.UTF_8);
        template.afterPropertiesSet();

        template.opsForValue().set("foo", "hello everyone");
        template.expire("foo",100, TimeUnit.SECONDS);

        LOG.info("Value at foo:" + template.opsForValue().get("foo"));

        connectionFactory.destroy();
    }


}
