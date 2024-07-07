package com.api.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory connectionFactory(){
        return new LettuceConnectionFactory();
    }

    // first you make a bean of redis template to use it in your project
    @Bean
    public RedisTemplate<String, Object> redisTemplate(){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        //redis template need some configuration as connection to use it
        redisTemplate.setConnectionFactory(connectionFactory());

        //key when put in this it would be put using serialization in string format
        //also deserialization in string format and also with the value
        //this serializer(stringRedisSerializer) which does string to byte and back reverse also
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        //this one generic one json to object and object to json that is what it does

        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        return redisTemplate;
    }
}
