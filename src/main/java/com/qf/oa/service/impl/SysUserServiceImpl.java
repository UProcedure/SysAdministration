package com.qf.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.qf.oa.common.Page;
import com.qf.oa.dao.IBaseDao;
import com.qf.oa.entity.SysMenu;
import com.qf.oa.entity.SysUser;
import com.qf.oa.mapper.SysUserMapper;
import com.qf.oa.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements ISysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public IBaseDao<SysUser> getDao() {
        return sysUserMapper;
    }

    @Override
    public Page<SysUser> getUserListByCondition(Page<SysUser> page,String userName) {
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysUser> list = sysUserMapper.getUserListByCondition(userName);
        return new Page<>(list);
    }

    @Override
    public Page<SysUser> getUserListByRoleId(Page<SysUser> page, Long roleId) {
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysUser> list = sysUserMapper.getUserListByRoleId(roleId);
        return new Page<>(list);
    }

    @Override
    public Page<SysUser> getNoAuthUserByRoleId(Page<SysUser> page, Long roleId,String userName) {
        PageHelper.startPage(page.getCurrentPage(),page.getPageSize());
        List<SysUser> list = sysUserMapper.getNoAuthUserByRoleId(roleId,userName);
        return new Page<>(list);
    }

    @Override
    public SysUser getUserByUserName(String userName) {
        return sysUserMapper.getUserByUserName(userName);

    }

    @Override
    public List<SysMenu> getUserMenu(Long userId) {
        return sysUserMapper.getUserMenu(userId);
    }


}
