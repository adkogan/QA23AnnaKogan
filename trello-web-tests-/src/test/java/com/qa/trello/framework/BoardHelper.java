package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public String createBoard(String nameOfBoard, String colorOfBoard) {
        click(By.name("add"));
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
        type(By.cssSelector("[data-test-id='create-board-title-input']"), nameOfBoard);
        click(By.cssSelector("button.W6rMLOx8U0MrPx")); //choose team
        click(By.xpath("//li[1]/button[@class='_2jR0BZMM5cBReR']"));
        click(By.cssSelector(colorOfBoard));
        click(By.cssSelector("[data-test-id= 'create-board-submit-button']"));
        waitForElement(By.className("mod-board-name"), 2);
        final String url = wd.getCurrentUrl();
        final int namePosition = url.lastIndexOf(nameOfBoard);
        if (namePosition>0) {
            return url.substring(0, namePosition-1);
        }
        return url;
    }

    public void permanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirm();
    }

    public void initBoardDeletionInMoreMenu() {
        clickCloseBoardFromMoreMenu();
        confirm();
    }

    public void clickCloseBoardFromMoreMenu() {
        click(By.cssSelector(".js-close-board"));
    }

    public void clickMoreButton() {
       // click(By.cssSelector(".js-open-more"));
        click(By.xpath("//li[contains(a/text(), 'More')]"));
    }

    public void openFirstPersonalBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

//    public void createBoard(){
//        initBoardCreation();
//        fillBoardForm("Test", "[title='blue']");
//        confirmBoardCreation();
//        returnToHomePage();
//    }


    public void changeName(String newName) {

//    //click on name
        wd.findElement(By.cssSelector(".js-rename-board")).click();
//    //type text and enter
        wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys(newName + Keys.ENTER);
        //type(By.cssSelector(".js-rename-board"), "ggg"+ Keys.ENTER);


    }

    public void goToBoardsPageUrl(String username){
        wd.navigate().to("https://trello.com/" +username+ "boards");

    }
    public boolean isOnBoardsPage() {
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }

    public void openBoardsPage() {
        click(By.cssSelector("[href$=boards]"));
    }

    public void openBoard() {

    }
}
