package AutoIt;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDemo {
    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://pdf2doc.com/");

        WebElement upload = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/label/span"));
        upload.click();  
        Thread.sleep(2000);

        StringSelection str = new StringSelection("C:\\Users\\saran\\Downloads\\Networking_v0.1.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        Robot robot = new Robot();
        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("File uploaded successfully.");
    }
}
