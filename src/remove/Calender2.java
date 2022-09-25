import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Calender2 {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();

		//Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");

		//Set path for driver exe 
		

		System.setProperty("webdriver.chrome.driver", "F:\\software\\chromedriver_win32\\chromedriver.exe");

		 WebDriver driver = new ChromeDriver(options);  
         
         driver.get("https://www.goibibo.com");  
           
         driver.manage().window().maximize(); 
       
         String year_to_be_selected = "2020";
         String month = "June";
         String day_to_be_selected = "18";
         
         driver.findElement(By.xpath("//input[@placeholder='Departure']")).click();
         
       
      // System.out.println(months.getText());
       int flag=0;
       
       while(flag==0)
       {
    	   WebElement months =  driver.findElement(By.xpath("//div[@class='DayPicker-Month']/div[1]"));
    	   String month_select = months.getText();
    	   String[] str = month_select.split(" ");
    	   //System.out.println(str[0]);
    	   
    	   if(str[1].equals(year_to_be_selected))
    	   {
    		   
    	    if(str[0].equals(month))
    	   {
    		   for(int i=1;i<=5;i++)
    		   {
    			   String day = null;
    			   WebElement element;
    			   for(int j=1;j<=7;j++)
    			   {
    				  try{ 
    				 element=  driver.findElement(By.xpath("//div[@class='DayPicker-Month']/div[3]/div["+i+"]/div["+j+"]/div"));
    				 
    				  }catch(Exception e)
    				  {
    					  
    					  continue;
    				  }
    				  
    				  day=element.getText();
     				// System.out.println(day);
    				 if(day.equals(day_to_be_selected))
    				 {
    					 flag=1;
    					 driver.findElement(By.xpath("//div[@class='DayPicker-Month']/div[3]/div["+i+"]/div["+j+"]/div")).click();
    					 break;
    					 
    				 }
    			   }
    		   }
    		   
    		   
    		   
    	   }
    	   else
    	   {
    		   driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
    	   }
       }
    	   else
    	   {
    		   driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
    	   }
      
       

	}

}
}
