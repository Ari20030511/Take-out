package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;

public interface UserService {

    /**
     * login wx
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
