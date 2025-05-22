package org.example.carina.demo.gui.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.carina.demo.gui.components.ProductListItemComponent;
import org.example.carina.demo.gui.components.TopMenuComponent;
import org.example.carina.demo.models.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AbstractPage.class)
public class ProductListPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class,'app_logo')]")
    private ExtendedWebElement pageLogo;

    @FindBy(xpath = "//div[contains(@class, 'primary_header')]")
    private TopMenuComponent topMenuComponent;

    @FindBy(xpath = "//div[text()='%s']//..//..//..//button")
    private ExtendedWebElement itemComponent;


    public void addUserOrdersToCart(List<Order> listOfOrders) {
        for (Order order : listOfOrders) {
            ExtendedWebElement orderItemButton = itemComponent.format(order.getProductName());
            orderItemButton.click();
        }
    }

    public YourCartPage openYourCartPage() {
        return topMenuComponent.openYourCartPage();
    }

    public ProductListPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageLogo);
    }
}
