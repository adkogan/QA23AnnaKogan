package com.qa.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TrelloDriver {
    WebDriver wd;
    WebDriverWait wait;
    String url;

    public TrelloDriver(String url) {
        this.url = url;
        wd = new ChromeDriver();
        wait = new WebDriverWait(wd,1);

        wd
            .manage()
            .timeouts()
            .implicitlyWait(50, TimeUnit.SECONDS);
        wd
            .manage()
            .window()
            .maximize();
    }

    public void open() {
        wd.navigate().to(url);
    }

    public void confirmLogin() {
        click(By.id("login"));
    }

    public void fillLoginForm(String userEmail, String password) {
        type(By.name("user"), userEmail);
        type(By.cssSelector("input#password"), password);
        click(By.cssSelector("#login.button-green"));
    }

    public void initLogin() {

        click(By.cssSelector("a[href*='login']"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

}
