package com.Lewis.app.hello.service;

import com.Lewis.app.hello.domain.HelloReq;
import com.Lewis.app.hello.domain.HelloRes;
import com.Lewis.app.hello.repository.HelloRepository;
import com.Lewis.app.hello.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloRepository repos;

    @Autowired
    private StudentRepository stRepos;

    @Autowired
    private ObjectMapper objectMapper;

    public HelloRes sayHi(HelloReq rq){
        HelloRes rs = new HelloRes();
        rs.setResult(repos.getRes(rq.getName()));
        return rs;
    }

    public HelloRes getStudent() {
        HelloRes rs = new HelloRes();
        rs.setResult(stRepos.findAllStudent());
//        rs.setResult(stRepos.findAll());

        return rs;
    }
}
