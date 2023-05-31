package pageObjects;

import org.openqa.selenium.By;

import Base.BasePage;

public class ProfilePage {

	BasePage basePage;

	public ProfilePage(BasePage basePage) {
		this.basePage = basePage;
	}

	private final By firstName = By.cssSelector("input[formcontrolname='firstName']");
	

	public String getFIrstName() {
		return basePage.driver.findElement(firstName).getAttribute("value");
	}

}
