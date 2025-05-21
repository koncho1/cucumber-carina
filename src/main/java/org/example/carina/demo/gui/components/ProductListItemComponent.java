package org.example.carina.demo.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductListItemComponent extends AbstractUIObject {

    @FindBy(xpath = "//div[contains(@class,'inventory_item_name')]")
    private ExtendedWebElement itemNameText;

    @FindBy(xpath = "//div[contains(@class,'inventory_item_price')]")
    private ExtendedWebElement itemPrice;

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    private ExtendedWebElement addToCartButton;

    public void addItemToCart() {
        addToCartButton.click();
    }

    public String getItemName() {
        return itemNameText.getText();
    }

    public ProductListItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }
}
