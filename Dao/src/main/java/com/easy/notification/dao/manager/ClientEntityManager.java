package com.easy.notification.dao.manager;

import com.easy.notification.core.bean.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Max Galich on 14.10.2015.
 */
@Stateless
public class ClientEntityManager {

    private static final Logger logger = Logger.getLogger(ClientEntityManager.class.getName());

    @PersistenceContext(name = "EasyNotification")
    private EntityManager entityManager;

    /**
     * @param client
     * @return
     */
    public Client addUser(Client client) {
        logger.log(Level.INFO, "Start persist user {0}", client);
        entityManager.persist(client);
        logger.log(Level.INFO, "User persist successful");
        return client;
    }

    public List<Client> findClientsByEmail(String email) {
        logger.log(Level.INFO, "Start search user by email [{0}]", email);
        TypedQuery<Client> query = entityManager.createNamedQuery("Client.findByEmail", Client.class);
        query.setParameter("email", email);
        return query.getResultList();
    }

}
