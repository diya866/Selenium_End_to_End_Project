package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.UUID;

public class RegistrationPage {

    WebDriver driver;
    String uniqueUser = "diya" + UUID.randomUUID().toString().substring(0,5);

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    By enterStore = By.linkText("Enter the Store");
    By signIn = By.linkText("Sign In");
    By registerNow = By.linkText("Register Now!");
    By username = By.name("username");
    By password = By.name("password");
    By repeatedPassword = By.name("repeatedPassword");
    By firstName = By.name("account.firstName");
    By lastName = By.name("account.lastName");
    By email = By.name("account.email");
    By phone = By.name("account.phone");
    By address1 = By.name("account.address1");
    By city = By.name("account.city");
    By state = By.name("account.state");
    By zip = By.name("account.zip");
    By country = By.name("account.country");
    By languagePreference = By.name("account.languagePreference");
    By favouriteCategory = By.name("account.favouriteCategoryId");
    By myList = By.name("account.listOption");
    By myBanner = By.name("account.bannerOption");
    By saveAccount = By.name("newAccount");

    public void navigateToRegister() {

        driver.findElement(enterStore).click();
        driver.findElement(signIn).click();
        driver.findElement(registerNow).click();
    }
    public void fillRegistrationForm() {

        driver.findElement(username).sendKeys(uniqueUser);
        driver.findElement(password).sendKeys("Test@123");
        driver.findElement(repeatedPassword).sendKeys("Test@123");
        driver.findElement(firstName).sendKeys("Diya");
        driver.findElement(lastName).sendKeys("B");
        driver.findElement(email).sendKeys("diya@test.com");
        driver.findElement(phone).sendKeys("9876543210");
        driver.findElement(address1).sendKeys("Mugalivakam");
        driver.findElement(city).sendKeys("Chennai");
        driver.findElement(state).sendKeys("Tamil Nadu");
        driver.findElement(zip).sendKeys("600001");
        driver.findElement(country).sendKeys("India");
    }
    public void handleDropdowns() {

        Select language = new Select(driver.findElement(languagePreference));
        language.selectByVisibleText("english");
        Select category = new Select(driver.findElement(favouriteCategory));
        category.selectByVisibleText("DOGS");
    }

    public void handleCheckboxes(boolean enableList, boolean enableBanner) {

        if(enableList) {

            driver.findElement(myList).click();
        }

        if(enableBanner) {

            driver.findElement(myBanner).click();
        }
    }

    public void scrollAndSave() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(saveAccount).click();

    }
    By usernameLogin = By.name("username");
    By passwordLogin = By.name("password");
    By loginButton = By.name("signon");

    public void loginAfterRegistration() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(usernameLogin).clear();
        driver.findElement(usernameLogin).sendKeys(uniqueUser);
        driver.findElement(passwordLogin).clear();
        driver.findElement(passwordLogin).sendKeys("Test@123");
        driver.findElement(loginButton).click();
        System.out.println("Login Successful");
    }
}