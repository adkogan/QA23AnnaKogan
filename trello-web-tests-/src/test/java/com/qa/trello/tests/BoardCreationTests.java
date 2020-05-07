
package com.qa.trello.tests;

import com.qa.trello.model.Board;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {

        if (!app.getBoard().isOnBoardsPage()) {
            app.getBoard().goToBoardsPageUrl("annakogan6");
            // app.getBoard().click(By.cssSelector("[href$=boards]"));
        }
    }



    @DataProvider
    public Iterator<Object[]> validBoards() throws IOException {
//        List<Object[]> list = new ArrayList<>();
//        BufferedReader reader =
//                new BufferedReader(new FileReader(new File("src/test/resources/boards.csv")));
//
//        String line;
//        while ((line = reader.readLine()) != null) {
//            String[] split = line.split(";");
//            list.add(new Object[]{new Board().withName(split[0]).withTeam(split[1]).withColor(split[2])});
//        }
//        return list.iterator();

        return Files.lines(
            new File("src/test/resources/boards.csv").toPath()
        )
            .map(line -> {
                String[] split = line.split(";");
                return new Object[]{new Board()
                        .withName(split[0])
                        .withTeam(split[1])
                        .withColor(split[2])
                };
            })
            .iterator();
    }


    @Test(dataProvider = "validBoards")
    public void testBoardCreation(Board board) throws InterruptedException {
        int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app.getBoard().fillBoardForm(board);
        app.getBoard().confirmBoardCreation();
        app.getBoard().returnToHomePage();
        int after = app.getBoard().getBoardsCount();

        Assert.assertEquals(after, before + 1);

    }


}

//    @DataProvider
//    public Iterator<Object[]> validBoardsEasy() throws IOException {
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"aa", "No team", "red"});
//        list.add(new Object[]{"sdfg", "No team", "blue"});
//        list.add(new Object[]{"vv", "No team", "orange"});
//        return list.iterator();
//    }

//    @Test(dataProvider = "validBoardsEasy")
//    public void testBoardCreation(String boardName, String boardTeam, String color) {
//
//        Board board = new Board().withName(boardName).withTeam(boardTeam).withColor(color);
//
//        int before = app.getBoard().getBoardsCount();
//        app.getBoard().initBoardCreation();
//        app.getBoard().fillBoardForm(board);
//        app.getBoard().confirmBoardCreation();
//        app.getBoard().returnToHomePage();
//        int after = app.getBoard().getBoardsCount();
//        Assert.assertEquals(after, before + 1);
//
//
// }



//old version
//    @Test
//    public void testBoardCreation() {
//        int before = app.getBoard().getBoardsCount();
//        app.getBoard().initBoardCreation();
//        app.getBoard().fillBoardForm(
//                new Board()
//                        .withName("Test " + System.currentTimeMillis())
//                        .withTeam("No team")
//                        .withColor("red"));
//        app.getBoard().confirmBoardCreation();
//        app.getBoard().returnToHomePage();
//        int after = app.getBoard().getBoardsCount();
//
//        Assert.assertEquals(after, before + 1);
//
//    }