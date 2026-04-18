package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownAssignment {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("checkBoxOption1")).click();
		String optionText = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]")).getText();
		WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
		Select dropDownSelected = new Select(dropDown);
		dropDownSelected.selectByVisibleText(optionText);
		driver.findElement(By.id("name")).sendKeys(optionText);
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String[] alertTextArray = alertText.split(" ");
		for (String part : alertTextArray) {
			if (part.startsWith("Option")) {
				String[] option1 = part.split(",");
				System.out.println(option1[0]);
				break;
			}
		}

	}
}
