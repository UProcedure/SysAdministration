package com.qf.oa.service;

import com.qf.oa.common.Page;
import com.qf.oa.common.SysResult;
import com.qf.oa.entity.SysRole;
import com.qf.oa.entity.SysUser;

import java.util.List;

public interface ISysRoleService extends IBaseService<SysRole> {
    List<SysRole> getRoleList();

    SysResult batchAddAuthorization(List<Long> itm, String roleId);

    SysResult delAuthUser(Long userId, Long roleId);
}
