package com.qa.trello.framework;

import com.qa.trello.model.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }


//team creation

    public void initTeamCreation() {
        //click(By.xpath("[data-test-id ='header-create-menu-button']"));
        waitForElementLocatedAndClick(By.cssSelector(".icon-add"), 10);
        // click(By.cssSelector(".icon-add"));
    }

    public void fillTeamForm(Team nameOfTeam) {
        type(By.cssSelector("[data-test-id=header-create-team-name-input]"), "qa");
        click(By.id("teamTypeSelect"));
        click(By.cssSelector("[data-test-id^=header-create-team-type] li"));
    }


    public void createTeam() throws InterruptedException {
        openFirstPersonalTeam();
        initTeamDeletionInMoreMenu();
        permanentlyDeleteTeam();
        returnToHomePage();
    }

    public void confirmTeamCreation() {
        click(By.cssSelector("[type='submit']"));
        click(By.cssSelector("[class='eg0KI5SqghoOFd']"));

    }
    public void inviteTeamLater() {
        if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) {
            click(By.cssSelector("[data-test-id=show-later-button]"));

        }
    }

    //Team deletion
    public void permanentlyDeleteTeam() {
        confirm();
    }

    public void initTeamDeletionInMoreMenu() {
        waitForElementLocatedAndClick(By.cssSelector(".quiet-button"), 10);
    }


    public void clickSettingsButton() {
        click(By.cssSelector(".icon-gear"));
        click(By.cssSelector(".js-org-account"));
    }

    public void openFirstPersonalTeam() {
        click(By.xpath("//ul[div/div/div/text() = 'teams']/li[1]"));

    }

    public int getTeamsCount() {
        return wd.findElements(By.xpath("//ul[div/div/div/text() = 'teams']/li")).size() - 1;
    }


    //team modification
    public void changeTeamName(String nameOfTeam) {
        clickSettingsButton();
        click(By.xpath("//button[contains(., 'Edit Team')]"));
        wd.findElement(By.xpath("//input[@id='displayName']")).clear();
        wd.findElement(By.xpath("//input[@id='displayName']")).sendKeys("retest" + Keys.ENTER);

        // click(By.cssSelector(".js-org-account"))
//

    }


}
