package desafiodasa.steps;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import desafiodasa.pageObject.HomePageObject;
import desafiodasa.pageObject.OurBrandsPageObject;
import desafiodasa.webDriver.DriverManager;
import desafiodasa.webDriver.DriverManagerFactory;
import desafiodasa.webDriver.WebDrivers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChallengeSteps {

	private WebDriver driver;
	private HomePageObject homePageObject;
	private OurBrandsPageObject ourBrandsPageObject;
	
	DriverManager driverManager;

	@Before
	public void setup() {
		this.driverManager = DriverManagerFactory.getManager(WebDrivers.CHROME);
		this.driver = this.driverManager.openWebDriver();
		this.homePageObject = new HomePageObject(driver);
		this.ourBrandsPageObject = new OurBrandsPageObject(driver);
	}

	@After
	public void teardown() {
		this.driverManager.closeWebDriver();
	}
	
	@Given("I Navigate To {string}")
	public void navigateToDasaPage(String url) throws InterruptedException {
		this.driver.get(url);
	}

	@Given("I Navigate To Our Brands Page")
	public void navigateToCompaniesPage() throws InterruptedException {
		homePageObject.mouseOverMenuSomosDasa();
		homePageObject.clickOnOurBrands();
	}

	@When("I Select {string} Region")
	public void selectRegion(String option) throws InterruptedException {
		ourBrandsPageObject.selectOption(option);
	}

	@Then("I Print Filtered Labs On Console")
	public void printCompaniesURL() throws InterruptedException {
		for (WebElement brand : ourBrandsPageObject.getLabs()) {
			System.out.println(brand.getAttribute("href"));
		}
	}

	@When("I Select {string} Lab")
	public void selectCompany(String url) throws InterruptedException {
		ourBrandsPageObject.selectLabByUrl(url);
	}

	@Then("I Verify If I Navigated To {string}")
	public void verifyLink(String url) throws InterruptedException {
		List<String> companyTab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(companyTab.get(1));
		assert (url.equals(driver.getCurrentUrl()));
	}
}
