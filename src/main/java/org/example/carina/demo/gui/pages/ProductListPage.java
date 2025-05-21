package org.example.carina.demo.gui.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.carina.demo.gui.components.ProductListItemComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AbstractPage.class)
public class ProductListPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class,'app_logo')]")
    private ExtendedWebElement pageLogo;

    @FindBy(xpath = "//div[contains(@class,'inventory_item')]")
    private List<ProductListItemComponent> itemComponentList;

    public void addItemsToCart() {
        for (ProductListItemComponent item : itemComponentList) {
            item.addItemToCart();
        }
    }

    public ProductListPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageLogo);
    }
}
