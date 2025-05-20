package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
	
	 public WebDriver driver;
	    public Properties properties;

	    public void loadProperties() throws IOException {
	        properties = new Properties();
	        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
	        properties.load(fis);
	    }

	    public void initializeDriver() throws IOException {
	        loadProperties();
	        String browser = properties.getProperty("browser");

	        if (browser.equalsIgnoreCase("chrome")) {
	           driver = new ChromeDriver();
	       
	        }
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    public void navigateToHomePage() {
	        driver.get(properties.getProperty("url"));
	    }

	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
}
