package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class HelperBase {
    WebDriver wd;
  public
  WebDriverWait wait;

    public HelperBase(WebDriver wd) {

        this.wd = wd;
    }

    public void returnToHomePage() {
        click(By.cssSelector("[name ='house']"));
    }

    public void click(By locator) {

        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        waitForElementLocatedAndClick(locator, 15);
        //click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void confirm() {
        click(By.cssSelector(".js-confirm"));
    }

    public void
    waitForElementLocatedAndClick(By locator, int timeOut) {
        waitForElement(locator, timeOut).click();
    }

    public WebElement waitForElement(By locator, int timeOut) {
        return new WebDriverWait(wd, timeOut)

                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }




}
