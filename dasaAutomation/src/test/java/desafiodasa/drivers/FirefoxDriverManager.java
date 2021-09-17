package desafiodasa.drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

import desafiodasa.webDriver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();
    }
}
