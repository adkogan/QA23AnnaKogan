package com.qa.trello.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class BoardTests extends TestBase {

    static String nameOfBoard;
    static String boardUrl;

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
    public void boardCreation() {
        nameOfBoard = getRandomString();
        boardUrl= app.getBoard().createBoard(nameOfBoard, "[title='blue']");

        final WebElement element = app.wd.findElement(By.className("mod-board-name"));
        Assert.assertEquals(
                element.getText(),
                nameOfBoard
        );


    }

    @Test(dependsOnMethods = "boardCreation")
    public void boardModification() {
        app.wd.navigate().to(boardUrl);

        nameOfBoard = getRandomString();
        app.getBoard().changeName(nameOfBoard);


        final WebElement element = app.wd.findElement(By.className("mod-board-name"));
        Assert.assertEquals(
                element.getText(),
                nameOfBoard
        );

    }

    @Test(dependsOnMethods = "boardCreation", priority = 100)
    public void boardDeletion() {

        final WebElement element = app.wd.findElement(By.className("mod-board-name"));
        Assert.assertEquals(
                element.getText(),
                nameOfBoard);
        app.wd.navigate().to(boardUrl);
        app.getBoard().clickMoreButton();
        app.getBoard().initBoardDeletionInMoreMenu();
        app.getBoard().permanentlyDeleteBoard();


      Assert.assertTrue(app.wd.findElements(By.className("mod-board-name")).isEmpty());





    }

}
