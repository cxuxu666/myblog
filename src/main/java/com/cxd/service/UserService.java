package com.cxd.service;

import com.cxd.po.User;

/**
 * Created by cxd on 2020/10/15.
 */
public interface UserService {

    User checkUser(String username, String password);
}
