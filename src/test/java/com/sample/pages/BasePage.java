package com.sample.pages;

import static com.codeborne.selenide.Selenide.open;

public abstract class BasePage {

    public BasePage() {
        open(getURL());
    }

    protected abstract String getURL();
}
