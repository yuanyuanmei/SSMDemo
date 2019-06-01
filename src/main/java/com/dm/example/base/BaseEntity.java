package com.dm.example.base;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;

    private Integer deleteStatus;
}
