package Marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dev.failsafe.internal.util.Assert;

public class CuraAppointment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		// maximize the browser
		driver.manage().window().maximize();
		// adding implicit wait to load the page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://katalon-demo-cura.herokuapp.com/profile.php");
		// getting the title of the page
		System.out.println("Title of the Page:" + driver.getTitle());
		// clicking the appointment button
		driver.findElement(By.xpath("//a[@id='btn-make-appointment']")).click();
		Thread.sleep(1000);
		// Entering login credentials
		driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
		driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("ThisIsNotAPassword");
		Thread.sleep(1000);
		driver.findElement(By.id("btn-login")).click();

		WebElement click = driver.findElement(By.id("combo_facility"));
		Select options = new Select(click);
		options.selectByVisibleText("Hongkong CURA Healthcare Center");
		driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']")).click();
		driver.findElement(By.xpath("//input[@id='radio_program_medicaid']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='txt_visit_date']")).click();
		driver.findElement(By.xpath("//td[contains(text(),'25')]")).click();
		driver.findElement(By.id("txt_comment")).click();
		driver.findElement(By.id("txt_comment")).sendKeys("Fever");
		driver.findElement(By.xpath("//button[contains(text(), 'Book Appointment')]")).click();
		boolean successMessage = driver.getPageSource().contains("Appointment Confirmation");
		if (successMessage) {
			System.out.print("Login successful");
		} else {
			System.out.print("Login unsuccessful");
		}
		driver.close();
	}

}
