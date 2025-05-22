package org.example.carina.demo.gui.pages;


import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import io.cucumber.java.an.E;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AbstractPage.class)
public class CheckoutInformationPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(@class,'title')]")
    private ExtendedWebElement pageTitle;

    @FindBy(id = "first-name")
    private ExtendedWebElement firstNameField;

    @FindBy(id = "last-name")
    private ExtendedWebElement lastNameField;

    @FindBy(id = "postal-code")
    private ExtendedWebElement zipCodeField;

    @FindBy(id = "continue")
    private ExtendedWebElement continueButton;

    public CheckoutOverviewPage fillOutForm(String firstName, String lastName, String zipCode) {
        firstNameField.type(firstName);
        lastNameField.type(lastName);
        zipCodeField.type(zipCode);
        continueButton.click();
        return new CheckoutOverviewPage(driver);
    }

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageTitle);
    }
}
