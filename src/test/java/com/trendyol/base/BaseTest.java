package com.trendyol.base;

import com.trendyol.pages.BasePage;
import com.trendyol.pages.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import static Utilities.Utility.setUtilityDriver;

public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;
    //protected LoginPage loginPage;

    private Credentials credentials = new Credentials(); // Create a Credentials instance
    protected String username = credentials.getUsername(); // Store username
    protected String password = credentials.getPassword(); // Store password

    private String url = "https://trendyol.com/";
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // WebDriver'ı başlatma
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        driver.manage().window().maximize();
        driver.get(url);

        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();
        //loginPage = new LoginPage();

        // WebDriverWait oluşturma
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Login sayfasındaki öğeleri bekleme
        //waitForElement(loginPage.getLoginButtonLocator());
        //waitForElement(loginPage.getUsernameFieldLocator());
    }

    protected void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
