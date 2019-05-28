package com.dm.example.service;

import com.dm.example.beans.UserAccountBean;
import com.dm.example.dto.ResultDto;
import com.dm.example.exception.CustomException;

public interface UserAccountService {
    //更新账号
    ResultDto save(UserAccountBean paramBean);
}
