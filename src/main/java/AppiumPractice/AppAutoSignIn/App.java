package AppiumPractice.AppAutoSignIn;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class App
	{
    	public static void main( String[] args ) throws InterruptedException, IOException 
    		{ 
    		int rgbR;
    		int rgbG;
    		int rgbB;
    		int i,j;
    		
    		int size = 100;
    		int[] ifcode=new int[size];
    		
    		
    		String prints = System.getProperty("user.dir");
    		String relative_path = "\\screenShot\\test2.png" ;
    		String filepath = prints+relative_path;
    		
    		String prints2 = System.getProperty("user.dir");
    		String relative_path2 = "\\screenShot\\test2.png" ;
    		String filepath2 = prints2+relative_path2;
    		
    		Random rand = new Random();

    		try {
        		File file = new File(filepath);
        		BufferedImage image = ImageIO.read(file);
        		
        		File file2 = new File(filepath2);
        		BufferedImage image2 = ImageIO.read(file2);
        		
        		
        		int width = image.getWidth();//图片宽度
        		int height = image.getHeight();//图片高度
        		
        	
        		for(int forcode=0;forcode<100;forcode++) //循环
        		{
        			i = rand.nextInt(width);
            		j = rand.nextInt(height);//选点
            		{
            			
            			int pixel1 = image.getRGB(i, j); //取1
            			int pixel2 = image2.getRGB(i, j);//取2
            			{
            				if(pixel1 == pixel2) 
            				{
            					ifcode[forcode]=0;
            				}else {
            					ifcode[forcode]=-1;
            				}
            			}
            			
            		}
        		}
        		
        		for(int forcode1 = 0;forcode1<ifcode.length;forcode1++) 
        		{
        			
        		}
        		
        		
    		}catch (Exception e) {
    			System.out.println(e.toString());
			}
    		
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