package tests;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PetStoreTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(PetStoreTest.class);

    // Helper method to avoid repeating 3 lines every time
    private void passWithScreenshot(String message, String screenshotName) throws Exception {
        String path = ScreenshotUtil.captureScreenshot(driver, screenshotName);
        test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }

    @Test
    public void completeWorkflowTest() {
        test = extent.createTest("PetStore Complete Workflow");
        try {
            log.info("Test execution Started");
            test.info("Test execution Started");
            Thread.sleep(3000);

            // ───── REGISTRATION ─────
            RegistrationPage registrationPage = new RegistrationPage(driver);

            registrationPage.navigateToRegister();
            Thread.sleep(3000);
            log.info("Navigated to Registration Page");
            passWithScreenshot("Navigated to Registration Page", "01_NavigateToRegister");

            registrationPage.fillRegistrationForm();
            Thread.sleep(3000);
            log.info("Registration Form Filled");
            passWithScreenshot("Registration Form Filled", "02_FillRegistrationForm");

            registrationPage.handleDropdowns();
            Thread.sleep(3000);
            log.info("Dropdowns Handled");
            passWithScreenshot("Dropdowns Handled", "03_HandleDropdowns");

            registrationPage.handleCheckboxes(true, true);
            Thread.sleep(3000);
            log.info("Checkboxes Handled");
            passWithScreenshot("Checkboxes Handled", "04_HandleCheckboxes");

            registrationPage.scrollAndSave();
            Thread.sleep(3000);
            log.info("Registration Saved");
            passWithScreenshot("Registration Completed", "05_RegistrationSaved");

            registrationPage.loginAfterRegistration();
            Thread.sleep(3000);
            log.info("Login Completed");
            passWithScreenshot("Login Completed", "06_LoginAfterRegistration");

            // ───── SEARCH / PRODUCT SELECTION ─────
            SearchPage searchPage = new SearchPage(driver);

            searchPage.navigateToStore();
            Thread.sleep(3000);
            log.info("Navigated to Store");
            passWithScreenshot("Navigated to Store", "07_NavigateToStore");

            searchPage.openDogsCategory();
            Thread.sleep(3000);
            log.info("Dogs Category Opened");
            passWithScreenshot("Dogs Category Opened", "08_OpenDogsCategory");

            searchPage.opendogProduct();
            Thread.sleep(3000);
            log.info("Dog Product Opened");
            passWithScreenshot("Dog Product Opened", "09_OpenDogProduct");

            searchPage.openGoldenRetriever();
            Thread.sleep(3000);
            log.info("Golden Retriever Selected");
            passWithScreenshot("Golden Retriever Selected", "10_OpenGoldenRetriever");

            // ───── CART ─────
            CartPage cartPage = new CartPage(driver);

            cartPage.clickAddToCart();
            Thread.sleep(3000);
            log.info("Product Added to Cart");
            passWithScreenshot("Product Added to Cart", "11_AddToCart");

            cartPage.updateQuantity("4");
            Thread.sleep(3000);
            log.info("Quantity Updated");
            passWithScreenshot("Cart Quantity Updated to 4", "12_UpdateQuantity");

            Assert.assertTrue(driver.getPageSource().contains("Shopping Cart"));
            log.info("Cart Verification Passed");
            passWithScreenshot("Cart Verification Passed", "13_CartVerification");

            // ───── CHECKOUT ─────
            CheckoutPage checkoutPage = new CheckoutPage(driver);

            checkoutPage.proceedCheckout();
            Thread.sleep(3000);
            log.info("Checkout Started");
            passWithScreenshot("Proceeded to Checkout", "14_ProceedCheckout");

            checkoutPage.fillBillingDetails();
            Thread.sleep(3000);
            log.info("Billing Details Filled");
            passWithScreenshot("Billing Details Filled", "15_FillBillingDetails");

            checkoutPage.fillShippingDetails();
            Thread.sleep(3000);
            log.info("Shipping Details Filled");
            passWithScreenshot("Shipping Details Filled", "16_FillShippingDetails");

            checkoutPage.confirmOrder();
            Thread.sleep(3000);
            log.info("Order Confirmed");
            passWithScreenshot("Order Confirmed", "17_ConfirmOrder");

            Assert.assertTrue(driver.getPageSource().contains("Thank you"));
            log.info("Order Success Verified");
            passWithScreenshot("Order Success - Thank You Page", "18_OrderSuccess");

            // ───── POST-ORDER ─────
            checkoutPage.returnToMainMenu();
            Thread.sleep(3000);
            log.info("Returned to Main Menu");
            passWithScreenshot("Returned to Main Menu", "19_ReturnToMainMenu");

            checkoutPage.openMyOrders();
            Thread.sleep(3000);
            log.info("My Orders Opened");
            passWithScreenshot("My Orders Page Opened", "20_OpenMyOrders");

            checkoutPage.openLatestOrder();
            Thread.sleep(3000);
            log.info("Latest Order Opened");
            passWithScreenshot("Latest Order Opened", "21_OpenLatestOrder");

            checkoutPage.zoomPage();
            Thread.sleep(1000);
            passWithScreenshot("Order Invoice (Zoomed)", "22_OrderInvoice");

            checkoutPage.returnToMainMenu();
            Thread.sleep(3000);
            log.info("Returned to Main Menu from Orders");
            passWithScreenshot("Returned to Main Menu from Orders", "23_ReturnFromOrders");

            // ───── SIGN OUT ─────
            checkoutPage.signOut();
            Thread.sleep(3000);
            log.info("Sign Out Successful");
            passWithScreenshot("Sign Out Successful", "24_SignOut");

            log.info("Workflow Completed Successfully");
            test.log(Status.PASS, "PetStore Complete Workflow Passed");

        } catch (Exception e) {
            log.error("Workflow Failed: " + e.getMessage());
            String failurePath = ScreenshotUtil.captureScreenshot(driver, "WorkflowFailure");
            test.fail("Workflow Failed: " + e.getMessage(),
                    MediaEntityBuilder.createScreenCaptureFromPath(failurePath).build());
            Assert.fail("Workflow Failed: " + e.getMessage());
        }
    }
}
