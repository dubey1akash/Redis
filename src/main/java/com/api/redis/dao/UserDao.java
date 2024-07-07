package com.api.redis.dao;

import com.api.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    //this concept is explain in one note file what it mean
    private static final String KEY = "USER";

    public User save(User usr){

        //which type of operation you want to do on your object it could be list/set
        redisTemplate.opsForHash().put(KEY,usr.getUserId(),usr);
        return usr;
    }
    public User get(String userId){
        return (User)redisTemplate.opsForHash().get(KEY,userId);

    }

}
