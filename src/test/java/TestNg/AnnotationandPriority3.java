package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class AnnotationandPriority3 {

	WebDriver driver;
    @Test(priority=1)
    void openApp()
    {
    	driver=new EdgeDriver();
    	driver.get("https://demo.guru99.com/v4");
    }
    @Test(priority=2,groups= {"sanity"})
    void Login()
    {
    	driver.findElement(By.name("uid")).sendKeys("mngr266311");
    	driver.findElement(By.name("password")).sendKeys("12345678@");
    	driver.findElement(By.name("btnLogin")).click();
    }
    @Test(priority=3,groups= {"sanity","Regression"})
    void search()
    {
    	System.out.println("This is Search");
    }
    @Test(priority=4,groups= {"sanity"})
    void closeApp()
    {
    	driver.close();
    }
}
