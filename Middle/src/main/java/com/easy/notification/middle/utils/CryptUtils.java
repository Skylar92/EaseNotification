package com.easy.notification.middle.utils;

import com.easy.notification.core.bean.Client;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.mindrot.jbcrypt.BCrypt;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for work with BCrypt algorithm
 *
 *
 * Created by skylar on 10.12.15.
 */
public class CryptUtils {

    private static final Logger logger = Logger.getLogger(CryptUtils.class.getName());

    private CryptUtils() {
    }

    /**
     * Generate 'salt' and encrypt password for current user
     *
     * @param user - object of {@link com.easy.notification.core.bean.Client} which new in system
     */
    public static void encryptUserData(Client user) {
        Validate.notNull(user, "user can't be null");
        Validate.notEmpty(user.getPassword(), "user.password can't be null or empty");
        //generate salt for password and encrypt user password
        logger.log(Level.INFO, "generate salt begin");
        String generatedSalt = BCrypt.gensalt(10);
        logger.log(Level.INFO, "generate salt end");
        logger.log(Level.INFO, "generate hash start");
        String hashPassword = BCrypt.hashpw(user.getPassword(), generatedSalt);
        logger.log(Level.INFO, "generate hash stop");
        //update user data
        user.setPassword(hashPassword);
        user.setSalt(generatedSalt);
    }

    /**
     * Convert password with salt to encrypt representation
     *
     * @param password - user password
     * @param salt - user salt
     *
     * @return if password or salt is empty return null, else return encrypt password
     */
    public static String convertToBCrypt(String password, String salt) {
        if (StringUtils.isBlank(password) || StringUtils.isBlank(salt))
            return null;
        return BCrypt.hashpw(password, salt);
    }


}
