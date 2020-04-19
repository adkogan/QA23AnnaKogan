package com.qa.trello;

import org.openqa.selenium.By;

import org.testng.annotations.Test;


public class TeamCreationTests extends TestBase {

    @Test
    public void testTeamCreation() throws InterruptedException {
        initTeamCreation();
        fillForm("Team_test2", By.cssSelector("[class='_38pq5NbRWAG39y']"));
        confirmTeamCreation();
        Thread.sleep(2000);
        returnToHomePage();
    }

}


















//package com.qa.trello;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class TeamCreationTests {
//
//    TrelloDriver driver;
//
//
//    @BeforeMethod
//    public void setup() {
//
//        driver = new TrelloDriver("https://trello.com/");
//        driver.open();
//
//    }
//
//
//    @Test
//    public void testTeamCreation() {
//        driver.initLogin();
//        driver.fillLoginForm("adkogan@gmail.com", "5605105zxc");
//        driver.confirmLogin();
//
//        initTeamCreation();
//        fillTeamForm("TeamQA23");
//
//
//    }
//
//    private void fillTeamForm(String groupName) {
//        driver.wd.findElement(By.cssSelector("[data-test-id=\"header-create-team-name-input\"]")).sendKeys(groupName);
//        driver.wd.findElement(By.cssSelector("[data-test-id=\"header-create-team-type-input\"]")).click();
//        driver.wd.findElement(By.cssSelector("[data-test-id=\"header-create-team-type-input-sales\"]")).click();
//        driver.wd.findElement(By.cssSelector("[data-test-id=\"header-create-team-submit-button\"]")).click();
//        driver.wd.findElement(By.cssSelector("[data-test-id=\"show-later-button\"]")).click();
//
//    }
//
//    private void initTeamCreation() {
//
//        click(By.cssSelector(".icon-add"));
//    }
//
//    private void click(By locator) {
//
//        driver.wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
//    }
//
//    //@AfterMethod
//    public void tearDown() {
//        driver.wd.quit();
//    }
//
//}
