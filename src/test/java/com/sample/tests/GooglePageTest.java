package com.sample.tests;

import com.sample.pages.GooglePage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;

public class GooglePageTest {

    @Test
    public void checkGoogleSearch() {
        System.out.println("hello world");
        page(GooglePage.class)
                .performSearch("iphone")
                .isSearchResultDisplayed();
    }
}
