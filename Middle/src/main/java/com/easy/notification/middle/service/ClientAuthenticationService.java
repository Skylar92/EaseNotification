package com.easy.notification.middle.service;

import com.easy.notification.core.bean.Client;
import com.easy.notification.core.exceptions.ApplicationException;
import com.easy.notification.core.exceptions.Code;
import com.easy.notification.dao.manager.ClientEntityManager;
import com.easy.notification.middle.tools.CryptographyUserData;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for registration and check data client
 * <p>
 * Created by skylar on 10.12.15.
 */
@Stateless
public class ClientAuthenticationService {

    private static final Logger logger = Logger.getLogger(ClientAuthenticationService.class.getName());

    @Inject
    private ClientEntityManager clientEntityManager;
    @Inject
    private CryptographyUserData cryptographyUserData;
    @Inject
    private Validator validator;

    /**
     * Registration new client of system
     *
     * @param client - object {@link com.easy.notification.core.bean.Client} which contains base information about new client
     */
    public void registrationClient(Client client) {
        logger.log(Level.INFO, "Start registration new client");
        validateClientFields(client);
        validateClientForUniqueEmail(client);
        cryptographyUserData.encryptUserData(client);
        clientEntityManager.addUser(client);
        logger.log(Level.INFO, "Finish registration new client");
    }

    private void validateClientFields(Client client) {
        logger.log(Level.INFO, "validator is ", validator == null ? "null" : validator.toString());
        Set<ConstraintViolation<Client>> validateResult = validator.validate(client);
        if (validateResult.isEmpty())
            return;
        List<ConstraintViolation<Client>> constraintViolations = new ArrayList<>(validateResult);
        //send client one by one message about incorrect data. Not all for one
        throw new ApplicationException(constraintViolations.get(0).getMessage(), Code.INVALID_INPUT_DATA);
    }

    private void validateClientForUniqueEmail(Client client) {
        List<Client> clientsByEmail = clientEntityManager.findClientsByEmail(client.getEmail());
        if (!clientsByEmail.isEmpty())
            throw new ApplicationException(Code.NOT_UNIQUE_EMAIL);
    }


}
