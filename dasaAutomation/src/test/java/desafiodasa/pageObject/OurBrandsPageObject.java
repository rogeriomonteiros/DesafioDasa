package desafiodasa.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OurBrandsPageObject {

	private WebDriver webDriver;
	private final String REGION_SELECT = "//select[@name='locations']";
	private final String REGION_OPTION = "//h3[text()='São Paulo']";
	private final String LAB_LIST = "//picture//ancestor::div[@tabindex=0]/a";
	private String labLink = "//picture//ancestor::div[@tabindex=0]/a[contains(@href,\'{0}\')]";
	
	@FindBy(xpath = REGION_SELECT)
    private WebElement regionoSelect;
	
	@FindBy(xpath =  REGION_OPTION)
	private WebElement saoPauloHeader;
	
	@FindBy(xpath =  LAB_LIST)
	private List<WebElement> labs;

	public OurBrandsPageObject(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public List<WebElement> getLabs() {
		return labs;
	}
	
	public void selectLabByUrl(String url) {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", saoPauloHeader);
		WebElement lab = webDriver.findElement(By.xpath(labLink.replace("{0}", url)));
		
		lab.click();
	}
	
	public void selectOption(String option) {
		WebDriverWait webDriverWait = new WebDriverWait(this.webDriver, 10000);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(REGION_SELECT)));
		Select region = new Select(regionoSelect);
		
		region.selectByValue(option);
	}

}
