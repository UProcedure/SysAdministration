package com.qf.oa.service;

import com.qf.oa.common.Page;
import com.qf.oa.entity.SysMenu;
import com.qf.oa.entity.SysUser;

import java.util.List;

public interface ISysUserService extends IBaseService<SysUser> {
    Page<SysUser> getUserListByCondition(Page<SysUser> page,String userName);


    Page<SysUser> getUserListByRoleId(Page<SysUser> page, Long roleId);

    Page<SysUser> getNoAuthUserByRoleId(Page<SysUser> page, Long roleId,String userName);

    SysUser getUserByUserName(String userName);

    List<SysMenu> getUserMenu(Long userId);
}
