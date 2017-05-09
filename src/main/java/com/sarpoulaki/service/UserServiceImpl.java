package com.sarpoulaki.service;

import com.sarpoulaki.dao.ProductDAO;
import com.sarpoulaki.dao.UserDAO;
import com.sarpoulaki.model.Product;
import com.sarpoulaki.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Override
    public boolean validateUser(User u) {
        return userDAO.validateUser(u);
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}

