package TestNg;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriver driver= new EdgeDriver();
		  driver.get("https://www.iipm.edu/");
		  TakesScreenshot Ts = (TakesScreenshot)driver;
		  File Loginpage= Ts.getScreenshotAs(OutputType.FILE);
		  File LoginTrg= new File("C:\\Users\\ganes\\eclipse-workspace\\Ganeshvarma\\Screenshots\\iipm.png");
		  FileUtils.copyFile(Loginpage,LoginTrg);

	}

}
