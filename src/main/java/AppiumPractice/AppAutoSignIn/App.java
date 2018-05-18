package AppiumPractice.AppAutoSignIn;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
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
    		String packageName="com.cainiao.wireless";
        	String ActivityName=".homepage.presentation.view.activity.HomepageActivity";
        	@SuppressWarnings("rawtypes")
    		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),appInffo(packageName, ActivityName));
        	Thread.sleep(5000);
        	int overtimecode=0;
        	int times=0;
    		while(1<2) 
    		{
    			times++;
    			System.out.println("次数"+times);
    			if(overtimecode>49) 
    			{
    				break;
    			}else {
    				overtimecode=overtimecode+1;
    			}
    			String as1 =driver.getScreenshotAs(OutputType.BASE64);
        		Thread.sleep(500);
        		String as2 =driver.getScreenshotAs(OutputType.BASE64);
        		Thread.sleep(500);
        		{
        			Random rand = new Random();
        			int as1length = as1.length();
        			int as2length = as2.length();
        			if(as1length==as2length) 
        			{
        				ArrayList<Integer> list=new ArrayList<Integer>();
        				String listout = "";
        				for(int foricode=0;foricode<5;foricode++) 
            			{	
        					int randome_range = as1length-11;
            				int random_num = rand.nextInt(randome_range);
            				String ras1=as1.substring(random_num,random_num+10);
                    		String ras2=as2.substring(random_num,random_num+10);
                    		if(ras1.equals(ras2)) 
                    		{
                    			list.add(1);
                    			listout=listout+1;
                    		}else{
                    			list.add(0);
                    			listout=listout+0;
                    		}
                    		
                    		
            			}
        				System.out.println(listout);
        				int breakcode = 1;
                		for(int forcodei1=0;forcodei1<list.size();forcodei1++) 
                		{
                			int panduan = list.get(forcodei1);
                			if(panduan==0) 
                			{
                				breakcode=2;
                			}else {
                				continue;
                			}
                		}
                		if(breakcode==2) 
                		{
                			continue;
                		}else {
                			break;
                		}
        			}else {
        				continue;
        			}
        		}
    		}
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