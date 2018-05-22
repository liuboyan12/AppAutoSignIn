package AppiumPractice.AppAutoSignIn;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class KoudaiJizhang 
{
	public static void main( String[] args ) throws MalformedURLException, InterruptedException 
	{
		run();
	}

	@SuppressWarnings("rawtypes")
	private static void run() throws InterruptedException, MalformedURLException 
	{
		String packageName = "com.qeeniao.mobile.kdjz";
    	String ActivityName = ".BlankActivity"; 	
    	@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),appInffo(packageName, ActivityName));
    	Thread.sleep(3000);
    	TouchAction action  = new TouchAction(driver);
    	
    	stepX(driver, "//android.widget.TextView[@text='理财']");
    	Thread.sleep(3000);
    	int q=0;
    	while(1<2)
    		{
    			try 
    			{
    				List xpathList = driver.findElements(By.xpath("//android.widget.TextView[@text='领取']"));
    				int e =  xpathList.size();
        			
        			for(int i=0;i<e;i++)
        			{
        				driver.findElement(By.xpath("//android.widget.TextView[@text='领取']")).click();
        				q++;
        				try {	
        						Thread.sleep(2000);
        						driver.findElement(By.xpath("//android.widget.TextView[@text='立即收取']")).click();
        						Thread.sleep(1000);
        						
        					}catch (Exception p) {
        						Thread.sleep(1000);
        						driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
    						}
        			}
        			System.out.println("领取次数："+q);
    			}catch (Exception e) {}
    			Thread.sleep(20000);
    		}

	}
	
	
	
	
	
	
	
	
	static DesiredCapabilities appInffo(String packageName,String ActivityName) 
	  	{
		  	DesiredCapabilities capa = new DesiredCapabilities();
		    capa.setCapability("deviceName", "741AECR82S8DF");//741AECR82S8DF
		    capa.setCapability("automationName", "Appium");
		    capa.setCapability("platformNme", "Android");
		    capa.setCapability("platformVersion", "6.0.1");
		    capa.setCapability("appPackage", packageName);
		    capa.setCapability("appActivity", ActivityName);
		    capa.setCapability("noReset", true);
		  	return capa;
	  	}
    static void untilX(@SuppressWarnings("rawtypes") AndroidDriver driver,String Xpath) 
	    {
	    	WebDriverWait wait = new WebDriverWait(driver,60);
	    	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Xpath)));
	    }
    static void clickx(@SuppressWarnings("rawtypes") AndroidDriver driver,String Xpath)
	    {
	    	driver.findElement(By.xpath(Xpath)).click();
	    }
    
    static void stepX(@SuppressWarnings("rawtypes") AndroidDriver driver,String Xpath)
	    {
	    	untilX(driver,Xpath);
	    	clickx(driver,Xpath);
	    }
}
