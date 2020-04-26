package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {




    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {

        if(!app.isOnBoardsPage()){
            app.getBoard().goToBoardsPageUrl("annakogan6");
            //app.getBoard().click(By.cssSelector("[href$=boards]"));
        }


        if (app.getTeam().getTeamsCount() == 0) {
            app.getTeam().createTeam();
        }
    }



    @Test
        public void testBoardDeletion(){
            int before = app.getTeam().getTeamsCount();
            app.getTeam().openFirstPersonalTeam();
            app.getTeam().clickSettingsButton();
            app.getTeam().initTeamDeletionInMoreMenu();

            app.getTeam().permanentlyDeleteTeam();
            app.getTeam().returnToHomePage();
            int after = app.getTeam().getTeamsCount();
            System.out.println("was: " + before+ " now: " + after );
            Assert.assertEquals(after, before-1);

        }


}
