package org.example.carina.demo.cucumber.steps;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.zebrunner.carina.core.AbstractTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.ibatis.session.SqlSession;
import org.example.carina.demo.MyBatisService;
import org.example.carina.demo.gui.pages.*;
import org.example.carina.demo.mappers.OrderMapper;
import org.example.carina.demo.mappers.UserMapper;
import org.example.carina.demo.models.Order;
import org.example.carina.demo.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


public class StepsDefinitions extends AbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private User user;

    private List<Order> listOfOrders;

    @Given("user {string} logs in with valid credentials")
    public void user_logs_in_with_valid_credentials(String username) {
        SqlSession session = MyBatisService.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        user = userMapper.findByUserName(username);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "There was a problem with opening the Login page");
        ProductListPage productListPage = loginPage.logIn(user.getUserName(), user.getPassword());
        Assert.assertTrue(productListPage.isPageOpened(), "There was a problem with opening the Product list page");
    }

    @And("adds products to cart")
    public void adds_products_to_cart() {
        SqlSession session = MyBatisService.getSession();
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        listOfOrders = orderMapper.getOrdersByUserId(user.getId());
        ProductListPage productListPage = new ProductListPage(getDriver());
        productListPage.addUserOrdersToCart(listOfOrders);
        productListPage.openYourCartPage();
    }

    @And("finishes checkout")
    public void finishes_checkout() {
        YourCartPage yourCartPage = new YourCartPage(getDriver());
        Assert.assertTrue(yourCartPage.isPageOpened(), "There was a problem with opening Your Cart page");
        CheckoutInformationPage checkoutInformationPage = yourCartPage.goToCheckoutInformationPage();
        Assert.assertTrue(checkoutInformationPage.isPageOpened(), "There was a problem with opening Checkout Information page");
        CheckoutOverviewPage checkoutOverviewPage = checkoutInformationPage.fillOutForm(user.getFirstName(), user.getLastName(), user.getZipCode());
        Assert.assertTrue(checkoutOverviewPage.isPageOpened(), "There was a problem with opening Checkout Overview page");
        Assert.assertTrue(checkoutOverviewPage.areAllOrdersCorrect(listOfOrders));
        checkoutOverviewPage.finishOrdering();
    }

    @Then("checkout is succesful")
    public void checkout_is_successful() {
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(getDriver());
        Assert.assertTrue(checkoutCompletePage.isPageOpened(), "There was a problem with opening Checkout Complete page");
    }


}
