package com.qa.trello.framework;

import com.qa.trello.framework.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {


    public SessionHelper(WebDriver wd) {

        super(wd);
    }


    public void initLogin() {
        click(By.cssSelector("a[href*='login']"));
    }

    public void fillLoginForm(String userEmail, String password) {
        initLogin();
        type(By.name("user"), userEmail);
        type(By.cssSelector("input#password"), password);
        click(By.cssSelector("#login.button-green"));
        confirmLogin();
    }

    public void confirmLogin() {
        click(By.id("login"));
    }



}
