package com.rosydawn.demo.dao;

import java.util.List;

import com.rosydawn.demo.model.po.Role;
import org.apache.ibatis.annotations.Param;


public interface RoleRepository {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> findPage();

    List<Role> findAll();

    List<Role> findPageByName(@Param(value = "name") String name);

    List<Role> findByName(@Param(value = "name") String name);
}