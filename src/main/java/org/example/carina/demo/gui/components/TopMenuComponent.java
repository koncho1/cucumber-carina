package org.example.carina.demo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.example.carina.demo.gui.pages.YourCartPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopMenuComponent extends AbstractUIObject {

    @FindBy(xpath = ".//a[contains(@class,'shopping_cart_link')]")
    private ExtendedWebElement cartButton;

    public YourCartPage openYourCartPage() {
        cartButton.click();
        return new YourCartPage(driver);
    }

    public TopMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
