package com.easy.notification.dao.manager;

import com.easy.notification.core.bean.Client;

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

    private static final Logger logger = Logger.getLogger(EntityManagerUser.class.getName());

    @PersistenceContext(name = "EasyNotification")
    private EntityManager entityManager;

    /**
     *
     * @param client
     * @return
     */
    public Client addUser(Client client) {
        logger.log(Level.INFO, "Start persist user {0}", client);
        entityManager.persist(client);
        logger.log(Level.INFO, "User persist successful");
        return client;
    }

}
