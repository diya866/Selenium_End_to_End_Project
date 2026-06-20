package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Utilities;


public class CartPage {

    WebDriver driver;
    Utilities utils;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.utils=new Utilities(driver);

    }

    By addToCart = By.linkText("Add to Cart");
    By quantityBox = By.name("EST-28");
    By updateCartButton = By.name("updateCartQuantities");
    By proceedCheckout = By.linkText("Proceed to Checkout");

    public void clickAddToCart() {

        utils.waitForClickability(addToCart).click();
    }

    public void updateQuantity(String qty) {

        utils.waitForVisibility(quantityBox);
        driver.findElement(quantityBox).clear();
        driver.findElement(quantityBox).sendKeys(qty);
        driver.findElement(updateCartButton).click();
    }

    public void proceedToCheckout() {

        utils.waitForClickability(proceedCheckout).click();
    }
}