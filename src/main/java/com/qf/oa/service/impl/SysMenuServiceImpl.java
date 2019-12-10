package com.qf.oa.service.impl;

import com.qf.oa.common.SysResult;
import com.qf.oa.dao.IBaseDao;
import com.qf.oa.entity.SysMenu;
import com.qf.oa.mapper.SysMenuMapper;
import com.qf.oa.service.ISysMenuService;
import com.qf.oa.vo.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu> implements ISysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public IBaseDao<SysMenu> getDao() {
        return sysMenuMapper;
    }


    @Override
    public List<SysMenuVo> getMenuListByRoleId(Long roleId) {
        List<SysMenu> sysMenuList = sysMenuMapper.getSysMenuList();
        List<Long> menuIdByRoleId = sysMenuMapper.getSysMenuIdListByRoleId(roleId);
        List<SysMenuVo> list = new ArrayList<>(sysMenuList.size());
        for (SysMenu menu : sysMenuList) {
            SysMenuVo sysMenuVo = new SysMenuVo();
            sysMenuVo.setMenuId(menu.getMenuId());
            sysMenuVo.setMenuParentId(menu.getMenuParentId());
            sysMenuVo.setMenuName(menu.getMenuName());
            if(menuIdByRoleId.contains(menu.getMenuId())){
                sysMenuVo.setChecked(true);
            }
            list.add(sysMenuVo);
        }
        return list;
    }

    @Override
    public SysResult refreshAuthMenu(List<Long> ids, Long roleId) {
        sysMenuMapper.deleteByRoleId(roleId);
        int result = sysMenuMapper.addMenuByRoleId(ids,roleId);
        SysResult sysResult = new SysResult();
        if(result>0){
            sysResult.setResult(true);
        }else {
            sysResult.setResult(false);
        }
        return sysResult;
    }
}
