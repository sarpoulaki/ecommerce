package com.sarpoulaki.service;

import com.sarpoulaki.dao.UserDAO;
import com.sarpoulaki.model.User;
import com.sarpoulaki.utils.EmailValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Override
    @Transactional
    public boolean validateUser(User u) {
        return userDAO.validateUser(u);
    }

    @Override
    @Transactional
    public String addUser(User u) {
        if ("".equals(u.getName()))
            return "Please enter user name!";
        if ("".equals(u.getEmail()))
            return "please enter email address";
        if ("".equals(u.getPassword()))
            return "Please enter password!";
        if (!u.getPassword().equals(u.getConfirmpassword()))
            return "Password does not match confirmation!";
        EmailValidator em = new EmailValidator();
        if (!em.validate(u.getEmail()))
            return "please enter a valid email address";
        if (userDAO.authenticateUser(u))
            return "User already exist!";
        userDAO.addUser(u);
        return "";
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}

