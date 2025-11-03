package com.Lewis.app.hello.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {

    public String getRes(String name){
        return "Hi "+name+" good day";
    }
}
