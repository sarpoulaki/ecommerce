package com.sarpoulaki.service;

import com.sarpoulaki.model.User;

import java.util.List;

/**
 * Created by admin on 5/6/2017.
 */
public interface UserService {

    public User validateUser(User u);

    public String addUser(User u);

}
