package com.easy.notification.middle.service;

import com.easy.notification.core.bean.User;
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
    public void registrationUser(User user) {
        logger.log(Level.INFO, "Registration new user {0}", user);
        user = CryptUtils.encryptUserData(user);
        user.setPassword("12312312312");
        user.setSalt("sdfdsds");
        entityManagerUser.addUser(user);
    }



}
