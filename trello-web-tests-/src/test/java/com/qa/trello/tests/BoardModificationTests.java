package com.qa.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.isOnBoardsPage()){
            app.getBoard().goToBoardsPageUrl("annakogan6");
            //app.getBoard().click(By.cssSelector("[href$=boards]"));
        }
//        if (app.getBoard().getBoardsCount() == 0) {
//            app.getBoard().createBoard();
//        }
  }


    @Test
    public void testBoardNameModification() {
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().changeName("retest");
        app.getBoard().returnToHomePage();

    }
}