package com.easy.notification.middle.tools;

import com.easy.notification.core.bean.Client;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.mindrot.jbcrypt.BCrypt;

import javax.ejb.Singleton;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by skylar on 16.12.15.
 */
@Singleton
public class CryptographyUserData {

    private static final Logger logger = Logger.getLogger(CryptographyUserData.class.getName());

    public CryptographyUserData() {
    }

    /**
     * Generate 'salt' and encrypt password for current client
     *
     * @param client - object of {@link com.easy.notification.core.bean.Client} which new in system
     */
    public void encryptUserData(Client client) {
        logger.log(Level.INFO, "Processed generated data for client");
        Validate.notNull(client, "client can't be null");
        Validate.notEmpty(client.getPassword(), "client.password can't be null or empty");
        //generate salt for password and encrypt client password
        logger.log(Level.INFO, "generate salt begin");
        String generatedSalt = BCrypt.gensalt(10);
        logger.log(Level.INFO, "generate salt end");
        logger.log(Level.INFO, "generate hash start");
        String hashPassword = BCrypt.hashpw(client.getPassword(), generatedSalt);
        logger.log(Level.INFO, "generate hash stop");
        //update client data
        client.setPassword(hashPassword);
        client.setSalt(generatedSalt);
        logger.log(Level.INFO, "Finished generated data for client");
    }

    /**
     * Convert password with salt to encrypt representation
     *
     * @param password - user password
     * @param salt - user salt
     *
     * @return if password or salt is empty return null, else return encrypt password
     */
    public String convertToBCrypt(String password, String salt) {
        if (StringUtils.isBlank(password) || StringUtils.isBlank(salt))
            return null;
        return BCrypt.hashpw(password, salt);
    }

}
