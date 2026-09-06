package com.Lewis.app.hello.domain;

import io.swagger.annotations.ApiModelProperty;

public class HelloRes {

    @ApiModelProperty(value = "回傳結果")
    private Object result;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
