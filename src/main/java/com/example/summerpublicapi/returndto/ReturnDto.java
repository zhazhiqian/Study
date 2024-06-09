package com.example.summerpublicapi.returndto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ReturnDto {

    private static final long serialVersionUID = 7498483649536881777L;

    private String status;

    private String msg;

    private Object data;

    public ReturnDto() {
    }

    public ReturnDto(String status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == "200";
    }

    public static ReturnDto success(String msg, Object data) {
        return new ReturnDto("200", msg, data);
    }


    public static ReturnDto error(String code, String msg, Object data) {
        return new ReturnDto(code, msg, data);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
