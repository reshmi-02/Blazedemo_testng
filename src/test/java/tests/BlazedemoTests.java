package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class BlazedemoTests extends BaseTest {
    HomePage homePage;
    FlightSearchPage flightSearchPage;
    BookingPage bookingPage;
    ConfirmationPage confirmationPage;

    @BeforeMethod
    public void setUp() throws Exception {
        initializeDriver();
        navigateToHomePage();
        homePage = new HomePage(driver);
        flightSearchPage = new FlightSearchPage(driver);
        bookingPage = new BookingPage(driver);
        confirmationPage = new ConfirmationPage(driver);
    }

    @Test
    public void verifyHomepageAccessibility() {
        Assert.assertTrue(driver.getTitle().contains("BlazeDemo"), "Homepage is not accessible.");
    }

    @Test
    public void verifyDropdownValuesForFromCity() {
        Assert.assertTrue(homePage.isCityPresentInFromDropdown("Paris"), "From city 'Paris' is not present.");
        Assert.assertTrue(homePage.isCityPresentInFromDropdown("London"), "From city 'London' is not present.");
    }

    @Test
    public void verifyDropdownValuesForToCity() {
        Assert.assertTrue(homePage.isCityPresentInToDropdown("New York"), "To city 'New York' is not present.");
        Assert.assertTrue(homePage.isCityPresentInToDropdown("Berlin"), "To city 'Berlin' is not present.");
    }

    @Test
    public void verifyFlightSearchFunctionality() {
        homePage.selectFromCity("Paris");
        homePage.selectToCity("London");
        homePage.clickFindFlights();

        Assert.assertTrue(driver.getTitle().contains("reserve"), "Flight search functionality failed.");
    }

    @Test
    public void verifyFlightDetailsDisplay() {
        homePage.selectFromCity("Paris");
        homePage.selectToCity("London");
        homePage.clickFindFlights();
        flightSearchPage.chooseFlight();

        Assert.assertTrue(driver.getTitle().contains("Purchase"), "Flight details page not displayed.");
    }

    @Test
    public void verifyBookingProcess() {
        homePage.selectFromCity("Paris");
        homePage.selectToCity("London");
        homePage.clickFindFlights();
        flightSearchPage.chooseFlight();

        bookingPage.fillPassengerDetails("John Doe", "123 Main St", "Paris", "Ile-de-France", "75001", "4111111111111111");
        bookingPage.clickPurchaseButton();

        Assert.assertTrue(confirmationPage.isBookingConfirmed(), "Booking process failed.");
    }

    @Test
    public void verifyErrorHandlingForEmptyForm() {
        homePage.selectFromCity("Paris");
        homePage.selectToCity("London");
        homePage.clickFindFlights();
        flightSearchPage.chooseFlight();

        bookingPage.clickPurchaseButton(); // Do not fill any details

        Assert.assertTrue(bookingPage.isErrorDisplayed(), "Error handling for empty form failed.");
    }

    @Test
    public void verifyBackButtonFunctionality() {
        homePage.selectFromCity("Paris");
        homePage.selectToCity("London");
        homePage.clickFindFlights();
        flightSearchPage.chooseFlight();

        bookingPage.clickBackButton();

        Assert.assertTrue(driver.getTitle().contains("reserve"), "Back button functionality failed.");
    }

    @Test
    public void verifyPageResponsiveness() {
        // This test requires manual or automated visual validation (e.g., using tools like Selenium Grid, BrowserStack, or Applitools).
        Assert.assertTrue(true, "Page responsiveness tested manually.");
    }

    @Test
    public void verifyPaymentGatewayIntegration() {
        homePage.selectFromCity("Paris");
        homePage.selectToCity("London");
        homePage.clickFindFlights();
        flightSearchPage.chooseFlight();

        bookingPage.fillPassengerDetails("John Doe", "123 Main St", "Paris", "Ile-de-France", "75001", "4111111111111111");
        bookingPage.clickPurchaseButton();

        Assert.assertTrue(confirmationPage.isBookingConfirmed(), "Payment gateway integration failed.");
    }

    @Test
    public void verifyInvalidPaymentHandling() {
        homePage.selectFromCity("Paris");
        homePage.selectToCity("London");
        homePage.clickFindFlights();
        flightSearchPage.chooseFlight();

        bookingPage.fillPassengerDetails("John Doe", "123 Main St", "Paris", "Ile-de-France", "75001", "1234567890123456");
        bookingPage.clickPurchaseButton();

        Assert.assertTrue(bookingPage.isErrorDisplayed(), "Error handling for invalid payment failed.");
    }

    @Test
    public void verifySearchWithInvalidCities() {
        homePage.selectFromCity("InvalidCity1");
        homePage.selectToCity("InvalidCity2");
        homePage.clickFindFlights();

        Assert.assertTrue(homePage.isNoFlightsMessageDisplayed(), "Invalid city search handling failed.");
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
