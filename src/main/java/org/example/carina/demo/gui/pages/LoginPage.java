package org.example.carina.demo.gui.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AbstractPage.class)
public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class,'login_logo')]")
    private ExtendedWebElement loginLogo;

    @FindBy(id = "user-name")
    private ExtendedWebElement loginInput;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInput;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    public ProductListPage logIn(String login, String password) {
        loginInput.type(login);
        passwordInput.type(password);
        loginButton.click();
        return new ProductListPage(driver);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(loginLogo);
    }
}
