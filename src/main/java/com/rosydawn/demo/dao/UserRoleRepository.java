package com.rosydawn.demo.dao;

import java.util.List;

import com.rosydawn.demo.model.po.Role;
import org.apache.ibatis.annotations.Param;

public interface UserRoleRepository {
    int deleteById(Long id);

    int insert(Role role);

    int insertSelective(Role role);

    Role selectById(Long id);

    int updateByIdSelective(Role role);

    int updateById(Role role);

	List<Role> selectUserRolesByUserId(@Param(value = "userId") Long userId);

    /**
     * 删除角色菜单表中的关联记录，而不是角色表的角色记录
     */
	int deleteByUserId(@Param(value = "userId") Long userId);
}