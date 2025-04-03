package stepDefinition;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHrmQuickStartStepDef {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Given("the user is on the OrangeHRM login page")
    public void the_user_is_on_the_orange_hrm_login_page() {
        String expectedTitle = "OrangeHRM";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "User is not on the login page");
    }

    @When("the user enters the valid username {string}")
    public void the_user_enters_the_valid_username(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameField.sendKeys(username);
    }

    @When("the user enters the valid password {string}")
    public void the_user_enters_the_valid_password(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys(password);
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginButton.click();
    }

    @Then("the user should be able to see the dashboard of OrangeHRM")
    public void the_user_should_be_able_to_see_the_dashboard_of_orange_hrm() {
        //Pizarra de pendientes
        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard is not visible");
    }

    @When("the user views the quick launch section")
    public void the_user_views_the_quick_launch_section() {
        WebElement quickLaunchSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div:nth-child(3) > div > div.orangehrm-dashboard-widget-header > div > p")));
        Assert.assertTrue(quickLaunchSection.isDisplayed(), "Quick Launch section is not visible");
    }

    @Then("the user should see the option {string}")
    public void the_user_should_see_the_option(String option) {
        WebElement quickLaunchOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(@class, 'orangehrm-quick-launch-heading') and @title='" + option + "']")
        ));
        Assert.assertTrue(quickLaunchOption.isDisplayed(), "Quick launch option '" + option + "' is not visible");
    }



    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
