package TestCase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Testcase_Four_Submit_Data {

@Test
	public void datanase_connectivity() throws SQLException, AWTException, InterruptedException
	{
	String month = "September 1996";

	
	// Browser Launch
	System.setProperty("webdriver.chrome.driver", "C:\\eclipse-workspace\\Sourcefuse\\Browser\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(
			"http://sfwebhtml:t63KUfxL5vUyFLG4eqZNUcuRQ@sfwebhtml.sourcefuse.com/automation-form-demo-for-interview/");
	WebElement fname = driver.findElement(By.xpath("//div[@id='fnameInput']//input"));
	fname.sendKeys("Namrata");


	WebElement lname = driver.findElement(By.xpath("//div[@id='lnameInput']//input"));
	lname.sendKeys("Shete");
	
	WebElement email = driver.findElement(By.xpath("//div[@id='emailInput']//input"));
	email.sendKeys("namratashete98@gmail.com");
	
	WebElement current_company = driver.findElement(By.xpath("//div[@id='curCompanyInput']//input"));
	current_company.sendKeys("TheMathCompany Pvt Ltd");
	
	WebElement emp_mob = driver.findElement(By.xpath("//div[@id='mobInput']//input"));
	emp_mob.sendKeys("7744008734");

	WebElement date = driver.findElement(By.xpath("//div[@class='input-group date']"));
	date.click();

	while (true) {
		String month_yr = driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/thead/tr[2]/th[2]"))
				.getText();
		if (month_yr.equals(month)) {
			break;
		} else {
			driver.findElement(By.xpath("//th[@class='prev'][1]")).click();
		}
	}
	driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[5]/td[contains(text(),\"25\")]")).click();

	WebElement position = driver.findElement(By.xpath("//div[@id='positionInput']//input"));
	position.sendKeys("Quality Assurance Associate");


	WebElement portfolio_input = driver.findElement(By.xpath("//div[@id='portfolioInput']//input"));
	portfolio_input.sendKeys("www.linkedin.com/in/namrata-shete-4a5a40248/");
	
	WebElement salary = driver.findElement(By.xpath("//div[@id='salaryInput']//input"));
	salary.sendKeys("10.5 LPA");
	
	WebElement start = new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='whenStartInput']//input")));

	start.sendKeys("Immediate joiner");


	WebElement address = driver.findElement(By.xpath("//div[@id='addressInput']//textarea"));
	address.sendKeys("Flat No 209 Building No-209 New Tisgoan MAHDA Chh. Sambhaji Nagar Maharastra");

	driver.findElement(By.xpath("//div[@id='resumeInput']")).click();
	Robot rb = new Robot();

	rb.delay(2000);
	StringSelection ss = new StringSelection(
			"C:\\Users\\DELL\\OneDrive\\Desktop\\Namrata_Shete_QA_Associate.");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	// CTRL + V
	rb.keyPress(KeyEvent.VK_CONTROL);
	rb.keyPress(KeyEvent.VK_V);
	rb.keyRelease(KeyEvent.VK_CONTROL);
	rb.keyRelease(KeyEvent.VK_V);
	rb.keyPress(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(2000);

	driver.findElement(By.xpath("//input[@id='yes']")).click();


	driver.findElement(By.xpath("//button[@type='submit']")).click();

	Thread.sleep(2000);

	}
}
