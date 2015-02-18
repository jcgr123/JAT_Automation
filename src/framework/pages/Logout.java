package framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.selenium.SeleniumDriverManager;

public class Logout {

	public WebDriver driver;

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
		dropdown.click();
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
