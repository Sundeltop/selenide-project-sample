package com.sample.pages.saucedemo;

import com.codeborne.selenide.SelenideElement;
import com.sample.enums.User;
import com.sample.pages.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends BasePage {

    private final SelenideElement usernameField = $("#user-name");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginBtn = $("#login-button");
    private final SelenideElement errorMessage = $(".error-message-container");

    @Step("Login as Standard User")
    public InventoryPage loginAsStandardUser() {
        loginAs(User.STANDARD);
        return page(InventoryPage.class);
    }

    @Step("Login as Locked User")
    public LoginPage loginAsLockedUser() {
        loginAs(User.LOCKED);
        return this;
    }

    @Step("Login as Invalid User")
    public LoginPage loginAsInvalidUser() {
        loginAs(User.INVALID);
        return this;
    }

    @Step("Check error message with text: '{0}' is displayed")
    public void isErrorMessageDisplayedWithText(String errorMessageText) {
        errorMessage
                .shouldBe(visible)
                .shouldHave(text(errorMessageText));
    }

    @Step("Set username: {0} ")
    public LoginPage setUsername(String username) {
        usernameField
                .setValue(username)
                .shouldHave(value(username));
        return this;
    }

    @Step("Set password: {0} ")
    public LoginPage setPassword(String password) {
        passwordField
                .setValue(password)
                .shouldHave(value(password));
        return this;
    }

    @Step("Click login button")
    public LoginPage login() {
        loginBtn
                .shouldBe(enabled)
                .click();
        return this;
    }

    public InventoryPage login(Class<InventoryPage> inventoryPageClass) {
        login();
        return page(inventoryPageClass);
    }

    private void loginAs(User user) {
        this
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .login();
    }

    @Override
    protected String getURL() {
        return "https://www.saucedemo.com/";
    }
}
