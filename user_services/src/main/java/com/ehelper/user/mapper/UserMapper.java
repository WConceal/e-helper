package com.ehelper.user.mapper;

import com.ehelper.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from `e-helper`.User where id=#{id}")
    User getUserById(int id);
}
