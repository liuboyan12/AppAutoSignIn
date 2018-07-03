package AppiumPractice.AppAutoSignIn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.android.AndroidDriver;

public class FalseInterface 
{	
	public static void main(String[] args) throws IOException 
	{
		FalseInterface thisJava =new FalseInterface();
		
		File file = new File("C:\\Users\\Administrator\\Desktop\\空.txt");//文件路径  
        FileReader fileReader = new FileReader(file);  
        LineNumberReader reader = new LineNumberReader(fileReader);
		String strings = reader.toString();
		reader.close();//问题在读取不了整个txt
		fileReader.close();
		System.out.println(strings);
//		String firstString  = "<";
//		String secondString = "index";
//		String replaceString = "node";
		
//		thisJava.stringReplaceInsert(strings,firstString,secondString,replaceString);
		strings = strings.replaceAll("(?<=<).*?(?= index)", "node");
		
		System.out.println(strings);
	}
    
	
	public  void falseInterface
		(@SuppressWarnings("rawtypes") AndroidDriver driver,String e) throws FileNotFoundException
	{
		/**
		 * 主程序
		 */
		FalseInterface us = new FalseInterface();
		long unixtime = new FalseInterface().unixTime();
		String fileName = "报错"+unixtime;
		String filepath = new FalseInterface().FilePath("");
		
		String filepath1 = filepath+"\\错误界面";
		us.floderExist(filepath1);
		
		filepath = filepath1+"\\"+"界面信息"+fileName;
		us.floderExist(filepath);
		
		String txtfilepath = filepath+"\\stopScreen.txt";
		String uixfilepath = filepath+"\\stopScreen.uix";
		us.fileExist(txtfilepath);
		
		String errorlog = filepath+"\\errorLog.txt";
		us.fileExist(errorlog);
		
		String pngpath = filepath+"\\stopScreen.png";
		String pagereXpath = driver.getPageSource();
		
		txtIO(txtfilepath, pagereXpath);
		txtIO(errorlog, e);
		screenShot(driver, pngpath);
		
		
		
		renameFile(txtfilepath, uixfilepath);
	}
	
	/*辅助方法*/
	
	@SuppressWarnings("unused")
	private String stringReplaceInsert(String strings,String starString,String endString,String replaceString) 
	{
		/**
		 * 传入字符串，找到对应的第一个字符串，找到要找的第二个字符串，然后截取中间的字符进行替换
		 * strings:要做修改的字符串
		 * starString：起始字符
		 * endString:结束字符
		 * replaceString：要替换进去的字符
		 * 该函数会替换所有找到的字符串对
		 */
		while(1<2) 
		{
			int index1 = strings.indexOf(starString);
			int index2 = strings.indexOf(endString);
			String ss = strings.substring(index1+1,index2-1);
			strings = strings.replaceAll(ss, replaceString);
			if(index1==-1 && index2 ==-1) 
			{
				break;
			}
			
		}
		return strings;
	}
	private long unixTime()
	{
		/**
		 * 获取当前的unix时间戳
		 * 
		 */
		long unixtime = System.currentTimeMillis();
		System.out.println(unixtime);
		return unixtime;
	}
	
	private String FilePath(String fileNameOrPath) 
	{
		/**
		 * 获取当前的文件路径
		 * 
		 */
		String path = System.getProperty("user.dir");
		path = path+"\\"+fileNameOrPath;
		System.out.println(path);
		return path;
	}
	
	private static void txtIO(String lujing,String neirong) throws FileNotFoundException
	{
		/**
		 * 文件写入操作，传入路径（lujing)和内容(neirong)
		 * 
		 */
		FileOutputStream fs = new FileOutputStream(new File(lujing));
		System.out.println(lujing);
		PrintStream p = new PrintStream(fs);
		p.println(neirong);
		p.close();
	}
	
	private static void screenShot(@SuppressWarnings("rawtypes") AndroidDriver driver,String sFilePath)  
	  {  
		/**
		 * 截图操作，传入driver和截图保存的地址
		 * 
		 */
	      File file=new File(sFilePath);  
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
	
	private void fileExist(String filepath) 
	{
		/**
		 * 判断文件是否存在
		 * 
		 */
		
		File file = new File(filepath);
		if (!file.exists()) 
		{
			try 
			{
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	private void floderExist(String filepath) {
		/**
		 * 判断文件夹是否存在
		 * 
		 */
		File file =new File(filepath);  
		if  (!file .exists()  && !file .isDirectory())    
		{     
		    System.out.println("//不存在");
		    file .mkdir();  
		} else 
		{
		    System.out.println("//目录存在");
		}
	}
	
	@SuppressWarnings("unused")
	private void renameFile(String file, String toFile) {
		/**
		 * 修改文件的扩展名，本例子中将txt修改为uix
		 */
        File toBeRenamed = new File(file);
        //检查要重命名的文件是否存在，是否是文件
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {
            System.out.println("File does not exist: " + file);
            return;
        }
        File newFile = new File(toFile);
        //修改文件名
        if (toBeRenamed.renameTo(newFile)) {
            System.out.println("File has been renamed.");
        } else {
            System.out.println("Error renmaing file");
        }
	} 
} 
	




