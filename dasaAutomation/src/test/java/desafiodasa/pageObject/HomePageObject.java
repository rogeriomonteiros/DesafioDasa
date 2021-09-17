package desafiodasa.pageObject;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class HomePageObject {

	private WebDriver driver;
	private String menu = "//div[contains(@class,'eWFgbM')]//a[@label='Somos Dasa']/div";
	private String ourBrandsMenuItem = "//a[@label='Nossas Marcas']";

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void mouseOverMenuSomosDasa() {
		WebElement menuElement = driver.findElement(By.xpath(menu));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(menuElement));
	}

	public void clickOnOurBrands() {
		WebElement ourBrandsSelect = driver.findElement(By.xpath(ourBrandsMenuItem));
		WebElement menuElement = driver.findElement(By.xpath(menu));
		Actions action = new Actions(driver);
		action.moveToElement(menuElement).moveToElement(ourBrandsSelect).click().perform();
	}
}
