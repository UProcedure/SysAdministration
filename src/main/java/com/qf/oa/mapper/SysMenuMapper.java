package com.qf.oa.mapper;

import com.qf.oa.dao.IBaseDao;
import com.qf.oa.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper extends IBaseDao<SysMenu> {
    List<SysMenu> getSysMenuList();

    List<Long> getSysMenuIdListByRoleId(@Param("roleId") Long roleId);

    int deleteByRoleId(Long roleId);

    int addMenuByRoleId(@Param("ids") List<Long> ids, @Param("roleId") Long roleId);
}