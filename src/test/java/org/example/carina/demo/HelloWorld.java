package org.example.carina.demo;

import java.lang.invoke.MethodHandles;

import org.example.carina.demo.gui.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

/**
 * This is Hello World carina-demo tests.
 *
 * @author qpsdemo
 */

public class HelloWorld implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void login(){
       LoginPage loginPage=new LoginPage(getDriver());
       loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(),"There was a problem with opening the Login page");
    }
}
