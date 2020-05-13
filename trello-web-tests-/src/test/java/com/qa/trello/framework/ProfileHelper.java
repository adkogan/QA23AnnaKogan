package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.io.File;


public class ProfileHelper extends HelperBase {



    public ProfileHelper(WebDriver wd) {
        super(wd);
    }

    public void clickOnAvatar() {
      // waitForElementLocatedAndClick(By.cssSelector("[data-test-id=header-member-menu-button]"),20);
        click(By.cssSelector("[data-test-id=header-member-menu-button]"));
    }

    public void selectProfileAndVisibility() {
        click(By.cssSelector("[data-test-id=header-member-menu-profile]"));
    }

//    public void goToAtlassianProfile(){
//        String trello = wd.getWindowHandle();
//        System.out.println(trello);
//        click(By.cssSelector("a[href$=manage-profile]"));
//        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
//        if(!availableWindows.isEmpty()){
//            wd.switchTo().window(availableWindows.get(1));
//        }
//        String atlassianAcc = wd.getWindowHandle();
//        System.out.println(atlassianAcc);
//
//    }

    public void initChangeProfilePhoto(){
//        WebElement avatar = wd.findElement(By.cssSelector(".rsiNque2CCqtPE"));
//      //WebElement avatar = wd.findElement(By.xpath("//*[contains(text(), 'Change Avatar')]"));
//        new Actions(wd).moveToElement(avatar).perform();
//        //click(By.cssSelector("[data-test-selector=trigger-avatar-picker"]));
//       click(By.xpath("//*[contains(text(), 'Change Avatar')]"));
       click(By.cssSelector(".rsiNque2CCqtPE"));
    }

    public void uploadPhoto() throws InterruptedException {
        //attachFile(By.cssSelector("button#image-input") - no such element on my version
        attachFile(
                By.xpath("//input[@type='file']"),
                new File("/home/adkogan/git/QA23Trello-original/trello-web-tests-/src/test/resources/catPic.png")
        );
        Thread.sleep(3000);
        click(By.xpath("//*[contains(text(), 'Upload')]"));
        Thread.sleep(2000);
    }

    public void attachFile(By locator, File file){
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public boolean avatarAdded(){
        return isElementPresent(By.xpath("//*[contains(text(), 'Avatar added']"));
    }


    public void choseNoAvatar() {
        click(By.xpath("//button[contains(text(), 'Initials (no avatar)')]"));
    }
}
