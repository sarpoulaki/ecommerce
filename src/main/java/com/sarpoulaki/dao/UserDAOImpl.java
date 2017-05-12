package com.sarpoulaki.dao;

import com.sarpoulaki.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.SessionAttributes;

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
    public User validateUser(User u) {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User where name='"+u.getName()+"'").list();
//        List<User> userList = session.createQuery("from User").list();
        for(User ul: userList) {
            System.out.println(ul);

        }
        if (userList.size()==0)
            return null;
        User nu = userList.get(0);
        if (nu.getPassword().equals(u.getPassword())) {
            return nu;
        } else {
            return null;
        }
    }
    @Override

    public boolean authenticateUser(User u) {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User where name='"+u.getName()+"'").list();
        if (userList.size()==0)
            return false;
        return true;
    }

    @Override
    public void addUser(User u) {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User where name='"+u.getName()+"'").list();
        if (userList.size()>0) {
            u.setId(userList.get(0).getId());
            session.merge(u);
        } else {
            session.persist(u);
        }
        logger.info("User saved successfully, User Details="+u);

    }
}
