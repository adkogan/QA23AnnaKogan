package com.qa.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.qa.trello.tests.TeamTests.nameOfTeam;

public class TeamModificationTests extends  TestBase{



    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.isOnBoardsPage()) {
            app.getBoard().goToBoardsPageUrl("annakogan6");

            if (app.getTeam().getTeamsCount() == 0) {
                app.getTeam().createTeam();
            }
        }
    }


    @Test
    public void testTeamNameModification() {
        app.getTeam().openFirstPersonalTeam();
        app.getTeam().changeTeamName(nameOfTeam);
        app.getBoard().returnToHomePage();



    }
}



