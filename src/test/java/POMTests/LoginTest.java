package POMTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POM.LoginPage;

public class LoginTest {
    WebDriver driver;
    LoginPage OBJLoginPage;
    @Test(priority=1)
    void Setup()
    {
    	driver=new EdgeDriver();
    	OBJLoginPage=new LoginPage(driver);
    	
    	OBJLoginPage.URL();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
    }
    @Test(priority=2)
    void Header()
    {
    	OBJLoginPage.VerifyHeader();
    }
    @Test(priority=3)
    void Login()
    {
    	OBJLoginPage.VerifyLogin();
    }
    @Test(priority=4)
    void CloseApp()
    {
    	driver.close();
    }
}
