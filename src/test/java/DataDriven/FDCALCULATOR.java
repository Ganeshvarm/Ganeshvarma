package DataDriven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FDCALCULATOR {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		WebElement IniDeposit=driver.findElement(By.id("mat-input-0"));
		WebElement Length=driver.findElement(By.id("mat-input-1"));
		WebElement IntRate=driver.findElement(By.id("mat-input-2"));
		WebElement CalButton=driver.findElement(By.xpath("//*[@id=\"CIT-chart-submit\"]/div"));
		System.out.println("All Elements are Inspected");
		String path="C:\\Users\\ganes\\eclipse-workspace\\Ganeshvarma\\TestData\\caldata.xlsx";
		int rows=XLUTILS.getRowCount(path,"Sheet1");
		System.out.println("Row count:"+rows);
		for(int i=1;i<8;i++) {
			//reading excel
			String INDEP=XLUTILS.getcelldata(path, "Sheet1", i, 0);
			String INRATE=XLUTILS.getcelldata(path, "Sheet1", i, 1);
			String Month=XLUTILS.getcelldata(path, "Sheet1", i, 2);
			String EXPTOTAL=XLUTILS.getcelldata(path, "Sheet1", i, 4);
			IniDeposit.clear();
			Length.clear();
			IntRate.clear();
			IniDeposit.sendKeys(INDEP);
			Length.sendKeys(Month);
			IntRate.sendKeys(INRATE);
			CalButton.click();
			
			String ActualAmount=driver.findElement(By.xpath("//*[@id=\"displayTotalValue\"]")).getText();
			System.out.println(ActualAmount);
			if(EXPTOTAL.equals(ActualAmount))
			{
				XLUTILS.Setcelldata(path, "Sheet1", i,6,"Passed");
				XLUTILS.fillGreenColor(path, "Sheet1", i,6);
				
			}
			else {
				XLUTILS.Setcelldata(path, "Sheet1", i,6,"Failed");
				XLUTILS.fillRedColour(path, "Sheet1", i,6);
			}			
		}
	}

}
