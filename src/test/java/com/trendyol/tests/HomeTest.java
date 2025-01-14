package com.trendyol.tests;

import com.trendyol.base.BaseTest;
import com.trendyol.pages.HomePage;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager; // LogManager ekleyin

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(HomeTest.class); // Log4j2 Logger kullanımına geçiş

    @Test
    @Description("Test to verify if the logo is displayed on the homepage.")
    public void testIsLogoDisplayed() {
        logger.info("Site açılma testi başladı.");
        HomePage homePage = new HomePage();
        homePage.closePopup();
        assertTrue(homePage.isLogoDisplayed(),
                "\n Logo is not displayed \n");
        logger.info("Logo bulundu.");
        logger.info("Site açılma testi tamamlandı.");
    }

    @Test
    @Description("Test to log in and perform all operations.")
    public void testAllOperations() throws InterruptedException {
        HomePage homePage = new HomePage();
        logger.info("Test başladı.");
        homePage.closePopup();
        homePage.clickLoginField();
        homePage.setUsername(username);
        homePage.setPassword(password);
        homePage.clickLoginButton();
        assertTrue(homePage.isLoginSuccessful(),
                "\n Login is not successful \n");
        logger.info("Başarıyla giriş yapıldı.");
        homePage.searchBarInput("samsung");
        homePage.clickSearchButton();
        homePage.clickSelectedMenuItem();
        assertTrue(homePage.isSearchResultCorrect(),
                "\n Samsung results is not listed \n");
        logger.info("Arama sonucu doğru.");
        homePage.desiredProduct();
        //String pageTwoUrl = "https://www.trendyol.com/sr?wc=164461&q=samsung&qt=samsung&st=samsung&os=1&pi=2";
        Thread.sleep(3000);
        assertTrue(homePage.isPageTwoOpened().contains("pi=2"));
        homePage.clickDesiredProduct();
        Thread.sleep(5000);
        homePage.pageSwap();
        homePage.clickLikeButton();
        Thread.sleep(3000);
        homePage.clickFavoritesField();
        Thread.sleep(3000);
        assertTrue(homePage.isSearchResultCorrect(),
                "\n Product is not added favorites list \n");
        logger.info("Başarıyla favorilere eklendi");
        homePage.clickAddToCartButton();
        homePage.clickCartButton();
        homePage.clickRemoveProductButton();
        assertTrue(homePage.isProductRemovedFromCart(),
                "\n Product is not removed from cart \n");
        logger.info("Başarıyla sepetten kaldırıldı.");
        Thread.sleep(3000);
        logger.info("Test başarıyla tamamlandı.");
    }

}
