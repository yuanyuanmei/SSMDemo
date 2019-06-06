package com.dm.example.base;

import com.dm.example.dto.PageDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    @Override
    public T selectByPrimaryKey(Long id){
        return baseDao.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<T> pageList(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(),pageDto.getPageSize());
        List<T> list = baseDao.list();
        return new PageInfo<>(list);
    }

    @Transactional
    @Override
    public int delete(Integer id){
        return baseDao.delete(id);
    }

    @Transactional
    @Override
    public int insert(T t){
        return baseDao.insert(t);
    }

    @Transactional
    @Override
    public int update(T t){
        return baseDao.update(t);
    }

}
