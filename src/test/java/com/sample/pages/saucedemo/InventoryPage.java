package com.sample.pages.saucedemo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.sample.pages.BasePage;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.ClickOptions.usingDefaultMethod;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.assertj.core.api.Assertions.assertThat;

public class InventoryPage extends BasePage {

    private final SelenideElement addToCartBtn = $("#add-to-cart-sauce-labs-backpack");
    private final SelenideElement removeBtn = $("#remove-sauce-labs-backpack");
    private final SelenideElement shoppingCartBadge = $(".shopping_cart_badge");
    private final SelenideElement sortBySelect = $(".product_sort_container");
    private final SelenideElement activeSortOption = $(".active_option");
    private final ElementsCollection productsPrice = $$(".inventory_item_price");

    @Step("Add product to shopping cart")
    public InventoryPage addProductToShoppingCart() {
        addToCartBtn
                .shouldBe(enabled)
                .shouldHave(text("Add to cart"))
                .click(usingDefaultMethod())
                .should(disappear);
        removeBtn
                .shouldBe(enabled)
                .shouldHave(text("Remove"));
        return this;
    }

    @Step("Check shopping cart is updated")
    public void isShoppingCartUpdated() {
        shoppingCartBadge
                .shouldBe(visible)
                .shouldNotBe(empty);
    }

    @Step("Select sort by {0} option")
    public InventoryPage selectSortByOption(String option) {
        sortBySelect
                .selectOption(option);
        activeSortOption
                .shouldHave(text(option));
        return this;
    }

    @Step("Check all products are sorted from low to high")
    public void isAllProductsSortedLowToHigh() {
        List<Double> prices = productsPrice.asFixedIterable().stream()
                .map(product -> Double.parseDouble(product.getText().replace("$", "")))
                .collect(Collectors.toList());
        assertThat(prices).isSorted();
    }

    @Step("Check Inventory page is opened")
    public void isInventoryPageOpened() {
        webdriver().shouldHave(url(getURL()));
    }

    @Override
    protected String getURL() {
        return "https://www.saucedemo.com/inventory.html";
    }
}
