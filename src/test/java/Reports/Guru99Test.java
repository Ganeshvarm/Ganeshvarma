package Reports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Guru99Test {
    WebDriver driver;
    @Test
    void OpenApp()
    {
        driver=new EdgeDriver();
        driver.get("https://demo.guru99.com/v4");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test(priority=1)
    void Login()
    {
    	driver.findElement(By.name("uid")).sendKeys("mngr266311");
        driver.findElement(By.name("password")).sendKeys("12345678@");
        driver.findElement(By.name("btnLogin")).click();
    }
    @Test(priority=2,dependsOnMethods="Login")
    void TearDown()
    {
    	driver.quit();
    	
    }
}
