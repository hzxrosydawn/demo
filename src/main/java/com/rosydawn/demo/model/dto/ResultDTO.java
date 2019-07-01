package com.rosydawn.demo.model.dto;

import lombok.Data;

/**
 * Created by IntelliJ IDEA
 *
 * @auther: Vincent Huang
 * Date: 2019/7/1
 * Time: 16:20
 */
@Data
public class ResultDTO<T> {
    private T data;
    private String code;
    private String msg;
}
