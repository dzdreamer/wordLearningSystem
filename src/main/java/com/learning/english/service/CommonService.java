package com.learning.english.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.learning.english.mapper.Common;


@Service
public class CommonService {
    @Autowired
    public Common commonmapper;
    public String login(String account, String password){
        return commonmapper.login(account, password);
    }
}

