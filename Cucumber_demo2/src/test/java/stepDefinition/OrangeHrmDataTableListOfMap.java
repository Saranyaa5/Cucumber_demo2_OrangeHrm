package stepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class OrangeHrmDataTableListOfMap {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("the user is in the OrangeHRM login page")
    public void the_user_is_in_the_orange_hrm_login_page() {
        String expectedTitle = "OrangeHRM";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "User is not on the login page");
    }

    @When("the user enters the invalid inputs")
    public void the_user_enters_the_invalid_inputs(DataTable dataTable) { //when using loop the with the help of one driver multiple assertion inputs ara passed
    	//not seperate driver for seperate inputs
        List<Map<String, String>> userList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> user : userList) { //here used iternation
            String username = user.get("username"); //if iternation not used (user(0).get("username")
            String password = user.get("password");//if iternation not used (user(0).get("pass")
            String expectedErrorMessage = user.get("error_message");
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            usernameField.sendKeys(username);
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            passwordField.sendKeys(password);
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            loginButton.click();
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(@class, 'oxd-alert-content-text')]")));
            String actualErrorMessage = errorElement.getText();
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match");
        }
    }

    @Then("the user should see the error message")
    public void the_user_should_see_the_error_message() {
        System.out.println("Error message successfull.");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
