package com.sarpoulaki.dao;

import com.sarpoulaki.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by admin on 5/6/2017.
 */
public class UserDAOImpl implements UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    @Override
    public boolean validateUser(User u) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, u.getName());
        logger.info("User loaded successfully, User details="+user);
        if (user.getPassword().equals(u.getPassword())) {
            return true;
        } else {
            return false;
        }

    }
}
