package com.qa.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreationTests {
    WebDriver wd;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {

        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd,1);
        wd.manage().window().maximize();

        wd.navigate().to("https://trello.com/");
    }


    @Test
    public void testBoardCreation() {

        initLogin();
        fillLoginForm("adkogan@gmail.com", "5605105zxc");
        confirmLogin();

        
        initBoardCreation();

        fillBoardForm("QA23board");


        confirmBoardCreation();


        // returnToHomePage

    }

    private void confirmBoardCreation() {
        click(By.className("primary"));
    }

    private void fillBoardForm(String boardName) {
        wd.findElement(By.className("subtle-input")).sendKeys(boardName);
        click(By.className("subtle-chooser-trigger"));
        click(By.xpath("//span[contains(.,'Private')]"));
    }

    private void initBoardCreation() {
        click(By.cssSelector(".mod-add"));
    }

    private void confirmLogin() {
       //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit"))).click();
        click(By.id("login"));
    }

    private void fillLoginForm(String userEmail, String password) {
        type(By.name("user"), userEmail);
        type(By.cssSelector("input#password"), password);
        click(By.cssSelector("#login.button-green"));
    }

    private void initLogin() {

        click(By.cssSelector("a[href*='login']"));
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    private void click(By locator) {

       wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }


    //@AfterMethod
    public void tearDown() {
        wd.quit();
    }

}
