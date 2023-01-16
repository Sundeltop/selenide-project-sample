package com.sample.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public abstract class BasePage {

    public BasePage() {
        if (!webdriver().driver().hasWebDriverStarted()) {
            openPage(getURL());
        }
    }

    @Step("Open page {0}")
    private void openPage(String url) {
        open(url);
    }

    protected abstract String getURL();
}
