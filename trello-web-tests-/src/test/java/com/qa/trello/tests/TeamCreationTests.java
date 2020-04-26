package com.qa.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TeamCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {

        if(!app.isOnBoardsPage()){
            app.getBoard().goToBoardsPageUrl("annakogan6");
            //app.getBoard().click(By.cssSelector("[href$=boards]"));
        }
    }

    @Test
    public void testTeamCreation()  {
        app.getTeam().initTeamCreation();
        app.getTeam().fillTeamForm("Team_tests");
        app.getTeam().inviteTeamLater();
        app.getTeam().confirmTeamCreation();
        app.getTeam().returnToHomePage();



    }



}
















