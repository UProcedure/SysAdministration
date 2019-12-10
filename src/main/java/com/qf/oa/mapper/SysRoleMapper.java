package com.qf.oa.mapper;

import com.qf.oa.dao.IBaseDao;
import com.qf.oa.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper extends IBaseDao<SysRole> {

    List<SysRole> getRoleList();

    int batchAddAuthorization(@Param("itm") List<Long> itm, @Param("roleId") String roleId);

    int delAuthUser(@Param("userId") Long userId, @Param("roleId") Long roleId);
}