package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final boolean headless;
    String browser;
    WebDriver wd;
    BoardHelper board;
    TeamHelper team;
    SessionHelper session;
    ProfileHelper profile;
    LocalFileDetector fileDetector;


    public ApplicationManager(
            String browser,
            String headless
    ) {
        this.browser = browser;
        this.headless = "true".equals(headless);
    }

    public void init() throws InterruptedException {

        if (browser.equals(BrowserType.CHROME)) {
            ChromeOptions options = new ChromeOptions();
            if (headless) {
                options.addArguments("--no-sandbox"); //Bypass OS security model
                options.addArguments("--start-maximized");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--headless");
            }
            wd = new ChromeDriver(options);
        }
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }//if(browser.equals(BrowserType.EDGE)){
        //wd = new EdgeDriver();
        //  }



        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");




        session = new SessionHelper(wd);
        session.login("adkogan@gmail.com", "5605105zxc");
// Thread.sleep(2000);

        new WebDriverWait(wd, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test-id=header-member-menu-button]")));
        board = new BoardHelper(wd);
        team = new TeamHelper(wd);
        profile = new ProfileHelper(wd);



    }


    public boolean isOnBoardsPage() {
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }

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


    public ProfileHelper getProfile() {
        return profile;
    }
}
