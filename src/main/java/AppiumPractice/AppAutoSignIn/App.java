package AppiumPractice.AppAutoSignIn;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.primitives.Bytes;

import io.appium.java_client.android.AndroidDriver;

public class App
	{
    	public static void main( String[] args ) throws InterruptedException, IOException 
    		{ 
    		String packageName="com.android.settings";
        	String ActivityName=".Settings";
        	@SuppressWarnings("rawtypes")
    		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),appInffo(packageName, ActivityName,"810EBND57TB9","5.1"));
        	
    		int finalY =driver.manage().window().getSize().height;
    		int finalX =driver.manage().window().getSize().width;
    		System.out.println(finalY);
    		System.out.println(finalX);
    	
    		driver.quit();
    	    }  
    	
            
    		
    	public static void txtIO(String lujing,String neirong) throws FileNotFoundException
    		{
	    		FileOutputStream fs = new FileOutputStream(new File(lujing));
	    		PrintStream p = new PrintStream(fs);
	    		p.println(neirong);
	    		p.close();
    		}	
    		
    	    public static byte[] getFileToByte(File file) {  
    	        byte[] by = new byte[(int) file.length()];  
    	        try {  
    	            InputStream is = new FileInputStream(file);  
    	            ByteArrayOutputStream bytestream = new ByteArrayOutputStream();  
    	            byte[] bb = new byte[2048];  
    	            int ch;  
    	            ch = is.read(bb);  
    	            while (ch != -1) {  
    	                bytestream.write(bb, 0, ch);  
    	                ch = is.read(bb);  
    	                System.out.println("ch : " + ch);  
    	            }  
    	            by = bytestream.toByteArray();  
    	        } catch (Exception ex) {  
    	            ex.printStackTrace();  
    	        }  
    	        return by;  
    	    }  
    	
    	
    	
    	  static DesiredCapabilities appInffo(String packageName,String ActivityName,String deviceName,String platformVersion) 
    	  {
    		  	String a0="741AECR82S8DF";  
    		    String b0="6.0.1";  
    		    if(!(deviceName==null||deviceName.equals("")))  
    		    {  
    		        a0=deviceName;  
    		    }
    		    if(!(platformVersion==null||platformVersion.equals("")))  
    		    {  
    		        b0=platformVersion;  
    		    }
    		  DesiredCapabilities capa = new DesiredCapabilities();
    	      capa.setCapability("deviceName", a0);//741AECR82S8DF
    	      capa.setCapability("automationName", "Appium");
    	      capa.setCapability("platformNme", "Android");
    	      capa.setCapability("platformVersion",b0);
    	      capa.setCapability("appPackage", packageName);
    	      capa.setCapability("appActivity", ActivityName);
    	      capa.setCapability("noReset", true);
    	  	return capa;
    	  }
    	  
    	  public static void screenShot(@SuppressWarnings("rawtypes") AndroidDriver driver,String sFilePath)  
    	  {  
    	      File file=new File(sFilePath);  
    	      // 如果截图存在先删除  
    	      try {  
    	          if(file.exists())  
    	          {  
    	              file.delete();  
    	          }  
    	      } catch (Exception e) {  
    	          e.printStackTrace();  
    	      }  
    	      // 截图  
    	      File newFile=driver.getScreenshotAs(OutputType.FILE);  
    	      try {  
    	          FileUtils.copyFile(newFile, file);  
    	      } catch (IOException e) {  
    	          e.printStackTrace();  
    	      }     
    	  }  
    }