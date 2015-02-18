package framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.selenium.SeleniumDriverManager;

public class Logout {

	WebDriver driver;

	@FindBy(xpath = "//div/span")
	WebElement dropdown;

	@FindBy(linkText = "Logout")
	WebElement logoutLink;

	public Logout() {
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	/**
	 * click on dropdown icon
	 */
	public void clickDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		@SuppressWarnings("unused")
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.
				xpath("//div/span")));
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/ul/div[1]/span")).click();
		//dropdown.click();
	}

	/**
	 * click on logout
	 */
	public void clickLogout() {
		logoutLink.click();
	}

	public void logoutOfJAT() {
		clickDropdown();
		clickLogout();
	}
}
