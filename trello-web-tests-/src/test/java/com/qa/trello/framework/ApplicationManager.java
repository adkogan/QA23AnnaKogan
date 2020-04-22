package com.qa.trello.framework;

import com.qa.trello.framework.BoardHelper;
import com.qa.trello.framework.SessionHelper;
import com.qa.trello.framework.TeamHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    BoardHelper board;
    TeamHelper team;
    SessionHelper session;



//    public void fillForm(String nameOfTeam, By locatorTeamType) {
//        type(By.cssSelector("[class='_1CLyNodCAa-vQi']"), nameOfTeam);
//        click(By.id("teamTypeSelect"));
//        click(locatorTeamType);
//        session = new SessionHelper(wd);
//
//
//    }

    public void init() throws InterruptedException {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");

        session = new SessionHelper(wd);
        session.fillLoginForm("adkogan@gmail.com", "5605105zxc");

        board= new BoardHelper(wd);
        team = new TeamHelper(wd);
    }






//    public boolean isElementPresent(By locator){ return wd.findElements(locator).size()>0; }
//
//    public void createTeam() {
//        initTeamCreation();
//        fillForm("Team_test2", By.cssSelector("[class='_38pq5NbRWAG39y']"));
//        confirmTeamCreation();
//    }
//


    public void stop() {
        wd.quit();
    }

    public BoardHelper getBoard() {
        return board;
    }

    public SessionHelper getSession() {
        return session;
    }

    public TeamHelper getTeam() {
        return team;
    }
}
