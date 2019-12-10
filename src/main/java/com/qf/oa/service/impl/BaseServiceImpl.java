package com.qf.oa.service.impl;

import com.qf.oa.dao.IBaseDao;
import com.qf.oa.service.IBaseService;

public abstract class BaseServiceImpl<T> implements IBaseService<T> {
    public abstract  IBaseDao<T> getDao();

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(T t) {
        return 0;
    }

    @Override
    public int insertSelective(T t) {
        return 0;
    }

    @Override
    public T selectByPrimaryKey(Long id) {
        return getDao().selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return 0;
    }
}
