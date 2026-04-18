package Framework.PageObjects;

import TestClasses.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends AbstractComponents {
	WebDriver driver;

	@FindBy(css = "input[placeholder*='Select Country']")
	WebElement country;

	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectCountry;

	@FindBy(css = ".action__submit")
	WebElement submit;

	By submitButton = By.cssSelector(".ta-results.list-group.ng-star-inserted");

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void selectCountry(String countryName) {
		Actions actions = new Actions(driver);
		actions.sendKeys(country, countryName).build().perform();
		waitForElementToBeVisible(submitButton);
		scrollToTopOfThePage();
		selectCountry.click();

	}

	public ConfirmMessage submitOrder() {
		submit.click();
		return new ConfirmMessage(driver);
	}

}
