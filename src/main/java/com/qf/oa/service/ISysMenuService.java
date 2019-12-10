package com.qf.oa.service;

import com.qf.oa.common.SysResult;
import com.qf.oa.entity.SysMenu;
import com.qf.oa.vo.SysMenuVo;

import java.util.List;

public interface ISysMenuService extends IBaseService<SysMenu>{
    List<SysMenuVo> getMenuListByRoleId(Long roleId);

    SysResult refreshAuthMenu(List<Long> ids, Long roleId);
}
