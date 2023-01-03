package com.sample.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GooglePage extends BasePage {

    private final SelenideElement googleSearchInput = $(".gLFyf");
    private final ElementsCollection searchResult = $$("#rso > div");

    public GooglePage performSearch(String searchText) {
        googleSearchInput.setValue(searchText).pressEnter();
        return this;
    }

    public void isSearchResultDisplayed() {
        searchResult.shouldHave(sizeGreaterThan(0));
    }

    @Override
    protected String getURL() {
        return "https://www.google.com/";
    }
}
