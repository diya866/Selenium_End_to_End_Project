package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utilities;
import java.time.Duration;

import utils.Utilities;

public class CheckoutPage {

    WebDriver driver;
    Utilities util;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.util=new Utilities(driver);
    }


    By checkout = By.linkText("Proceed to Checkout");
    By cardType = By.name("order.cardType");
    By creditCard = By.name("order.creditCard");
    By expiryDate = By.name("order.expiryDate");
    By billFirstName = By.name("order.billToFirstName");
    By billLastName = By.name("order.billToLastName");
    By billAddress1 = By.name("order.billAddress1");
    By billCity = By.name("order.billCity");
    By billState = By.name("order.billState");
    By billZip = By.name("order.billZip");
    By billCountry = By.name("order.billCountry");
    By differentShipping = By.name("shippingAddressRequired");
    By continueBtn = By.name("newOrder");
    By shipFirstName = By.name("order.shipToFirstName");
    By shipLastName = By.name("order.shipToLastName");
    By shipAddress1 = By.name("order.shipAddress1");
    By shipCity = By.name("order.shipCity");
    By shipState = By.name("order.shipState");
    By shipZip = By.name("order.shipZip");
    By shipCountry = By.name("order.shipCountry");
    By continueShipping = By.name("newOrder");
    By confirmBtn = By.linkText("Confirm");
    By returnMainMenu = By.linkText("Return to Main Menu");
    By myAccount = By.linkText("My Account");
    By myOrders= By.linkText("My Orders");
    By signOut = By.linkText("Sign Out");


    public void proceedCheckout() {

        driver.findElement(checkout).click();
    }

    public void fillBillingDetails() {

        driver.findElement(creditCard).clear();
        driver.findElement(creditCard).sendKeys("4111111111111111");

        driver.findElement(expiryDate).clear();

        driver.findElement(expiryDate).sendKeys("12/2030");

        driver.findElement(billFirstName).clear();

        driver.findElement(billFirstName).sendKeys("Diya");

        driver.findElement(billLastName).clear();

        driver.findElement(billLastName).sendKeys("B");

        driver.findElement(billAddress1).clear();

        driver.findElement(billAddress1).sendKeys("Whitefield");

        driver.findElement(billCity).clear();

        driver.findElement(billCity).sendKeys("Bangalore");
        driver.findElement(billState).clear();
        driver.findElement(billState).sendKeys("KA");
        driver.findElement(billZip).clear();
        driver.findElement(billZip).sendKeys("560066");
        driver.findElement(billCountry).clear();
        driver.findElement(billCountry).sendKeys("India");
        driver.findElement(differentShipping).click();
        driver.findElement(continueBtn).click();
    }

    public void fillShippingDetails() {

        driver.findElement(shipFirstName).clear();
        driver.findElement(shipFirstName).sendKeys("Diya");
        driver.findElement(shipLastName).clear();
        driver.findElement(shipLastName).sendKeys("B");
        driver.findElement(shipAddress1).clear();
        driver.findElement(shipAddress1).sendKeys("Marathahalli");
        driver.findElement(shipCity).clear();
        driver.findElement(shipCity).sendKeys("Bangalore");
        driver.findElement(shipState).clear();
        driver.findElement(shipState).sendKeys("KA");
        driver.findElement(shipZip).clear();
        driver.findElement(shipZip).sendKeys("560037");
        driver.findElement(shipCountry).clear();
        driver.findElement(shipCountry).sendKeys("India");
        driver.findElement(continueShipping).click();
    }

    public void confirmOrder() {

        driver.findElement(confirmBtn).click();
    }

    public void returnToMainMenu() {

        driver.findElement(returnMainMenu).click();

    }


    public void openMyOrders() {

        util.waitForVisibility(myAccount).click();

        util.waitForVisibility(myOrders).click();
    }

    public void openLatestOrder() {

        driver.findElement(By.xpath("//table//tr[2]//a")).click();

    }
    public void zoomPage() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        ((JavascriptExecutor) driver)
                .executeScript("document.body.style.zoom='80%'");
    }

    public void signOut() {

        util.waitForClickability(signOut).click();
    }
}