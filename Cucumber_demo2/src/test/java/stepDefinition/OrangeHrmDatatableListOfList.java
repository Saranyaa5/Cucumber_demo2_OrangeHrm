package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class OrangeHrmDatatableListOfList {
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

    @Given("the user is in OrangeHRM login page")
    public void the_user_is_in_orangehrm_page() {
        String expectedTitle = "OrangeHRM";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "User is not on the login page");
    }

    @When("the user enters the valid inputs")
    public void the_user_enters_the_valid_inputs(DataTable dataTable) {
        List<List<String>> credentials = dataTable.asLists(String.class);
        String username = credentials.get(0).get(0);
        String password = credentials.get(0).get(1);
        
        System.out.println("Logging in with: " + username + " / " + password);

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameField.sendKeys(username);

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys(password);

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginButton.click();
    }

    @Then("the user should be able to login successfully and redirect to Dashboard")
    public void the_user_should_be_able_to_login_successfully_and_redirect_to_dash_board() {
        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard is not visible");
       
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
