package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utilities;

public class SearchPage {

    WebDriver driver;
    Utilities utils;
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        utils = new Utilities(driver);
    }
    By dogsCategory = By.xpath("//img[contains(@src,'dogs')]");
    By dogProduct = By.linkText("K9-RT-01");
    By FemaleDog = By.xpath("//a[contains(text(),'EST')]");

    public void navigateToStore() {

        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
    }
    public void openDogsCategory() {
        try {
            utils.waitForClickability(dogsCategory).click();
            System.out.println("Dogs category opened");
        } catch (Exception e) {
            System.out.println("Failed to open Dogs category: " + e.getMessage());
        }
    }


    public void opendogProduct() {

        try {

            utils.waitForClickability(dogProduct).click();
            System.out.println("Dog product opened");

        } catch (Exception e) {

            System.out.println(
                    "Failed to open Bulldog product: " + e.getMessage()
            );
        }
    }


    public void openGoldenRetriever() {

        try {

            utils.waitForClickability(FemaleDog).click();
            System.out.println("Female Golden Retriever selected");

        } catch (Exception e) {

            System.out.println(
                    "Failed to select Female Golden Retriever: " + e.getMessage()
            );
        }
    }
}