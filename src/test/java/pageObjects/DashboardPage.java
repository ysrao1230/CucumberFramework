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
	By greetingWithUserName = By.xpath("//div[@class='d-profile-details']/h6");
	private final By userProfileIcon = By.xpath("//span[@class='arrow pl-1 d-flex']//img[@alt='arrow']");
	private final By profile_menu_Option = By.xpath("//button[normalize-space()='My Profile']");

	public ProfilePage profileMenuNavigation() {

		basepage.driver.findElement(userProfileIcon).click();
		basepage.driver.findElement(profile_menu_Option).click();
		ProfilePage profilePage = new ProfilePage(basepage);
		return profilePage;
	}

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
