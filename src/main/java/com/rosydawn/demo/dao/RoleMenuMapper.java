package com.rosydawn.demo.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMenuMapper {
    int deleteById(Long id);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    RoleMenu selectById(Long id);

    int updateByIdSelective(RoleMenu record);

    int updateById(RoleMenu record);

	List<RoleMenu> findRoleMenus(@Param(value = "roleId") Long roleId);
	
	List<RoleMenu> findAll();

	int deleteByRoleId(@Param(value = "roleId") Long roleId);
}