package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.AppConfig;
import utils.TestUtils;

import java.time.Duration;

public class BasePage extends TestUtils {

	
	public static WebDriver driver = null;
	public String browserName;

	public void browserIntialization() {

		browserName = AppConfig.browserName;

		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			// driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Defined  browser is the invalid browser");
		}

		if (driver != null) {
			driver.manage().window().maximize();
			System.out.println(AppConfig.url);
			driver.get(AppConfig.url);
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIME));
		}

	}

	public WebElement gettingWebElements(By xpath) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIME));
		wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
		return driver.findElement(xpath);
	}

}
