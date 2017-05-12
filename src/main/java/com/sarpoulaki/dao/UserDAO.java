package com.sarpoulaki.dao;

import com.sarpoulaki.model.User;

import java.util.List;

/**
 * Created by admin on 5/6/2017.
 */
public interface UserDAO {

    public boolean authenticateUser(User u);

    public User validateUser(User u);

    public void addUser(User u);

}
