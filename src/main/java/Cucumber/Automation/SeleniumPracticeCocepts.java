package Cucumber.Automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SeleniumPracticeCocepts {
	public static WebDriver driver = null;
	static Connection connect;

	public static void main(String[] args) throws SQLException, IOException, InterruptedException {
		dbConnectionusingSelenium();
		// fileUploadUsingAUtoIt();
	}

	public static void clickingontheLinksOfthePage() {
		driver = new FirefoxDriver();

		driver.get("https://onpassive.com");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int sizeOflinks = allLinks.size();
		System.out.println("Page link size is: " + sizeOflinks);
		System.out.println("Total number of links on the Page:=> " + sizeOflinks);

		for (int i = 1; i <= sizeOflinks; i++) {
			String linkText = driver.findElement(By.tagName("a")).getAttribute("href");
			System.out.println(i + " " + linkText);
		}
		// WebElement socialmediaObject =
		// driver.findElement(By.className("footer-social-links"));
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

	public static void calenderDateSelection() throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://www.spicejet.com/");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		// Date Field Selection
		driver.findElement(By.xpath("//div[normalize-space()='Departure Date']")).click();

//		while (!driver.findElement(By.xpath("//*[@class='css-1dbjc4n r-1euycsn']")).getText().contains("August")) {
//			System.out.println(driver.findElement(By.xpath("//*[@class='css-1dbjc4n r-1euycsn']")).getText());
//			driver.findElement(By.xpath("(//*[@fill-rule='evenodd'])[9]")).click();
//			Thread.sleep(1500);
//		}
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
		takeAScreenShot();

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

	// Current Local Date and time
	public static String currentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	// SUm of the Total Values of the table column
	public static void sumofCoulumnValues() throws InterruptedException, IOException {
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(3000);
		List<WebElement> priceValues = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));

		int sum = 0;
		for (int i = 0; i < priceValues.size(); i++) {
			sum = sum + Integer.parseInt(priceValues.get(i).getText());
		}

		System.out.println("Sum of the Cource Price: " + sum);

		int totalSum = Integer
				.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim());

		System.out.println("Total of position amount: " + totalSum);
		takeAScreenShot();
	}

	public static void takeAScreenShot() throws IOException {
		// Takescreenshot

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/test_" + currentDate() + ".png");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		FileUtils.copyFile(srcFile, dest);
	}

	public static void brokenLinks() throws MalformedURLException, IOException, InterruptedException {
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.get("https:/onpassive.com");

		driver.get("https://www.flipkart.com/");

		// this below action for the FLipkart only
		driver.findElement(By.cssSelector("button[class='_2KpZ6l _2doB4z']")).click();
		Thread.sleep(2000);
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		System.out.println("Page links size: " + alllinks.size());
		SoftAssert a = new SoftAssert();
		int i = 1;
		for (WebElement link : alllinks) {
			try {
				String url = link.getAttribute("href");
				HttpURLConnection connect = (HttpURLConnection) new URL(url).openConnection();
				connect.setRequestMethod("HEAD");
				connect.connect();
				int responsecode = connect.getResponseCode();
				System.out.println(i + ". " + url + " " + responsecode);
				a.assertTrue(responsecode < 400,
						i + ". The link with text " + url + "is broken with the response code: " + responsecode);
				i++;
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (ProtocolException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		a.assertAll();
	}

	public static void multipleWindowAccess() throws IOException, InterruptedException {

		browserIntilaization("chrome");
		driver.get("https://www.sakshi.com/");
		System.out.println(driver.findElements(By.cssSelector("span[class='field-content']")).get(20).getText());
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> browser = driver.getWindowHandles();

		Iterator<String> it = browser.iterator();

		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.get("https:google.com");
		String pageTitle = driver.getTitle();
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(parentWindow);
		WebElement search = driver.findElement(By.cssSelector("input[id='term']"));
		search.sendKeys(pageTitle);
		// Partial screenshot based on the WebElement
		File src = search.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("test_" + currentDate() + ".png"));
		takeAScreenShot();
		Thread.sleep(2000);

		// hight and width of the webelement

		System.out.println(search.getRect().getDimension().getHeight());
		System.out.println(search.getRect().getDimension().getWidth());
		driver.quit();

	}

	public static void browserIntilaization(String browser) {
		if (browser.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browser.contains("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.contains("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public static void submitFOrmwithoutClick() throws IOException {
		browserIntilaization("chrome");
		driver.get("https://google.com");
		driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("data", Keys.ENTER);
		takeAScreenShot();
		driver.quit();
	}

	public static void readExcelData() throws IOException {

		String filepath = "C:\\Users\\Srinivasa Rao\\Downloads\\ExcelReadWrite.xlsx";
		FileInputStream fip = new FileInputStream(filepath);
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fip);
		XSSFSheet sheet = wb.getSheetAt(0);

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		System.out.println("last row  no: " + rows);
		System.out.println("Last column number: " + cols);

		for (int i = 0; i <= rows; i++) {

			XSSFRow row = sheet.getRow(i);
			for (int c = 0; c < cols; c++) {
				XSSFCell cell = row.getCell(c);
				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				case FORMULA:
					System.out.print(cell.getNumericCellValue());
				default:
					break;

				}
				System.out.print("|");
			}
			System.out.println();

		}
		System.out.println("------------------------------");
		// Using the iterator
		Iterator<Row> it = sheet.rowIterator();
		while (it.hasNext()) {
			XSSFRow row = (XSSFRow) it.next();
			Iterator<?> cellit = row.cellIterator();
			while (cellit.hasNext()) {
				XSSFCell cell = (XSSFCell) cellit.next();
				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				default:
					break;

				}
				System.out.print(" | ");
			}
			System.out.println();
		}
		System.out.println("**************************************");
		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j < cols; j++) {
				XSSFCell celldata = sheet.getRow(i).getCell(j);
				switch (celldata.getCellType()) {
				case NUMERIC:
					System.out.print(celldata.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(celldata.getBooleanCellValue());
					break;
				case STRING:
					System.out.print(celldata.getStringCellValue());
					break;
				case FORMULA:
					System.out.print(celldata.getNumericCellValue());
					break;
				default:
					break;
				}
				System.out.print(" | ");
			}
			System.out.println();
		}

	}

	public static void dbConnectionusingSelenium() throws SQLException {

		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "Msrrcr@1.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (connect.isClosed() == true) {
				System.out.println("Data Base connection is closed");
			} else {
				System.out.println("Data Base connection established successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Statement stmt = connect.createStatement();
		ResultSet result = stmt
				.executeQuery("SELECT * FROM sys.product where PRODUCT_TYPE_CD='ACCOUNT' and PRODUCT_CD='MM'");

		while (result.next()) {
			System.out.print(result.getString(1) + " | ");
			System.out.print(result.getString(2) + " | ");
			System.out.print(result.getString(3) + " | ");
			System.out.print(result.getString(4) + " | ");
			System.out.print(result.getString(5) + " | ");
			System.out.println();
		}
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		spark.config().setTheme(Theme.DARK);
		extent.attachReporter(spark);
		extent.createTest("MyFirstTest").log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");

		extent.flush();
//		Runtime.getRuntime().exec(null)
	}

	@SuppressWarnings("deprecation")
	public static void fileUploadUsingAUtoIt() throws IOException, InterruptedException {
		browserIntilaization("firefox");
		driver.get("https://fineuploader.com/demos.html");
		Actions a = new Actions(driver);
		// scroll down a page
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		WebElement uploadbutton = driver
				.findElement(By.xpath("//div[@id='fine-uploader-gallery']//input[@title='file input']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", uploadbutton);
		Runtime.getRuntime().exec("D:/Automation info/autoit-v3-setup/AutoResources/Autoit.exe" + " "
				+ "C:/Users/Srinivasa Rao/Downloads/brydon-mccluskey-Cp0reX9APUA-unsplash.jpg");
		System.out.println("FIle Uploaded Successfully");
	}
}
