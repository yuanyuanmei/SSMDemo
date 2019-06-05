package com.dm.example.base;

import com.dm.example.dto.PageDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    private BaseDao<T> baseDao;

    @Override
    public PageInfo<T> pageList(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(),pageDto.getPageSize());
        List<T> list = baseDao.list();
        return new PageInfo<>(list);
    }
}
