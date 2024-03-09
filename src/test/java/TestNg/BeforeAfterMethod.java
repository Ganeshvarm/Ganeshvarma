package TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterMethod {
     WebDriver driver;
     @BeforeMethod
     void openApp()
     {
    	driver=new EdgeDriver();
    	driver.get("https://demo.guru99.com/v4");
     }
     @Test(priority=1)
     void Login()
     {
    	driver.findElement(By.name("uid")).sendKeys("mngr266311");
     	driver.findElement(By.name("password")).sendKeys("12345678@");
     	driver.findElement(By.name("btnLogin")).click();	 
     }
     @Test(priority=2)
     void search()
     {
        System.out.println("This is search");	 
     }
     @AfterMethod
     void close()
     {
        driver.close();
     }
}
