package com.sample.tests.saucedemo;

import com.sample.pages.saucedemo.LoginPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;

public class LoginPageTest {

    @Test
    void checkLoginWithLockedUserShowsError() {
        page(LoginPage.class)
                .loginAsLockedUser()
                .isErrorMessageDisplayedWithText("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    void checkLoginWithInvalidUserShowsError() {
        page(LoginPage.class)
                .loginAsInvalidUser()
                .isErrorMessageDisplayedWithText("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    void checkLoginWithStandardUserShowsInventoryPage() {
        page(LoginPage.class)
                .loginAsStandardUser()
                .isInventoryPageOpened();
    }

    @Test
    void checkLoginWithEmptyPasswordShowsError() {
        page(LoginPage.class)
                .setUsername("username")
                .login()
                .isErrorMessageDisplayedWithText("Epic sadface: Password is required");
    }

    @Test
    void checkLoginWithEmptyUsernameShowsError() {
        page(LoginPage.class)
                .setPassword("password")
                .login()
                .isErrorMessageDisplayedWithText("Epic sadface: Username is required");
    }
}
