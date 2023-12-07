package com.demo.ui.common_utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class Baseclass {
	public static WebDriver driver;
	public static FileInputStream inputStream;
	public static Logger log = (Logger) LogManager.getLogger(Baseclass.class.getName());
	public static WebDriverWait wait;


	public static WebDriver launchBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.manage().window().maximize();
			break;

		default:
			throw new IllegalArgumentException("Invalid browser namme: " + browserName);
		}
		return driver;

	}

	public static void navigateToUrl(String url) {
		driver.get(url);
		log.info("Navigate to " + url);
	}

	public static String getPageTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.err.println("Error getting page Title" + e.getMessage());
			return null;
		}
	}

	public static String getCurrentUrl() {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			System.err.println("Error getting page Title" + e.getMessage());
			return null;
		}
	}
	
	public static String getPath() {
		String path = System.getProperty("user.dir");
		return path;
	}
	
	public static String getAbsolutePath(String relativePath) {
		String path = System.getProperty("user.dir");
		return path+ File.separator+relativePath;
	}

	public static String getProperty(String key) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(getPath()+"\\src\\test\\resources\\config.properties"));
		Object object = prop.get(key);
		String value = (String) object;
		return value;
	}
	public  String getText(WebElement element) {
		try {
			return element.getText();
			
		} catch (Exception e) {
			System.err.println("Error getting element Text" + e.getMessage());
			return null;
		}
	}

	public static String getAttribute(WebElement element, String attributeName) {
		try {
			return element.getAttribute(attributeName);
		} catch (Exception e) {
			System.err.println("Error getting element Attribute" + e.getMessage());
			return null;
		}
	}

	public static boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			System.err.println("Error Displaying element" + e.getMessage());
			return false;
		}
	}

	public static boolean isElementEnabled(WebElement element) {
		try {
			return element.isEnabled();
		} catch (Exception e) {
			System.err.println("Error Enabling element" + e.getMessage());
			return false;
		}
	}

	public static boolean isElementSelected(WebElement element) {
		try {
			return element.isSelected();
		} catch (Exception e) {
			System.err.println("Error Selecting element" + e.getMessage());
			return false;
		}
	}

	public static WebDriver switchFrameByNameId(String nameOrID) {
		try {
			return driver.switchTo().frame(nameOrID);
		} catch (Exception e) {
			System.err.println("Error Switching frame by name or id" + e.getMessage());
			return null;
		}
	}

	public static WebDriver switchFrameByWebElement(WebElement frameElement) {
		try {
			return driver.switchTo().frame(frameElement);
		} catch (Exception e) {
			System.err.println("Error Switching frame by webelement" + e.getMessage());
			return null;
		}
	}

	public static void switchToParentFrame() {
		try {
			driver.switchTo().parentFrame();
		} catch (Exception e) {
			System.err.println("Error Switching to parent frame" + e.getMessage());
		}
	}

	public static void switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.err.println("Error Switching to default frame" + e.getMessage());
		}
	}

	public static void navigateBack() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			System.err.println("Error Navigating backward" + e.getMessage());
		}
	}

	public static void navigateTo(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			System.err.println("Error Navigating to url" + e.getMessage());
		}
	}

	public static void navigateForward() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			System.err.println("Error Navigating forward" + e.getMessage());
		}
	}

	public static void navigateRefresh() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			System.err.println("Error Refreshing page" + e.getMessage());
		}
	}

	public static void setWindowSize(int width, int height) {
		try {
			Dimension windowsize = new Dimension(width, height);
			driver.manage().window().setSize(windowsize);
		} catch (Exception e) {
			System.err.println("Error setting window size" + e.getMessage());
		}
	}

	public static Dimension getWindowSize(WebElement element) {
		try {
			return element.getSize();
		} catch (Exception e) {
			System.err.println("Error getting window size" + e.getMessage());
			return null;
		}
	}

	public static void setImplicitWait(long time) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		} catch (Exception e) {
			System.err.println("Error setting implicit wait" + e.getMessage());
		}
	}

	public static void setPageLoadTimeout(Duration duration) {
		try {
			driver.manage().timeouts().pageLoadTimeout(duration);
		} catch (Exception e) {
			System.err.println("Error occured while setting page load" + e.getMessage());
		}
	}

	public static void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.err.println("Error occured while static wait" + e.getMessage());
		}

	}

	public static void webDriverWait(Duration duration) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, duration);
		} catch (Exception e) {
			System.err.println("Error occured while webdriver wait for element" + e.getMessage());
		}
	}

	public static WebElement waitForElementClickable(By locator, Duration duration) {
		Wait<WebDriver> wait = (Wait<WebDriver>) new FluentWait(driver).withTimeout(duration)
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public static boolean waitForStaleElement(WebElement element, Duration duration) {
		Wait<WebDriver> wait = (Wait<WebDriver>) new FluentWait(driver).withTimeout(duration)
				.pollingEvery(Duration.ofMillis(500)).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.stalenessOf(element));

		try {
			element.isEnabled();
			return false;
			// not stale
		} catch (StaleElementReferenceException e) {
			System.err.println("Error occured while Fluent wait for stale element" + e.getMessage());
			return true;
		}

	}

	public static WebElement waitForElementVisiblity(By locator, Duration duration) {
		Wait<WebDriver> wait = (Wait<WebDriver>) new FluentWait(driver).withTimeout(duration)
				.pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public static void switchWindow() {
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			if (!handle.equals(windowHandle)) {
				driver.switchTo().window(handle);
				return;
			}
		}
	}

	public static void switchWindowByTitle(WebDriver driver, String targetTitle) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			String title = driver.switchTo().window(handle).getTitle();
			if (title.contains(targetTitle)) {
				driver.switchTo().window(handle);
			}
		}
	}

//	public WebElemnt findById(String id) {
//		try {
//			return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
//		} catch (TimeoutException e) {
//			throw new NoSuchElementException("Element with"+id+"not found");
//		}
//	}

	public static WebElement findById(String id) {
		return driver.findElement(By.id(id));

	}

	public static WebElement findByName(String name) {
		return driver.findElement(By.name(name));

	}

	public static WebElement findByClassName(String className) {
		return driver.findElement(By.className(className));

	}

	public static WebElement findByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));

	}

	public static WebElement findByTagName(String tagName) {
		return driver.findElement(By.tagName(tagName));
	}

	public static List<WebElement> multipleElements(String tagName) {
		return driver.findElements(By.tagName(tagName));
	}

	public static WebElement findByCssSelector(String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector));

	}

	public static WebElement findByLinkText(String linkText) {
		return driver.findElement(By.linkText(linkText));

	}

	public static WebElement findByPartialLinkText(String partialLinkText) {
		return driver.findElement(By.partialLinkText(partialLinkText));

	}

	public static boolean mousehover(WebElement element) {
		boolean status = false;
		try {
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
			log.info("Move to element");
			status = true;
		} catch (Exception e) {
			status = false;
			System.err.println("Unable to mousehover" + e.getMessage());
			log.info("Unable to mousehover");
		}
		return status;
	}

	public static boolean doubleClick(WebElement element) {
		boolean status = false;
		try {
			Actions ac = new Actions(driver);
			ac.doubleClick(element).build().perform();
			log.info("Double clicked element");
			status = true;
		} catch (Exception e) {
			status = false;
			System.err.println("Unable to double click" + e.getMessage());
			log.info("Unable to double click");
		}
		return status;
	}

	public static boolean mousehoverandclicksubmenu(WebElement mousehoverElement, WebElement submenuElement) {
		boolean status = false;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", submenuElement);
			status = true;
			log.info("User clicked on " + submenuElement + " sub menu in the " + mousehoverElement);
		} catch (Exception e) {
			status = false;
			log.error("Unable to mousehover on menu and click sub menu");
			System.err.println("Unable to mousehover on menu and click sub menu" + e.getMessage());
		}
		return status;

	}

	public static void performDragAndDrop(By srcLocator, By desLocator) {
		try {
			WebElement src = driver.findElement(srcLocator);
			WebElement des = driver.findElement(desLocator);
			Actions ac = new Actions(driver);
			ac.dragAndDrop(src, des).build().perform();
		} catch (Exception e) {

		}
	}

	public static void performContextClick(By eleLocator) {
		try {
			WebElement element = driver.findElement(eleLocator);
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
		} catch (Exception e) {

		}
	}

	public static void keysEnterActions() {
		Actions ac = new Actions(driver);
		ac.keyDown(Keys.ENTER).perform();
		ac.keyUp(Keys.ENTER).perform();
	}

	public static void releaseKey(int keycode) {
		try {
			Robot rb = new Robot();
			rb.keyRelease(keycode);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void pressKey(int keycode) {
		try {
			Robot rb = new Robot();
			rb.keyPress(keycode);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void selByValue(By ddnLocator, String value) {
		try {
			WebElement ddn = driver.findElement(ddnLocator);
			Select select = new Select(ddn);
			select.selectByValue(value);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void selByText(By ddnLocator, String text) {
		try {
			WebElement ddn = driver.findElement(ddnLocator);
			Select select = new Select(ddn);
			select.selectByVisibleText(text);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void selByIndex(By ddnLocator, int index) {
		try {
			WebElement ddn = driver.findElement(ddnLocator);
			Select select = new Select(ddn);
			select.selectByIndex(index);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void deSelByValue(By ddnLocator, String value) {
		try {
			WebElement ddn = driver.findElement(ddnLocator);
			Select select = new Select(ddn);
			select.deselectByValue(value);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void deSelByText(By ddnLocator, String text) {
		try {
			WebElement ddn = driver.findElement(ddnLocator);
			Select select = new Select(ddn);
			select.deselectByVisibleText(text);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void deSelByIndex(By ddnLocator, int index) {
		try {
			WebElement ddn = driver.findElement(ddnLocator);
			Select select = new Select(ddn);
			select.deselectByIndex(index);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static boolean selIsMultiple(By ddnLocator) {
		try {
			WebElement ddn = driver.findElement(ddnLocator);
			Select select = new Select(ddn);
			return select.isMultiple();
		} catch (Exception e) {
			return false;
		}

	}

	public static List<WebElement> selGetOptions(By ddnLocator) {
		try {
			WebElement ddn = driver.findElement(ddnLocator);
			Select select = new Select(ddn);
			return select.getOptions();
		} catch (Exception e) {
			return null;
		}
	}

	public static WebElement selGetFirstSelectedOption(By ddnLocator) {
		try {
			WebElement ddn = driver.findElement(ddnLocator);
			Select select = new Select(ddn);
			return select.getFirstSelectedOption();
		} catch (Exception e) {
			return null;
		}
	}

	public static List<WebElement> selGetAllSelectedOptions(By ddnLocator) {
		try {
			WebElement ddn = driver.findElement(ddnLocator);
			Select select = new Select(ddn);
			return select.getAllSelectedOptions();
		} catch (Exception e) {
			return null;
		}
	}

//	public static String browserCapture(String filepath, String filename) {
//
//		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File targetFile = new File(
//				new StringBuilder(String.valueOf(filepath)).append(filename).append(".jpg").toString());
//		try {
//			FileUtils.copyFile(srcFile, targetFile);
//			log.info("Copied file to " + targetFile);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		String fullPath = targetFile.getAbsolutePath();
//		String custom[] = fullPath.split("TC");
//		return "TC" + custom[1];
//	}

	public static void browserCapture(String filepath, String fileName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File desFile = new File(filepath);
		if(!desFile.exists()) {
			desFile.mkdirs();
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String timeStamp = dateFormat.format(new Date());
		String screenshotPath = desFile.getPath() + File.separator + fileName + "_" + timeStamp + ".png";
		try {
			org.openqa.selenium.io.FileHandler.copy(srcFile, new File(screenshotPath));
			System.out.println("Screenshot saved: " + screenshotPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static byte[] screenshotForCucumber() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		byte[] b = ts.getScreenshotAs(OutputType.BYTES);
		return b;
	}

	public static void closepopup(Alert alert, String checkflag) {
		alert = driver.switchTo().alert();
		if (checkflag.equalsIgnoreCase("ON") || checkflag.equalsIgnoreCase("TRUE") || checkflag.equalsIgnoreCase("YES")
				|| checkflag.equalsIgnoreCase("Y")) {
			alert.accept();
			log.info("alert accept");
		} else if (checkflag.equalsIgnoreCase("OFF") || checkflag.equalsIgnoreCase("FALSE")
				|| checkflag.equalsIgnoreCase("NO") || checkflag.equalsIgnoreCase("N")) {
			alert.dismiss();
			log.info("alert dismiss");
		}
	}

	public static void sendkeysAlert(Alert alert, String value) {
		alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	public String getTextAlert(Alert alert) {
		alert = driver.switchTo().alert();
		String text = alert.getText();
		return text;
	}

//	public static String selectDdn(WebElement selectddn, String selectBy) {
//		String optionvalue = "";
//		Select select = new Select(selectddn);
//		if (selectBy.equalsIgnoreCase("value")) {
//			optionvalue = select.getFirstSelectedOption().getAttribute("value");
//		} else if (selectBy.equalsIgnoreCase("text")) {
//			optionvalue = select.getFirstSelectedOption().getText();
//		}
//		return optionvalue;
//	}

	public static void clkElement(WebElement ele) {
		ele.click();
		log.info("Element clicked " + ele);
	}

	public static void jsClkElement(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", ele);
		log.info("Element clicked by javascript " + ele);
	}

	public static void jsSetAttribute(WebElement ele, String text) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','" + text + "')", ele);
	}

	public static String jsGetAttribute(WebElement ele, String attributeName) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute(arguments[1];)",
				ele, attributeName);

	}

	public static String jsGetBackgroundColor(WebElement ele) {
		return (String) ((JavascriptExecutor) driver)
				.executeScript("return window.getComputedStyle(arguments[0]).backgroundColor;", ele);
	}

	public static void jsScrollIntoViewDown(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	public static void jsScrollIntoViewUp(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false)", ele);
	}

//	For Down +value, For Up -value
	public static void jsScrollBy(int pixel) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixel + ")");
	}

	public static void txtinput(WebElement ele, String value) {
		ele.sendKeys(value);
		log.info("value entered" + value);
	}

	public static int brokenlinks() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links on the page: " + links.size());
		int brokenCount = 0;
		for (WebElement link : links) {
			String href = link.getAttribute("href");
			if (href != null && !href.isEmpty()) {
				try {
					URL url = new URL(href);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("HEAD");
					conn.connect();

					int responseCode = conn.getResponseCode();
					if (responseCode != 200 && responseCode >= 400) {
						brokenCount++;
						System.out.println("Broken link: " + href + "- Response Code" + responseCode);
					}
				} catch (Exception e) {
					System.out.println("Error connecting to: " + href + " - " + e.getMessage());
				}
			}
		}
		return brokenCount;
	}

	public static String getTableHeader(String tableLocator, int columnIndex) {

		try {

			WebElement table = driver.findElement(By.xpath(tableLocator));

			List<WebElement> headers = table.findElements(By.tagName("th"));

			if (columnIndex >= 0 && columnIndex < headers.size()) {

				return headers.get(columnIndex).getText();

			} else {

				return null;

			}

		} catch (Exception e) {

			e.printStackTrace();

			return null;

		}

	}

	public static String getTableCell(String tableLocator, int rowIndex, int columnIndex) {

		try {

			WebElement table = driver.findElement(By.xpath(tableLocator));

			List<WebElement> rows = table.findElements(By.tagName("tr"));

			if (rowIndex >= 0 && rowIndex < rows.size()) {

				WebElement row = rows.get(rowIndex);

				List<WebElement> cells = row.findElements(By.tagName("td"));

				if (columnIndex >= 0 && columnIndex < cells.size()) {

					return cells.get(columnIndex).getText();

				} else {

					return null;

				}

			} else {

				return null;

			}

		} catch (Exception e) {

			e.printStackTrace();

			return null;

		}

	}

	public static String getTableCellText(String tableLocator, int rowIndex, int columnIndex) {

		try {

			WebElement table = driver.findElement(By.xpath(tableLocator));

			WebElement cell = table.findElement(By.xpath("//tr[" + (rowIndex + 1) + "]/td[" + (columnIndex + 1) + "]"));

			return cell.getText();

		} catch (Exception e) {

			e.printStackTrace();

			return null;

		}

	}

	public static void getSpecificDynamicRow(int desiredRow) {

		List<WebElement> rows = driver.findElements(By.tagName("tr"));

		for (int i = 0; i < rows.size(); i++) {

			if (i == desiredRow) {

				WebElement row = rows.get(i);

				List<WebElement> cells = row.findElements(By.tagName("td"));

				for (WebElement cell : cells) {

					String text = cell.getText();

					System.out.println(text);

				}

			}

		}

	}

	public static void getSpecificDynamicCell(String desiredCell) {

		List<WebElement> rows = driver.findElements(By.tagName("tr"));

		for (WebElement row : rows) {

			List<WebElement> cells = row.findElements(By.tagName("td"));

			for (WebElement cell : cells) {

				String text = cell.getText();

				if (text.equals(desiredCell)) {

					for (WebElement rowData : cells) {

						System.out.println(rowData.getText());

					}

				}

			}

		}

	}

	public static void writeWebTableToExcel(String sheetName, String filePath) {

		try {

			File file = new File(filePath);

			FileInputStream stream = new FileInputStream(file);

			Workbook book = new XSSFWorkbook(stream);

			Sheet sheet = book.getSheet(sheetName);

			List<WebElement> rows = driver.findElements(By.tagName("tr"));

			int rowNum = 0;

			for (WebElement row : rows) {

				List<WebElement> datas = row.findElements(By.tagName("td"));

				Row excelRow = sheet.createRow(rowNum);

				int cellNum = 0;

				for (WebElement data : datas) {

					String text = data.getText();

					Cell cell = excelRow.createCell(cellNum);

					cell.setCellValue(text);

					cellNum++;

				}

				rowNum++;

			}

			FileOutputStream output = new FileOutputStream(file);

			book.write(output);

			book.close();

			output.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	
}
