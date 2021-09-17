package desafiodasa.webDriver;


import desafiodasa.drivers.ChromeDriverManager;
import desafiodasa.drivers.FirefoxDriverManager;

public class DriverManagerFactory {

    public static DriverManager getManager(WebDrivers type) {
        DriverManager driverManager;

        switch (type) {
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
