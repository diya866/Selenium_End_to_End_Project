package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilities {

    WebDriver driver;
    WebDriverWait wait;

    public Utilities(WebDriver driver) {
        this.driver = driver;

        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
    }

    public WebElement waitForVisibility(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickability(By locator) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void click(By locator) {

        waitForClickability(locator).click();
    }

    public void type(By locator,String text) {

        WebElement element =waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }
}