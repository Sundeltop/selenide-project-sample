package com.sample.tests.saucedemo;

import com.sample.pages.saucedemo.LoginPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.page;

public class InventoryPageTest {

    @Test
    void checkShoppingCartUpdatedAfterAddingNewProduct() {
        page(LoginPage.class)
                .loginAsStandardUser()
                .addProductToShoppingCart()
                .isShoppingCartUpdated();
    }

    @Test
    void checkProductsAreSortedLowToHigh() {
        page(LoginPage.class)
                .loginAsStandardUser()
                .selectSortByOption("Price (low to high)")
                .isAllProductsSortedLowToHigh();
    }
}
