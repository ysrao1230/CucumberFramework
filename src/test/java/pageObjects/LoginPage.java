package pageObjects;

import org.openqa.selenium.By;

import Base.BasePage;

public class LoginPage {

	BasePage basepage;

	public LoginPage(BasePage basepage) {
		this.basepage = basepage;
	}

	By username = By.xpath("//input[@formcontrolname='emailId']");
	By password = By.xpath("//input[@formcontrolname='password']");
	By loginButton = By.xpath("//button[text()=' Login ']");

	public void userNameInput(String userName) {
		basepage.driver.findElement(username).sendKeys(userName);
	}

	public void passwordNameInput(String passwords) {
		basepage.driver.findElement(password).sendKeys(passwords);
	}

	public void loginButtonAction() {
		basepage.driver.findElement(loginButton).click();
	}
	
	public String getPageTitle() {
		return basepage.driver.getTitle();
	}

}
