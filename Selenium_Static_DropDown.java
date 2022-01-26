import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium_Static_DropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
         System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
         WebDriver driver=new ChromeDriver();
         driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
         
         
         //drop down with select static tag
         WebElement staticDropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
         //This methods of choosing drop down will work only when there is 'select' option available in dom page in devtools
         Select dropdown= new Select(staticDropdown);
         dropdown.selectByIndex(2);
         System.out.println(dropdown.getFirstSelectedOption().getText());
         dropdown.selectByVisibleText("USD");
         System.out.println(dropdown.getFirstSelectedOption().getText());
         dropdown.selectByValue("INR");
         System.out.println(dropdown.getFirstSelectedOption().getText());
         Thread.sleep(3000);
         
         
         //Dynamic drop down handling with index and child parent concepts
//         driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='GOI']")).click();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='CCU']")).click();
//         Thread.sleep(1000);
         //if above one is index wise then it looks like below
         driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("(//a[@value='GOI'])[1]")).click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("(//a[@value='CCU'])[2]")).click();
         Thread.sleep(1000);
         


         
         
         
         //Autosuggestive drop down
         driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ge");
         Thread.sleep(3000);
         List<WebElement> options= driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
         for(WebElement option : options) {
        	 if(option.getText().equalsIgnoreCase("Germany")) {
        		 
        		 option.click();
        		 
        	 }
         }
         
         
         
         
         
         
         

         
	}

}
