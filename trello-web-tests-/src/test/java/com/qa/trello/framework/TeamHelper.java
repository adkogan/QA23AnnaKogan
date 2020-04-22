package com.qa.trello.framework;

import com.qa.trello.framework.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }


    public void createTeam(){
        initTeamCreation();
        fillTeamForm("Test_team");
        confirmTeamCreation();

    }

    public void fillTeamForm(String nameOfTeam) {
        type(By.cssSelector("[data-test-id=header-create-team-name-input]"), nameOfTeam);
        click(By.id("teamTypeSelect"));
        click(By.cssSelector("[data-test-id^=header-create-team-type] li"));
    }

    public void confirmTeamCreation() {
        click(By.cssSelector("[type='submit']"));
        click(By.cssSelector("[class='eg0KI5SqghoOFd']"));
    }

    public void initTeamCreation() {
        click(By.cssSelector("[class='icon-add icon-sm _2aV_KY1gTq1qWc']"));
    }

    public void inviteTeamLater() {
        if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) {
            click(By.cssSelector("[data-test-id=show-later-button]"));
        }
    }
    public void permanentlyDeleteTeam() {
        confirm();
    }

    public void initTeamDeletionInMoreMenu() {
        click(By.cssSelector(".quiet-button"));
    }



    public void clickSettingsButton() {
        click(By.cssSelector(".icon-gear"));
    }

    public void openFirstPersonalTeam() {
        click(By.xpath("//ul[div/div/div/text() = 'teams']/li[1]"));

    }

    public int getTeamsCount() {
        return wd.findElements(By.xpath("//ul[div/div/div/text() = 'teams']/li")).size()-1;
    }

    public void changeTeamName() {
        clickSettingsButton();
        click(By.xpath("//button[contains(., 'Edit Team')]"));
        wd.findElement(By.xpath("//input[@id='displayName']")).clear();
        wd.findElement(By.xpath("//input[@id='displayName']")).sendKeys("Team_Retest" + Keys.ENTER);


    }
}
