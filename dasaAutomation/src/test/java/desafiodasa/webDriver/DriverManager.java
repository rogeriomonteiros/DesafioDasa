package desafiodasa.webDriver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

	protected WebDriver driver;
    protected abstract void createDriver();

    public WebDriver openWebDriver() {
        
    	if (this.driver == null) {
            createDriver();
        }
    	
        return this.driver;
    }
    
    public void closeWebDriver() {
    	
    	if (this.driver != null) {
    		this.driver.quit();
    	}
    	
    	this.driver = null;
    }
}
