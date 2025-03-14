package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper

public interface UserMapper {

    /**
     * 更具openid查询用户
     * @param openid
     * @return
     */
    @Select("SELECT * from user where openid = #{openid}")
    User getByOpenId(String openid);

    /**
     * 插入用户
     * @param user
     */
    void insert(User user);
}
