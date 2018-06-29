package AppiumPractice.AppAutoSignIn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.android.AndroidDriver;

public class FalseInterface 
{
	public static void main(String[] args) throws IOException 
	{

		long unixtime = new FalseInterface().unixTime();
		String fileName = unixtime+"报错界面";
		String filepath = new FalseInterface().FilePath(fileName);
		System.out.println(filepath);
		File file=new File("错误界面"+filepath);  
		file .mkdir() ;
	
		String Neirong = "111";
//		txtIO(filepath,Neirong);
				
		
	}
	
	public void falseInterface(@SuppressWarnings("rawtypes") AndroidDriver driver)
	{
		String pageresource = driver.getPageSource();
//		txtIO();
	}
	
	public long unixTime()
	{
		long unixtime = System.currentTimeMillis();
		System.out.println(unixtime);
		return unixtime;
	}
	
	public String FilePath(String fileNameOrPath) 
	{
		String path = System.getProperty("user.dir");
		path = path+"\\"+fileNameOrPath;
		System.out.println(path);
		return path;
	}
	
	
	
	public static void txtIO(String lujing,String neirong) throws FileNotFoundException
	{
		FileOutputStream fs = new FileOutputStream(new File(lujing));
		System.out.println(lujing);
		PrintStream p = new PrintStream(fs);
		p.println(neirong);
		p.close();
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


