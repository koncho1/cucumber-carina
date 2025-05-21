package org.example.carina.demo;

import java.lang.invoke.MethodHandles;

import org.apache.ibatis.session.SqlSession;
import org.example.carina.demo.gui.pages.LoginPage;
import org.example.carina.demo.gui.pages.ProductListPage;
import org.example.carina.demo.mappers.UserMapper;
import org.example.carina.demo.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;


public class HelloWorld implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private User user;

    @Test
    public void login() {
        SqlSession session = MyBatisService.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        user = userMapper.findByUserName("standard_user");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "There was a problem with opening the Login page");
        ProductListPage productListPage = loginPage.logIn(user.getUserName(), user.getPassword());
        Assert.assertTrue(productListPage.isPageOpened(), "There was a problem with opening the Product list page");
        //productListPage.addItemsToCart();
    }

}
