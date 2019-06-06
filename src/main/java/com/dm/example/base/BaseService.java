package com.dm.example.base;

import com.dm.example.dto.PageDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BaseService<T> {

    PageInfo<T> pageList(PageDto pageDto);

    T selectByPrimaryKey(Long id);

    int delete(Integer id);

    int insert(T t);

    int update(T t);
}
