package com.qf.oa.service.impl;

import com.qf.oa.common.SysResult;
import com.qf.oa.dao.IBaseDao;
import com.qf.oa.entity.SysRole;
import com.qf.oa.mapper.SysRoleMapper;
import com.qf.oa.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements ISysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public IBaseDao<SysRole> getDao() {
        return sysRoleMapper;
    }

    @Override
    public List<SysRole> getRoleList() {
        return sysRoleMapper.getRoleList();
    }

    @Override
    public SysResult batchAddAuthorization(List<Long> itm, String roleId) {
        int result = sysRoleMapper.batchAddAuthorization(itm,roleId);
        SysResult sysResult = new SysResult();
        if(result!=0){
            sysResult.setResult(true);
        }else {
            sysResult.setResult(false);
        }
        return sysResult;
    }

    @Override
    public SysResult delAuthUser(Long userId, Long roleId) {
        int result = sysRoleMapper.delAuthUser(userId,roleId);
        SysResult sysResult = new SysResult();
        if(result!=0){
            sysResult.setResult(true);
        }else {
            sysResult.setResult(false);
        }
        return sysResult;
    }
}
