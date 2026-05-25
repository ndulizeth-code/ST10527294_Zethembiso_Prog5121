package com.mycompany.loginsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginSystemTest {

    @Test
    public void testCheckUserName_Valid() {
        assertTrue(LoginSystem.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserName_Invalid_NoUnderscore() {
        assertFalse(LoginSystem.checkUserName("kyle1"));
    }

    @Test
    public void testCheckUserName_Invalid_TooLong() {
        assertFalse(LoginSystem.checkUserName("kyl_123"));
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        assertTrue(LoginSystem.checkPasswordComplexity("Password@123"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_NoCapital() {
        assertFalse(LoginSystem.checkPasswordComplexity("password@123"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_NoNumber() {
        assertFalse(LoginSystem.checkPasswordComplexity("Password!"));
    }

    @Test
    public void testCheckPasswordComplexity_Invalid_TooShort() {
        assertFalse(LoginSystem.checkPasswordComplexity("Pass@1"));
    }

    @Test
    public void testCheckCellPhoneNumber_Valid() {
        assertTrue(LoginSystem.checkCellPhoneNumber("+27123456789"));
    }

    @Test
    public void testCheckCellPhoneNumber_Invalid_WrongFormat() {
        assertFalse(LoginSystem.checkCellPhoneNumber("08123456789"));
    }

    @Test
    public void testLoginUser_Success() {
        assertTrue(LoginSystem.loginUser("user_", "Password@123", "user_", "Password@123"));
    }

    @Test
    public void testLoginUser_Fail_WrongPassword() {
        assertFalse(LoginSystem.loginUser("user_", "WrongPass", "user_", "Password@123"));
    }

    @Test
    public void testReturnLoginStatus_Success() {
        assertEquals("Welcome, it is great to see you again.", LoginSystem.returnLoginStatus(true));
    }

    @Test
    public void testReturnLoginStatus_Fail() {
        assertEquals("Username or password incorrect, please try again.", LoginSystem.returnLoginStatus(false));
    }
}