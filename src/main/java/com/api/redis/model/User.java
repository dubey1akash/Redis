package com.api.redis.model;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//this is implemented serializable because the data you are going to save it should be serializable
//so the object should be serialized
public class User implements Serializable {
    private String userId;
    private String name;
    private String phone;
    private String email;



}
