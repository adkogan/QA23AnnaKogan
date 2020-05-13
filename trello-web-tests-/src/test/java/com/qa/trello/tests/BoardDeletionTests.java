
package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {

        if (!app.isOnBoardsPage()) {
            //app.getBoard().click(By.cssSelector("[href$=boards]"));
            app.getBoard().goToBoardsPageUrl("annakogan6");

        }
        if (app.getBoard().getBoardsCount() == 0) {
            app.getBoard().createBoard();
        }
    }

    @Test
    public void testBoardDeletion() throws InterruptedException {

        int before = app.getBoard().getBoardsCount();
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().clickMoreButton();
        app.getBoard().initBoardDeletionInMoreMenu();

        app.getBoard().permanentlyDeleteBoard();
        app.getBoard().returnToHomePage();
        int after = app.getBoard().getBoardsCount();
        System.out.println("was: " + before + " now: " + after);
        Assert.assertEquals(after, before - 1);

    }


}