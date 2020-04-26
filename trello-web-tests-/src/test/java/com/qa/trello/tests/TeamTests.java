package com.qa.trello.tests;

import com.qa.trello.framework.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class TeamTests extends TestBase {

    static String nameOfTeam;
    static String teamUrl;
    static WebDriverWait wait;


    public static String getRandomString() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


    @Test
    public void teamCreation() throws InterruptedException {

        nameOfTeam = getRandomString();
        app.getTeam().initTeamCreation();
        app.getTeam().fillTeamForm(nameOfTeam);
        app.getTeam().inviteTeamLater();
        teamUrl = app.getTeam().confirmTeamCreation();

        wait = new WebDriverWait(app.wd,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'js-current-details']//h1")));
        final WebElement element = app.wd.findElement(By.xpath("//div[@class = 'js-current-details']//h1"));

        //Thread.sleep(1000);
        Assert.assertEquals(
                element.getText(),
                nameOfTeam
      );
    }

    @Test(dependsOnMethods = "teamCreation")
    public void teamModification() throws InterruptedException {
        app.wd.navigate().to(teamUrl);
        nameOfTeam =getRandomString();
        app.getTeam().changeTeamName(nameOfTeam);

        wait = new WebDriverWait(app.wd,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'js-current-details']//h1")));
        final WebElement element = app.wd.findElement(By.xpath("//div[@class = 'js-current-details']//h1"));
        //Thread.sleep(1000);

        Assert.assertEquals(
                element.getText(),
                nameOfTeam
        );
    }


    @Test(dependsOnMethods = "teamCreation")
    public void teamDeletion() {


        wait = new WebDriverWait(app.wd,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'js-current-details']//h1")));
        final WebElement element = app.wd.findElement(By.xpath("//div[@class = 'js-current-details']//h1"));
        Assert.assertEquals(
                element.getText(),
                nameOfTeam
        );


        app.wd.navigate().to(teamUrl);
        app.getTeam().clickSettingsButton();
        app.getTeam().initTeamDeletionInMoreMenu();
        app.getTeam().permanentlyDeleteTeam();




        Assert.assertTrue(app.wd.findElements(By.xpath("//div[@class = 'js-current-details']//h1")).isEmpty());


    }


}
