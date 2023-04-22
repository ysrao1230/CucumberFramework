package Cucumber.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SeleniumPracticeCocepts {
	public static WebDriver driver = null;

	public static void main(String[] args) {
		clickingontheLinksOfthePage();
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
}
