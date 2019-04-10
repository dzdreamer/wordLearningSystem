package com.learning.english.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface Common {
    @Select("select username from user where account=#{account} and password=#{password}")
    public String login(@Param("account") String sno,@Param("password") String password);
}
