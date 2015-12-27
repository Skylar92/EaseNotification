package com.easy.notification.middle.service;

import com.easy.notification.core.bean.Client;
import com.easy.notification.dao.manager.ClientEntityManager;
import com.easy.notification.middle.tools.CryptographyUserData;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;


public class ClientAuthenticationServiceTest {

    private ClientAuthenticationService authenticationService;

    @Mock private ClientEntityManager entityManager;
    @Mock private CryptographyUserData cryptographyUserData;

    @Before
    public void beforeTest() {
        authenticationService = new ClientAuthenticationService();
        MockitoAnnotations.initMocks(this);
        //by default mocking
        when(entityManager.addUser(any())).thenReturn(new Client());
        doNothing().when(cryptographyUserData).encryptUserData(any());
    }


    @Test
    public void test_registrationClient_expectedNormalFinishMethod() {
        //todo
    }

    @Test
    public void test_registrationClient_expectedThrowExceptionForNotUniqueEmail() {

    }

    @Test
    public void test_registrationClient_expectedThrowExceptionWhenValidateConstrain() {
        //todo parameter tests
    }




}