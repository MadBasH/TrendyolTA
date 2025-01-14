package com.trendyol.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.JavaScriptUtility.clickElementJS;
import static Utilities.JavaScriptUtility.scrollToElementJS;

public class HomePage extends BasePage {

    private By popupField = By.cssSelector("#gender-popup-modal > div > div > div.modal-close");
    private By logoField = By.cssSelector("#logo");
    private By loginField = By.cssSelector("#account-navigation-container > div > div.account-nav-item.user-login-container");
    private By usernameField = By.cssSelector("#login-email");
    private By passwordField = By.cssSelector("#login-password-input");
    private By loginButtonField = By.cssSelector("#login-register > div.lr-container > div.q-layout.login > form > button");
    private By loginSuccessfulCheck = By.xpath("//*[text()='Hesabım']");
    private By searchBarField = By.cssSelector("#sfx-discovery-search-suggestions > div > div.N4M8bfaJ > input");
    private By searchButtonField = By.cssSelector("#sfx-discovery-search-suggestions > div > div.N4M8bfaJ > i");
    private By androidPhoneMenuField = By.xpath("//*[text()='Android Cep Telefonu']");
    private By searchResultField = By.xpath("//*[text()='Samsung']");
    private By desiredProductField = By.cssSelector("#search-app > div > div > div > div.srch-prdcts-cntnr.srch-prdcts-cntnr-V2.search-products-container-for-blacklistUrl > div:nth-child(4) > div:nth-child(1) > div > div:nth-child(18)");
    private By productPopupField = By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div/div[2]/div[2]/div/div[1]/aside/div/div/div[2]/div/div[2]/div/div/button");
    private By likeButtonField = By.xpath("//*[@id=\"product-detail-app\"]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[4]/div/div/div/button");
    private By favoritesField = By.cssSelector("#account-navigation-container > div > a > div > p");
    private By addToCartField = By.cssSelector("#favorites > div > div > div.q-layout.favorites-layout > div.favorites-infinite-scroll > div > div > div.product-card-wrapper > div.product-bottom-wrapper > div.product-button-wrapper > div > div > div.basket-buttons-container > button");
    private By cartButtonField = By.cssSelector("#sticky-header > div > div > div.account-navigation-wrapper > div.account-nav-item.basket-preview > a > p");
    private By removeProductButtonField = By.cssSelector("#pb-container > div > div.pb-merchant-group > div.pb-basket-item-wrapper-v2 > div > div.pb-basket-item-actions > button");
    private By isProductRemovedFromCart = By.xpath("//*[text()=' ürünü sepetinden kaldırıldı ve ']");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekle

    public void clickElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        click(locator);
    }

    public void JSclickElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        clickElementJS(locator);
    }

    public boolean isLogoDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoField));
        return find(logoField).isDisplayed();
    }

    public void closePopup() {
        clickElement(popupField);
    }


    public void clickLoginField() {
        clickElement(loginField);
    }

    public void setUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        set(usernameField, username);
    }

    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        set(passwordField, password);
    }

    public void clickLoginButton() {
        clickElement(loginButtonField);
    }

    public boolean isLoginSuccessful() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginSuccessfulCheck));
        return find(loginSuccessfulCheck).isDisplayed();
    }

    public void searchBarInput(String searchText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBarField));
        WebElement searchField = driver.findElement(searchBarField);
        searchField.sendKeys(searchText + Keys.ENTER);
    }

    public void clickSearchButton(){
        clickElement(searchButtonField);
    }

    public void clickSelectedMenuItem() {
        clickElement(androidPhoneMenuField);
    }

    public boolean isSearchResultCorrect(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResultField));
        return find(searchResultField).isDisplayed();
    }

    public String isPageTwoOpened() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public void desiredProduct(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(desiredProductField));
        scrollToElementJS(desiredProductField);
    }

    public void clickDesiredProduct() {
        clickElement(desiredProductField);
    }

    public void closeProductPopup() {
        JSclickElement(productPopupField);
    }

    public void clickLikeButton() {
        JSclickElement(likeButtonField);
    }

    public void pageSwap() {
        String parentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void clickFavoritesField(){
        JSclickElement(favoritesField);
    }

    public void clickAddToCartButton(){
        JSclickElement(addToCartField);
    }

    public void clickCartButton() {
        JSclickElement(cartButtonField);
    }

    public void clickRemoveProductButton() {
        JSclickElement(removeProductButtonField);
    }

    public boolean isProductRemovedFromCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(isProductRemovedFromCart));
        return find(isProductRemovedFromCart).isDisplayed();
    }


}
