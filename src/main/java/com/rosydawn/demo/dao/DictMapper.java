package com.rosydawn.demo.dao;

import java.util.List;

import com.rosydawn.demo.model.po.Dict;
import org.apache.ibatis.annotations.Param;

public interface DictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dict record);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);
    
    List<Dict> findPage();
    
    List<Dict> findPageByLabel(@Param(value = "label") String label);

    List<Dict> findByLable(@Param(value = "label") String label);
}