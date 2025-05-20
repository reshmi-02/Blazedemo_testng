package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class BookingPage {
	private WebDriver driver;

    // Locators
    private By nameField = By.id("inputName");
    private By addressField = By.id("address");
    private By cityField = By.id("city");
    private By stateField = By.id("state");
    private By zipCodeField = By.id("zipCode");
    private By creditCardField = By.id("creditCardNumber");
    private By purchaseButton = By.cssSelector("input[type='submit']");
    private By backButton = By.cssSelector("button.back-button");
    private By errorMessage = By.cssSelector(".error-message");

    // Constructor
    public BookingPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void fillPassengerDetails(String name, String address, String city, String state, String zipCode, String creditCardNumber) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(creditCardField).sendKeys(creditCardNumber);
    }

    public void clickPurchaseButton() {
        driver.findElement(purchaseButton).click();
    }

    public void clickBackButton() {
        driver.findElement(backButton).click();
    }

    public boolean isErrorDisplayed() {
        WebElement errorElement = driver.findElement(errorMessage);
        return errorElement.isDisplayed();
    }
}
