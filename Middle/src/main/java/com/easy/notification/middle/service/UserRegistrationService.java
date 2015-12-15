package com.easy.notification.middle.service;

import com.easy.notification.core.bean.Client;
import com.easy.notification.dao.manager.EntityManagerUser;
import com.easy.notification.middle.utils.CryptUtils;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by skylar on 10.12.15.
 */
@Stateless
public class UserRegistrationService {

    private static final Logger logger = Logger.getLogger(UserRegistrationService.class.getName());

    @Inject
    private EntityManagerUser entityManagerUser;

    /**
     *
     *
     * @param user
     */
    public void registrationUser(Client user) {
        logger.log(Level.INFO, "Processed generated data for user");
        CryptUtils.encryptUserData(user);
        logger.log(Level.INFO, "Finished generated data for user");
        entityManagerUser.addUser(user);
    }



}
