package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }


    public void createTeam() {
        initTeamCreation();
        fillTeamForm("Test_team");
        confirmTeamCreation();

    }

    public void fillTeamForm(String nameOfTeam) {
        type(By.cssSelector("[data-test-id=header-create-team-name-input]"), nameOfTeam);
        click(By.id("teamTypeSelect"));
        click(By.cssSelector("[data-test-id^=header-create-team-type] li"));
    }

    public String confirmTeamCreation() {
        //click(By.cssSelector("[type='submit']"));
        //waitForElementLocatedAndClick(By.xpath("//button[@data-test-id ='header-create-team-submit-button']"), 20);
        click(By.xpath("//button[@data-test-id ='header-create-team-submit-button']"));
        inviteTeamLater();
        final String url=  wd.getCurrentUrl();
        return url;
    }

    public void initTeamCreation() {
        //click(By.xpath("[data-test-id ='header-create-menu-button']"));
        waitForElementLocatedAndClick(By.cssSelector(".icon-add"), 10);
        // click(By.cssSelector(".icon-add"));
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
       // click(By.cssSelector(".icon-gear"));
        click(By.cssSelector(".js-org-account"));
    }

    public void openFirstPersonalTeam() {
        click(By.xpath("//ul[div/div/div/text() = 'teams']/li[1]"));

    }

    public int getTeamsCount() {
        return wd.findElements(By.xpath("//ul[div/div/div/text() = 'teams']/li")).size() - 1;
    }

    public void changeTeamName(String nameOfTeam) {
        //clickSettingsButton();

        click(By.xpath("//button[contains(., 'Edit Team')]"));
        wd.findElement(By.xpath("//input[@id='displayName']")).clear();
        wd.findElement(By.xpath("//input[@id='displayName']")).sendKeys(nameOfTeam + Keys.ENTER);

       // click(By.cssSelector(".js-org-account"))
//


    }


}
