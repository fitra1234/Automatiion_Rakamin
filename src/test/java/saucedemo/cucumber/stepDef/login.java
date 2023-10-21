package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("halaman login saucedemo")
    public void halamanLoginSaucedemo() {
        WebDriverManager.edgedriver().setup(); //setup chrome driver automatically using web driver manager
        EdgeOptions opt = new EdgeOptions(); // create object to setup option for edge driver
        opt.setHeadless(false);

        driver = new EdgeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();// maximize windows
        driver.get(baseUrl);

        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

    }

    @When("Input Username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User in on dashboard page")
    public void userInOnDashboardPage() {
        driver.findElement(By.xpath("//*[contains(text(),'Products')]"));
    }

    @When("Input Lockout Username")
    public void inputLockoutUsername() {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
    }

    @Then("User Get Error Message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//*[contains(text(),'Epic sadface: Sorry, this user has been locked out.')]")).getText();
        Assert.assertEquals(errorLogin,"Epic sadface: Sorry, this user has been locked out.");
        driver.close();
    }


    @Then("Click Add to Chart Bike Light")
    public void clickAddToChartBikeLight() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
    }


    @Then("Click Remove Chart")
    public void clickRemoveChart() {
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bike-light']")).click();
    }
}
