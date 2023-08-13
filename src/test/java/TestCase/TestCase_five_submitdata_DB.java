package TestCase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCase_five_submitdata_DB {
	public String first_str = " ", emp_lname = " ", empailid = " ", empmobno = " ", current_position_name=" ",emp_current_company=" ", portfolio_ip=" ", salary_ip=" ", emp_cstartdate=" ", emp_address=" ";
public String firstname=" ", lastname=" ",empemail=" ",s=" ",salaryinp=" ",cur_company=" ", empmob=" ", dOB_date=" ",empaddress=" ",satartdate=" ", positionname=" ",portfolioinp=" ";
	public String month = "September 1996";
	public String str1="Email Trigger";
	@Test
	void submiting_data() throws InterruptedException, SQLException, AWTException
	{
		
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details", "root",
			"Namrata@2029");
	Statement stmt = con.createStatement();
	// Browser Launch
	System.setProperty("webdriver.chrome.driver", "C:\\eclipse-workspace\\Sourcefuse\\Browser\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(
			"http://sfwebhtml:t63KUfxL5vUyFLG4eqZNUcuRQ@sfwebhtml.sourcefuse.com/automation-form-demo-for-interview/");
	WebElement fname = driver.findElement(By.xpath("//div[@id='fnameInput']//input"));
	fname.sendKeys("Namrata");
	 firstname = fname.getAttribute("value");

	WebElement lname = driver.findElement(By.xpath("//div[@id='lnameInput']//input"));
	lname.sendKeys("Shete");
	 lastname = lname.getAttribute("value");
	WebElement email = driver.findElement(By.xpath("//div[@id='emailInput']//input"));
	email.sendKeys("namratashete98@gmail.com");
	 empemail = email.getAttribute("value");
	WebElement current_company = driver.findElement(By.xpath("//div[@id='curCompanyInput']//input"));
	current_company.sendKeys("TheMathCompany Pvt Ltd");
	 cur_company=current_company.getAttribute("value");
	
	
	WebElement emp_mob = driver.findElement(By.xpath("//div[@id='mobInput']//input"));
	emp_mob.sendKeys("7744008734");
	 empmob = emp_mob.getAttribute("value");
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
	WebElement data_dob=driver.findElement(By.xpath("//div[@class='input-group date']"));
	 dOB_date = data_dob.getAttribute("value");
	WebElement position = driver.findElement(By.xpath("//div[@id='positionInput']//input"));
	position.sendKeys("Quality Assurance Associate");

	 positionname = position.getAttribute("value");
	WebElement portfolio_input = driver.findElement(By.xpath("//div[@id='portfolioInput']//input"));
	portfolio_input.sendKeys("www.linkedin.com/in/namrata-shete-4a5a40248/");
	 portfolioinp = portfolio_input.getAttribute("value");
	WebElement salary = driver.findElement(By.xpath("//div[@id='salaryInput']//input"));
	salary.sendKeys("10.5 LPA");
	 salaryinp = salary.getAttribute("value");
	WebElement start = new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='whenStartInput']//input")));

	start.sendKeys("Immediate joiner");
	satartdate = start.getAttribute("value");

	WebElement address = driver.findElement(By.xpath("//div[@id='addressInput']//textarea"));
	address.sendKeys("Flat No 209 Building No-209 New Tisgoan MAHDA Chh. Sambhaji Nagar Maharastra");
	 empaddress = address.getAttribute("value");
	driver.findElement(By.xpath("//div[@id='resumeInput']")).click();
	Robot rb = new Robot();

	rb.delay(2000);
	StringSelection ss = new StringSelection(System.getProperty("user.dir")+"\\Browser\\Namrata_Shete_QA_Associate.");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	// CTRL + V
	rb.keyPress(KeyEvent.VK_CONTROL);
	rb.keyPress(KeyEvent.VK_V);
	rb.keyRelease(KeyEvent.VK_CONTROL);
	rb.keyRelease(KeyEvent.VK_V);
	rb.keyPress(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(2000);

	driver.findElement(By.xpath("//label[text()='Yes']")).click();

	 s = "insert into sourcefuse (firstname,lastname,emailid,mob_number,current_company,apply_position,portfolio_website,Salary_requrirements,when_to_start,address,DOB) values ('" + firstname + "','" + lastname + "','" + empemail + "','" + empmob
			+ "','"+cur_company+"','"+positionname+"','"+portfolioinp+"','"+salaryinp+"','"+satartdate+"','"+empaddress+"','"+dOB_date+"');";
	System.out.println(s);
	stmt.executeLargeUpdate(s);
	
	}

}
