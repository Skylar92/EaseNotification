package com.easy.notification.middle.utils;

import com.easy.notification.core.bean.User;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by skylar on 10.12.15.
 */
public class CryptUtils {

    private CryptUtils() {}

    /**
     *
     * @param user
     * @return
     */
    public static User encryptUserData(User user) {
        //generate salt for password and encrypt user password
        String generatedSalt = BCrypt.gensalt(30);
        String hashPassword = BCrypt.hashpw(user.getPassword(), generatedSalt);
        //update user data
        user.setPassword(hashPassword);
        user.setSalt(generatedSalt);
        return user;
    }

    /**
     *
     * @param password
     * @param salt
     * @return
     */
    public static String convertToBCrypt(String password, String salt) {
        if (password == null || password.isEmpty())
            return null;
        return BCrypt.hashpw(password, salt);
    }



}
