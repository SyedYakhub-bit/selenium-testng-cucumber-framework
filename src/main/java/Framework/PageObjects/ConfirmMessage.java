package Framework.PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmMessage extends AbstractComponents {
	WebDriver driver;

	@FindBy(css = ".hero-primary")
	WebElement confirmMessageText;

	public ConfirmMessage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getConfirmMessageText() {
		return confirmMessageText.getText();
	}
}
