package com.rosydawn.demo.dao;

import com.rosydawn.demo.model.po.OptLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OptLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OptLog record);

    int insertSelective(OptLog record);

    OptLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OptLog record);

    int updateByPrimaryKey(OptLog record);
    
    List<OptLog> findPage();
    
    List<OptLog> findPageByUserName(@Param(value = "userName") String userName);
}