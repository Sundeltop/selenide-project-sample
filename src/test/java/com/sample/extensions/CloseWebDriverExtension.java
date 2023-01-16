package com.sample.extensions;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CloseWebDriverExtension implements AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        closeWebDriver();
    }
}
