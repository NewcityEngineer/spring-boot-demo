package com.newcitysoft.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Integer status;
    private String msg;
    private Object data;

    public static Response success() {
        return Response.builder().status(200).msg("成功").build();
    }

    public static Response failure() {
        return failure("失败");
    }

    public static Response failure(String msg) {
        return Response.builder().status(100).msg(msg).build();
    }
}