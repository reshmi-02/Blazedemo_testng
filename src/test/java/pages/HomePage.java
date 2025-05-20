package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	 WebDriver driver;

	    private By fromDropdown = By.name("fromPort");
	    private By toDropdown = By.name("toPort");
	    private By findFlightsButton = By.xpath("//input[@type='submit']");
	    private By noFlightsMessage = By.xpath("//*[contains(text(), 'No flights available')]");

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void selectFromCity(String city) {
	        driver.findElement(fromDropdown).sendKeys(city);
	    }

	    public void selectToCity(String city) {
	        driver.findElement(toDropdown).sendKeys(city);
	    }

	    public void clickFindFlights() {
	        driver.findElement(findFlightsButton).click();
	    }

	    public boolean isCityPresentInFromDropdown(String city) {
	        return driver.findElement(fromDropdown).getText().contains(city);
	    }
	    
	    public boolean isCityPresentInToDropdown(String city) {
	        return driver.findElement(toDropdown).getText().contains(city);
	    }

	    public boolean isNoFlightsMessageDisplayed() {
	        return driver.findElements(noFlightsMessage).size() > 0;
	    }
}
