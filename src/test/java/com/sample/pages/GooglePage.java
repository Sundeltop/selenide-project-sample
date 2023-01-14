package com.sample.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GooglePage extends BasePage {

    private final SelenideElement googleSearchInput = $("input.gLFyf");
    private final ElementsCollection searchResult = $$("#rso > div");

    public GooglePage performSearch(String searchText) {
        googleSearchInput
                .setValue(searchText)
                .pressEnter()
                .shouldHave(value(searchText));
        return this;
    }

    public void isSearchResultDisplayed() {
        searchResult
                .shouldHave(sizeGreaterThan(1));
    }

    @Override
    protected String getURL() {
        return "https://www.google.com/";
    }
}
