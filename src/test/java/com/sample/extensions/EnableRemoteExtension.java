package com.sample.extensions;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EnableRemoteExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        if ("remote".equals(System.getProperty("mode"))) {
            Configuration.remote = "http://localhost:4444/wd/hub";
            Configuration.browserSize = "1366x768";
            Configuration.browserCapabilities = getSelenoidCapabilities(extensionContext.getDisplayName());
        }
    }

    private DesiredCapabilities getSelenoidCapabilities(String testBadgeName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("name", testBadgeName);
        return capabilities;
    }
}
