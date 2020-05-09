package com.qa.trello.tests;

import org.testng.annotations.Test;

public class ProfileModificationTests extends TestBase {

    @Test
    public void testChangeProfileAvatar() throws InterruptedException {
        long beforeAvatarChanged = System.currentTimeMillis();
        app.getProfile().takeScreenshot(beforeAvatarChanged);
        app.getProfile().clickOnAvatar();
        app.getProfile().selectProfileAndVisibility();
        app.getProfile().initChangeProfilePhoto();
        app.getProfile().uploadPhoto();
        //app.getProfile().returnToHomePage();
        app.getProfile().refreshPage();
        long afterAvatarChanged = System.currentTimeMillis();
        app.getProfile().takeScreenshot(afterAvatarChanged);
        logger.info("screenshot before: screen " +beforeAvatarChanged+ ".png");
        logger.info("screenshot after: screen " +afterAvatarChanged+ ".png");



    }


//Assert.assertTrue.



}
