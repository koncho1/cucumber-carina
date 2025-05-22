package org.example.carina.demo.gui.pages;


import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AbstractPage.class)
public class CheckoutOverviewPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(@class,'title')]")
    private ExtendedWebElement pageTitle;

    @FindBy(id = "finish")
    private ExtendedWebElement finishButton;

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
