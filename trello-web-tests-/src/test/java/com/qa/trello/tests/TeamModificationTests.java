package com.qa.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends  TestBase{



    @BeforeMethod
    public void ensurePreconditions() {
//    if(!isOnBoardsPage()){
        app.getBoard().openBoardsPage();
//////    }
        if (app.getTeam().getTeamsCount() == 0) {
            app.getTeam().createTeam();
        }
    }


    @Test
    public void testTeamNameModification() {
        app.getTeam().openFirstPersonalTeam();
        app.getTeam().changeTeamName();
        app.getBoard().returnToHomePage();



    }
}



