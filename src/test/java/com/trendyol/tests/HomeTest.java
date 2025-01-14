package com.trendyol.tests;

import com.trendyol.base.BaseTest;
import com.trendyol.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeTest extends BaseTest {

    @Test
    public void isLogoDisplayed() {
        HomePage homePage = new HomePage();
        homePage.closePopup();
        assertTrue(homePage.isLogoDisplayed(),
                "\n Logo is not displayed \n");
    }

    @Test
    public void clickLoginField() throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.closePopup();
        homePage.clickLoginField();
        homePage.setUsername(username);
        homePage.setPassword(password);
        homePage.clickLoginButton();
        assertTrue(homePage.isLoginSuccessful(),
                "\n Login is not successful \n");
        homePage.searchBarInput("samsung");
        homePage.clickSearchButton();
        homePage.clickSelectedMenuItem();
        assertTrue(homePage.isSearchResultCorrect(),
                "\n Samsung results is not listed \n");
        homePage.desiredProduct();
        String pageTwoUrl = "https://www.trendyol.com/sr?wc=164461&q=samsung&qt=samsung&st=samsung&os=1&pi=2";
        Thread.sleep(3000);
        assertEquals(homePage.isPageTwoOpened(), pageTwoUrl, "https://www.trendyol.com/sr?q=samsung&qt=samsung&st=samsung&os=1&pi=2");
        homePage.clickDesiredProduct();
        Thread.sleep(5000);
        homePage.pageSwap();
        homePage.clickLikeButton();
        Thread.sleep(3000);
        homePage.clickFavoritesField();
        Thread.sleep(3000);
        assertTrue(homePage.isSearchResultCorrect(),
                "\n Product is not added favorites list \n");
        homePage.clickAddToCartButton();
        homePage.clickCartButton();
        homePage.clickRemoveProductButton();
        assertTrue(homePage.isProductRemovedFromCart(),
                "\n Product is not removed from cart \n");
        Thread.sleep(3000);
    }

}
