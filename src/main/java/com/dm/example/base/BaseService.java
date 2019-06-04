package com.dm.example.base;

import com.dm.example.dto.PageDto;
import com.github.pagehelper.PageInfo;

public interface BaseService<T> {

    PageInfo<T> pageList(PageDto pageDto);

}
