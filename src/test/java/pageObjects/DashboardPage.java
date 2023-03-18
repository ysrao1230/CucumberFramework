package pageObjects;

import org.openqa.selenium.By;

import Base.BasePage;

public class DashboardPage {

	BasePage basepage;

	public DashboardPage(BasePage basepage) {
		this.basepage = basepage;
	}

	By closePopup = By.xpath("//button[@aria-label='Close']");
	By greetingMessage = By.xpath("//h5[normalize-space()='Have a nice day at work!']");
	By greetingWithUserName=By.xpath("//div[@class='d-profile-details']/h6");
	
	
	public String gettingTheGreetingMessageWithUserName() {
		return basepage.gettingWebElements(greetingWithUserName).getText();
	}

	public void closepopupicon() {
		basepage.gettingWebElements(closePopup).click();
	}

	public String getDashboardMessage() {
		return basepage.gettingWebElements(greetingMessage).getText();
	}
}
