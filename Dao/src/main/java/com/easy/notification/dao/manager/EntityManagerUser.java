package com.easy.notification.dao.manager;

import com.easy.notification.core.bean.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Max Galich on 14.10.2015.
 */
@Stateless
public class EntityManagerUser {

    private static final Logger LOGGER = Logger.getLogger(EntityManagerUser.class.getName());

    @PersistenceContext(name = "EasyNotification")
    private EntityManager entityManager;

    /**
     *
     * @param user
     * @return
     */
    public User addUser(User user) {
        entityManager.persist(user);
        LOGGER.log(Level.INFO, "User persist successful");
        return user;
    }

}
