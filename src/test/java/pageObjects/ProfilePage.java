package pageObjects;

import org.openqa.selenium.By;

import Base.BasePage;

public class ProfilePage {

	BasePage basePage;

	public ProfilePage(BasePage basePage) {
		this.basePage = basePage;
	}

	private final By firstName = By.cssSelector("input[formcontrolname='firstName']");
	private final By lastName = By.cssSelector("input[formcontrolname='lastName']");


	public String getFirstName() {
		return basePage.driver.findElement(firstName).getAttribute("value");
	}
	public String getLasttName() {
		return basePage.driver.findElement(lastName).getAttribute("value");
	}

}
