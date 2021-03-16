package com.cxd.dao;

import com.cxd.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cxd on 2020/10/15.
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);
}
