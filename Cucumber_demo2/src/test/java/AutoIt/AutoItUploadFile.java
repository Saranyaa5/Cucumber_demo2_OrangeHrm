package AutoIt;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AutoItUploadFile {
	public static void main(String args[]) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://pdf2doc.com/");
		
		WebElement upload = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/label/span"));
		upload.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\saran\\eclipse-workspace\\Script1.exe");
	}
}