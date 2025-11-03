package com.Lewis.app.hello.service;

import com.Lewis.app.hello.domain.HelloReq;
import com.Lewis.app.hello.domain.HelloRes;
import com.Lewis.app.hello.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloRepository repos;

    public HelloRes sayHi(HelloReq rq){
        HelloRes rs = new HelloRes();
        rs.setResult(repos.getRes(rq.getName()));
        return rs;
    }
}
