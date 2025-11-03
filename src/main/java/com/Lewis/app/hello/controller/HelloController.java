package com.Lewis.app.hello.controller;

import com.Lewis.app.hello.domain.HelloReq;
import com.Lewis.app.hello.domain.HelloRes;
import com.Lewis.app.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private HelloService service;

    @PostMapping("/hello")
    public HelloRes sayHi(@RequestBody HelloReq request){
        return service.sayHi(request);
    }

    @GetMapping("/hello")
    public HelloRes sayHi(@RequestParam String name) {
        HelloReq req = new HelloReq();
        req.setName(name);
        return service.sayHi(req);
    }

    @GetMapping("/")
    public String getStart(){
        return "Welcome to Story";
    }
}
