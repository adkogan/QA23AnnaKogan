package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileModificationTests extends TestBase {

    @Test
    public void testChangeProfileAvatar() throws InterruptedException {

        app.getProfile().clickOnAvatar();
        app.getProfile().selectProfileAndVisibility();
        app.getProfile().initChangeProfilePhoto();
        app.getProfile().uploadPhoto();

    }


//Assert.assertTrue.



}
