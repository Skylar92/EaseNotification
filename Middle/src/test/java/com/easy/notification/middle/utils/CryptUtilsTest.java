package com.easy.notification.middle.utils;

import com.easy.notification.core.bean.Client;
import org.junit.Test;

import static org.junit.Assert.*;

public class CryptUtilsTest {

    @Test
    public void test_encryptUserData_expectedNormalCryptUserData() {
        String password = "password";
        Client user = new Client();
        user.setPassword("template");
        CryptUtils.encryptUserData(user);
        assertNotNull(user.getSalt());
        assertNotEquals(password, user.getPassword());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_encryptUserData_expectedRuntimeExceptionWhenUserIsNull() {
        CryptUtils.encryptUserData(null);
    }

    @Test
    public void test_convertToBCrypt_expectedRuntimeExceptionWhenSaltNull() {
        String password = CryptUtils.convertToBCrypt("password", null);
        assertNull(password);
    }

    @Test
    public void test_convertToBCrypt_expectedRuntimeExceptionWhenSaltEmpty() {
        String password = CryptUtils.convertToBCrypt("password", "    ");
        assertNull(password);
    }

    @Test
    public void test_convertToBCrypt_expectedRuntimeExceptionWhenPasswordNull() {
        String password = CryptUtils.convertToBCrypt(null, "salt");
        assertNull(password);
    }

    @Test
    public void test_convertToBCrypt_expectedRuntimeExceptionWhenPasswordEmpty() {
        String password = CryptUtils.convertToBCrypt("", "salt");
        assertNull(password);
    }

    @Test
    public void test_convertToBCrypt_expectedNormalCryptPasswordAndSalt() {
        String password = "password";
        String salt = "$2a$10$iZeeWZxFaDgol7mVpaf7JO";
        String expectedCryptPassword = "$2a$10$iZeeWZxFaDgol7mVpaf7JOp5c1wsN0ll1PKNckvvvFibShhGN8VpG";
        String currentCryptPassword = CryptUtils.convertToBCrypt(password, salt);
        assertEquals(expectedCryptPassword, currentCryptPassword);
    }


}