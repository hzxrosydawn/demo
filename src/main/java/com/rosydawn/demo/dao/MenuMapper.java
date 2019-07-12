package com.rosydawn.demo.dao;

import java.util.List;

import com.rosydawn.demo.model.po.Menu;
import org.apache.ibatis.annotations.Param;


public interface MenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    
	List<Menu> findPage();

	List<Menu> findPageByName(@Param(value = "name") String name);
	
	List<Menu> findAll();

	List<Menu> findByUserName(@Param(value = "userName") String userName);

	List<Menu> findRoleMenus(@Param(value = "roleId") Long roleId);
}