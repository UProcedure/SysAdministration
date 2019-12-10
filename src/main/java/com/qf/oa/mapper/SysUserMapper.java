package com.qf.oa.mapper;

import com.qf.oa.dao.IBaseDao;
import com.qf.oa.entity.SysMenu;
import com.qf.oa.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper extends IBaseDao<SysUser> {

    List<SysUser> getUserListByCondition(String userName);

    List<SysUser> getUserListByRoleId(Long roleId);

    List<SysUser> getNoAuthUserByRoleId(@Param("roleId") Long roleId, @Param("userName") String userName);

    SysUser getUserByUserName(String userName);

    List<SysMenu> getUserMenu(Long userId);
}