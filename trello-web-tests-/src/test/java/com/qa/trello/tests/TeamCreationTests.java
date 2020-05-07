package com.qa.trello.tests;

import com.qa.trello.model.Team;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TeamCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {

        if(!app.getBoard().isOnBoardsPage()){
            app.getBoard().goToBoardsPageUrl("annakogan6");
        }
    }

    @Test
    public void testTeamCreation() throws InterruptedException {
        app.getTeam().initTeamCreation();
        app.getTeam().fillTeamForm (
                new Team()
                        .withName("teamName" + System.currentTimeMillis())
                        .withDescription("Study"));
        app.getTeam().inviteTeamLater();
        app.getTeam().confirmTeamCreation();
        app.getTeam().returnToHomePage();



    }



}
















