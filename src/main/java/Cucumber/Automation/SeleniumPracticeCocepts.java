package Cucumber.Automation;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumPracticeCocepts {
	public static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		calenderDateSelection();
	}

	public static void clickingontheLinksOfthePage() {
		driver = new FirefoxDriver();

		driver.get("https://onpassive.com");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int sizeOflinks = allLinks.size();
		System.out.println("Total number of links on the Page:=> " + sizeOflinks);

		for (int i = 1; i <= sizeOflinks; i++) {
			String linkText = driver.findElement(By.tagName("a")).getAttribute("href");
			System.out.println(i + " " + linkText);
		}
		WebElement socialmediaObject = driver.findElement(By.className("footer-social-links"));
		WebElement headerLinks = driver.findElement(By.xpath("//*[@id='navbarText']/ul"));
		List<WebElement> socialmedialink = headerLinks.findElements(By.tagName("a"));
		System.out.println("Size of the socialmedia links: " + socialmedialink.size());
		for (int i = 0; i < socialmedialink.size(); i++) {
			String keyeventClick = Keys.chord(Keys.CONTROL, Keys.ENTER);
			try {
				socialmedialink.get(i).sendKeys(keyeventClick);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> it = allWindow.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println("Page title is: " + driver.getTitle());
			System.out.println("data");
		}
	}

	public static void calenderDateSelection() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://www.spicejet.com/");
		Thread.sleep(6000);

		// Date Field Selection
		driver.findElement(By.xpath("//div[normalize-space()='Departure Date']")).click();

		// Get the list of dates in the date picker and then select teh required date.
		List<WebElement> dates = driver.findElements(By.xpath("//div[contains(@data-testid,'calendar-day')]"));
		int dateSize = dates.size();
		System.out.println("Date size is: " + dateSize);
		for (int i = 0; i <= dateSize; i++) {
			String datetext = driver.findElements(By.xpath("//div[contains(@data-testid,'calendar-day')]")).get(i)
					.getText();
			System.out.println("Dates Are: " + datetext);
			if (datetext.equalsIgnoreCase("26")) {
				driver.findElements(By.xpath("//div[contains(@data-testid,'calendar-day')]")).get(i).click();
				break;
			}

		}
		String enteredDateValue = driver.findElement(By.xpath(
				"/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]"))
				.getText();
		System.out.println("Selected Date is:=>" + enteredDateValue);

	}

	public static void isAlertPresent() {
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText() + " Alert is Displayed");
			alert.accept();
		} catch (NoAlertPresentException ex) {
			System.out.println("Alert is NOT Displayed");
		}
	}
}
