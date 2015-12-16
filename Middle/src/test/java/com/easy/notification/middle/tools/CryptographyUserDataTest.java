package com.easy.notification.middle.tools;

import com.easy.notification.core.bean.Client;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CryptographyUserDataTest {

    private static CryptographyUserData cryptographyUserData;

    @BeforeClass
    public static void init() {
        cryptographyUserData = new CryptographyUserData();
    }

    @Test
    public void test_encryptUserData_expectedNormalCryptUserData() {
        String password = "password";
        Client user = new Client();
        user.setPassword("template");
        cryptographyUserData.encryptUserData(user);
        assertNotNull(user.getSalt());
        assertNotEquals(password, user.getPassword());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_encryptUserData_expectedRuntimeExceptionWhenUserIsNull() {
        cryptographyUserData.encryptUserData(null);
    }

    @Test
    public void test_convertToBCrypt_expectedRuntimeExceptionWhenSaltNull() {
        String password = cryptographyUserData.convertToBCrypt("password", null);
        assertNull(password);
    }

    @Test
    public void test_convertToBCrypt_expectedRuntimeExceptionWhenSaltEmpty() {
        String password = cryptographyUserData.convertToBCrypt("password", "    ");
        assertNull(password);
    }

    @Test
    public void test_convertToBCrypt_expectedRuntimeExceptionWhenPasswordNull() {
        String password = cryptographyUserData.convertToBCrypt(null, "salt");
        assertNull(password);
    }

    @Test
    public void test_convertToBCrypt_expectedRuntimeExceptionWhenPasswordEmpty() {
        String password = cryptographyUserData.convertToBCrypt("", "salt");
        assertNull(password);
    }

    @Test
    public void test_convertToBCrypt_expectedNormalCryptPasswordAndSalt() {
        String password = "password";
        String salt = "$2a$10$iZeeWZxFaDgol7mVpaf7JO";
        String expectedCryptPassword = "$2a$10$iZeeWZxFaDgol7mVpaf7JOp5c1wsN0ll1PKNckvvvFibShhGN8VpG";
        String currentCryptPassword = cryptographyUserData.convertToBCrypt(password, salt);
        assertEquals(expectedCryptPassword, currentCryptPassword);
    }



}