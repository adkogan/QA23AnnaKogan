package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        if (getTeamsCount() == 0) {
            createTeam();
        }
    }



    @Test
        public void testBoardDeletion(){
            int before = getTeamsCount();
            openFirstPersonalTeam();
            clickSettingsButton();
            initTeamDeletionInMoreMenu();

            permanentlyDeleteTeam();
            returnToHomePage();
            int after = getTeamsCount();
            System.out.println("was: " + before+ " now: " + after );
            Assert.assertEquals(after, before-1);

        }


}
