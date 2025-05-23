package org.example.carina.demo.gui.pages;


import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.carina.demo.models.Order;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AbstractPage.class)
public class CheckoutOverviewPage extends AbstractPage {


    private static final int TIMEOUT_TIME = 3;

    @FindBy(xpath = "//span[contains(@class,'title')]")
    private ExtendedWebElement pageTitle;

    @FindBy(id = "finish")
    private ExtendedWebElement finishButton;

    @FindBy(xpath = "//div[text()='%s']")
    private ExtendedWebElement itemComponent;

    public boolean areAllOrdersCorrect(List<Order> listOfOrders) {
        for (Order order : listOfOrders) {
            if (!itemComponent.format(order.getProductName()).isElementPresent(TIMEOUT_TIME)) {
                throw new NotFoundException("Order for " + order.getProductName() + " was not found");
            }
        }
        return true;
    }

    public CheckoutCompletePage finishOrdering() {
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }
}
