package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {

	 WebDriver driver;

	    private By confirmationMessage = By.xpath("//*[contains(text(), 'Thank you for your purchase')]");

	    public ConfirmationPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public boolean isBookingConfirmed() {
	        return driver.findElements(confirmationMessage).size() > 0;
	    }
}
