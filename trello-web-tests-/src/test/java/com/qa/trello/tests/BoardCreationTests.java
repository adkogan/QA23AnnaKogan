

package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {

        if(!app.isOnBoardsPage()){
            app.getBoard().goToBoardsPageUrl("annakogan6");
            //app.getBoard().click(By.cssSelector("[href$=boards]"));
        }
    }




    @Test
    public void testBoardCreation() {
        int before = app.getBoard().getBoardsCount();
//        app.getBoard().initBoardCreation();
//        app.getBoard().fillBoardForm("Test3", "[title='blue']");
//        app.getBoard().confirmBoardCreation();
        app.getBoard().returnToHomePage();
        int after = app.getBoard().getBoardsCount();

       Assert.assertEquals(after, before + 1);

    }
}
















//package com.qa.trello;
//
//import org.openqa.selenium.By;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class BoardCreationTests {
//    TrelloDriver driver;
//
//    @BeforeMethod
//    public void setUp() {
//        driver = new TrelloDriver("https://trello.com/");
//        driver.open();
//    }
//
//    @Test
//    public void testBoardCreation() {
//
//        driver.initLogin();
//        driver.fillLoginForm("adkogan@gmail.com", "5605105zxc");
//        driver.confirmLogin();
//        initBoardCreation();
//
//        fillBoardForm("QA23board");
//        confirmBoardCreation();
//
//        // returnToHomePage
//    }
//    private void confirmBoardCreation() {
//        driver.click(By.className("primary"));
//    }
//
//    private void fillBoardForm(String boardName) {
//        driver.wd.findElement(By.className("subtle-input")).sendKeys(boardName);
//        driver.click(By.className("subtle-chooser-trigger"));
//        driver.click(By.xpath("//span[contains(.,'Private')]"));
//    }
//
//    private void initBoardCreation() {
//        driver.click(By.cssSelector(".mod-add"));
//    }
//
//    //@AfterMethod
//    public void tearDown() {
//        driver.wd.quit();
//    }
//
//}
