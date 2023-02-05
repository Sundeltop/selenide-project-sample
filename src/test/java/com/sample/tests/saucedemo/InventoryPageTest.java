package com.sample.tests.saucedemo;

import com.sample.pages.saucedemo.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.page;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class InventoryPageTest {

    @Test
    void checkShoppingCartUpdatedAfterAddingNewProduct() {
        page(LoginPage.class)
                .loginAsStandardUser()
                .addProductToShoppingCart()
                .isShoppingCartUpdated();
    }

    private static Stream<Arguments> checkProductsAreSortedByPriceDataProvider() {
        return Stream.of(
                arguments("Price (low to high)", naturalOrder()),
                arguments("Price (high to low)", reverseOrder())
        );
    }

    @ParameterizedTest
    @MethodSource("checkProductsAreSortedByPriceDataProvider")
    void checkProductsAreSortedByPrice(String sortOption, Comparator<Double> order) {
        page(LoginPage.class)
                .loginAsStandardUser()
                .selectSortByOption(sortOption)
                .isAllProductsSorted(order);
    }
}
