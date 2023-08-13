package TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase_one {

	public static void main(String[] args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "C:\\eclipse-workspace\\Sourcefuse\\Browser\\chromedriver.exe");
	ChromeDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://sfwebhtml:t63KUfxL5vUyFLG4eqZNUcuRQ@sfwebhtml.sourcefuse.com/automation-form-demo-for-interview/");
JavascriptExecutor js =(JavascriptExecutor) driver;
WebElement reset=driver.findElement(By.xpath("//button[@type='reset']"));
js.executeScript("arguments[0].scrollIntoView();",reset);
driver.findElement(By.xpath("//button[@type='submit']")).click();
Thread.sleep(2000);
driver.quit();
	}

}
