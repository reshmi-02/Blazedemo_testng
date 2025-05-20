package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class FlightSearchPage {
	 WebDriver driver;

	    private By chooseFlightButton = By.xpath("//input[@value='Choose This Flight']");

	    public FlightSearchPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void chooseFlight() {
	        driver.findElement(chooseFlightButton).click();
	    }
	
}
