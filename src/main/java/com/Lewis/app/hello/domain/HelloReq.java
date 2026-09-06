package com.Lewis.app.hello.domain;

import io.swagger.annotations.ApiModelProperty;

public class HelloReq {

    @ApiModelProperty("測試名稱")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
