package com.sample.extensions;

import com.codeborne.selenide.Configuration;
import com.sample.annotation.Browser;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;

public class BrowserExtension implements BeforeAllCallback, BeforeEachCallback {

    private static final ExtensionContext.Namespace BROWSER_NAMESPACE =
            ExtensionContext.Namespace.create(BrowserExtension.class);
    private static final String BROWSER_KEY = "browser";

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        Optional<Browser> classBrowserAnnotation =
                findAnnotation(extensionContext.getRequiredTestClass(), Browser.class);

        classBrowserAnnotation.ifPresent(
                browser -> extensionContext.getStore(BROWSER_NAMESPACE).put(BROWSER_KEY, browser));
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        Optional<Browser> browserAnnotation = ofNullable(extensionContext.getStore(BROWSER_NAMESPACE)
                .get(BROWSER_KEY, Browser.class));

        Optional<Browser> methodBrowserAnnotation =
                findAnnotation(extensionContext.getRequiredTestMethod(), Browser.class);

        if (methodBrowserAnnotation.isPresent())
            browserAnnotation = methodBrowserAnnotation;

        browserAnnotation.ifPresent(browser -> Configuration.browser = browser.browserName().name());
    }
}
