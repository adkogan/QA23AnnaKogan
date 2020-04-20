package com.qa.trello;

import org.openqa.selenium.By;

import org.testng.annotations.Test;


public class TeamCreationTests extends TestBase {

    @Test
    public void testTeamCreation() throws InterruptedException {
        createTeam();
        Thread.sleep(2000);
        returnToHomePage();
    }



}
















