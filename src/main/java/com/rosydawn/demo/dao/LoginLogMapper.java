package com.rosydawn.demo.dao;

import java.util.List;

import com.rosydawn.demo.model.po.LoginLog;
import org.apache.ibatis.annotations.Param;


public interface LoginLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);
    
    List<LoginLog> findPage();
    
    List<LoginLog> findPageByUserName(@Param(value = "userName") String userName);
    
    List<LoginLog> findPageByStatus(@Param(value = "status") String status);
}