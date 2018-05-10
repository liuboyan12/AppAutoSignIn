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

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class App
	{
    	public static void main( String[] args ) throws MalformedURLException, InterruptedException 
    		{ 
    		String prints = System.getProperty("user.dir");
    		String relative_path = "\\screenShot\\test2.png" ;
    		String filepath = prints+relative_path;
    		
    		
    		int rgbR;
    		int rgbG;
    		int rgbB;
    		int minx = 0;
    		int miny = 0;
    		try {
    		File file = new File("E:\\dd.png");
    		BufferedImage image = ImageIO.read(file);
    		int width = image.getWidth();//图片宽度
    		int height = image.getHeight();//图片高度
    		for (int i = minx; i < width; i++) {  
    		for (int j = miny; j < height; j++) {  
    		int pixel = image.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字  
    		rgbR = (pixel & 0xff0000) >> 16;  
    		rgbG = (pixel & 0xff00) >> 8;  
    		rgbB = (pixel & 0xff);  
    		System.out.println("i=" + i + ",j=" + j + ":(" + rgbR + ","  + rgbG + "," + rgbB + ")");  
    		}  
    		} 
    		System.out.println("图片宽度为："+width+",高度为:"+height);
    		} catch (IOException e) {
    		System.out.println("读取文件出错");
    		e.printStackTrace();
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