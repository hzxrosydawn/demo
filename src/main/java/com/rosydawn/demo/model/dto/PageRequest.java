package com.rosydawn.demo.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: Vincent Huang
 * Created on 2019/7/10 14:24
 */
@Data
@NoArgsConstructor
public class PageRequest {
    private static final int DEFAULT_PAGE_NUM = 1;
    private static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 当前页码
     */
    private int pageNum = DEFAULT_PAGE_NUM;

    /**
     * 每页数量
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 查询参数
     */
    private Map<String, Object> params = new HashMap<>();


    public Object getParam(String key) {
        return getParams().get(key);
    }

}
