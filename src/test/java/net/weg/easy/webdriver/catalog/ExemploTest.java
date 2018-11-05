
package net.weg.easy.webdriver.catalog;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.TestCase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;

public class ExemploTest extends TestCase {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\marti\\Downloads\\cat-test-system\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testCarrinho() throws Exception {
		driver.get("http://www.gmail.com.br/");

		// boolean to check conditions
		boolean findPage;
		// WebElement to text inputs
		WebElement textField;
		// WebElement to buttons
		WebElement btn;

		// create Wait property
		WebDriverWait wait = new WebDriverWait(driver, 120);

		// find and fill "username" text area
		textField = driver.findElement(By.name("identifier"));
		textField.sendKeys("fresca.laranja");
		textField.submit();

		// find and click "next" button
		btn = driver.findElement(By.id("identifierNext"));
		btn.click();

		// wait till load password page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

		// find and fill "password" text area
		textField = driver.findElement(By.name("password"));
		textField.sendKeys("laranj@123");
		textField.submit();
		Thread.sleep(100);

		// find and click on "login" button
		btn = driver.findElement(By.id("passwordNext"));
		btn.click();

		// wait till load home page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("z0")));

		// check if the page load
		findPage = driver.getPageSource().contains("Caixa de entrada");
		assertTrue(findPage);

		// find by "write" button
		btn = driver.findElement(By.className("z0"));
		btn.click();


		// wait till load send email page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));

		// find and fill the receiver
		textField = driver.findElement(By.name("to"));
		textField.sendKeys("fresca.laranja@gmail.com");

		// find and fill the subject field
		textField = driver.findElement(By.name("subjectbox"));
		textField.sendKeys("Atividade TESTE DE SOFTWARE");

		// find and fill the email content
		textField = driver.findElement(By.className("Am"));
		textField.sendKeys("Algum texto aletatório para colocar aqui");

		// find and click on send button
		btn = driver.findElement(By.className("gU"));
		btn.click();

		// wait till load home page again
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("z0")));

		// check if home page is loaded again
		findPage = driver.getPageSource().contains("Atividade TESTE DE SOFTWARE");
		assertTrue(findPage);

		// open the received email
		btn = driver.findElement(By.className("zA"));
		btn.click();

		// wait till load home page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bkH")));

		// find and click on "answer" button
		btn = driver.findElement(By.className("bkH"));
		btn.click();

		// find and fill the content of the answer
		textField = driver.findElement(By.className("Am"));
		textField.sendKeys("Ok, email lido. Obrigado.");

		// find and click on "send" button
		btn = driver.findElement(By.className("btA"));
		btn.click();

		// find and click on "inbox" button
		btn = driver.findElement(By.className("TO"));
		btn.click();

		// check if the answer was received
		findPage = driver.getPageSource().contains("Ok, email lido. Obrigado.");
		assertTrue(findPage);

		// find and click on "sent" button
		btn = driver.findElement(By.className("aHS-bnu"));
		btn.click();

		// wait till load next page
		wait.until(ExpectedConditions.urlToBe("https://mail.google.com/mail/#sent"));

		// check if the sent email exist
		findPage = driver.getPageSource().contains("Ok, email lido. Obrigado.");
		assertTrue(findPage);

		// find the checkbox and click to select the respective email
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("document.getElementsByTagName('tbody')[2].childNodes[0].childNodes[1].click();");
                
                Actions builder = new Actions(driver);
                builder.moveToElement(driver.findElement(By.className("zA"))).perform();
                
                builder.moveToElement(driver.findElement(By.className("aqw"))).click().perform();
                
//		// remove the selected email
//		btn = driver.findElement(By.className("nX"));
//		btn.click();

		Thread.sleep(100000);
	}


}
