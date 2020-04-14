package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests {
    TrelloDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new TrelloDriver("https://trello.com/");
        driver.open();
    }

    @Test
    public void testBoardCreation() {

        driver.initLogin();
        driver.fillLoginForm("adkogan@gmail.com", "5605105zxc");
        driver.confirmLogin();
        initBoardCreation();

        fillBoardForm("QA23board");
        confirmBoardCreation();

        // returnToHomePage
    }
    private void confirmBoardCreation() {
        driver.click(By.className("primary"));
    }

    private void fillBoardForm(String boardName) {
        driver.wd.findElement(By.className("subtle-input")).sendKeys(boardName);
        driver.click(By.className("subtle-chooser-trigger"));
        driver.click(By.xpath("//span[contains(.,'Private')]"));
    }

    private void initBoardCreation() {
        driver.click(By.cssSelector(".mod-add"));
    }

    //@AfterMethod
    public void tearDown() {
        driver.wd.quit();
    }

}
