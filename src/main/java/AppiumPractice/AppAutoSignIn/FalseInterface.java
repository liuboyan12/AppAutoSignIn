package AppiumPractice.AppAutoSignIn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.android.AndroidDriver;

public class FalseInterface 
{	
	public static void main(String[] args) throws IOException 
	{

	}
	
	
	
	public  String falseInterface
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
		String strings = pagereXpath;
		strings = strings.replace("</hierarchy>", "@@@@@@@@@@@");
		strings = strings.replaceAll("(?<=</).*?(?=>)", "node");
		strings = strings.replaceAll("</node>", "###");
		strings = strings.replaceAll("(?<=<).*?(?= index)", "node");
		strings = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><hierarchy rotation=\"0\">"+strings;
		strings = strings.replace("@@@@@@@@@@@","</hierarchy>");
		pagereXpath = strings.replaceAll("###", "</node>");
		
		txtIO(txtfilepath, pagereXpath);
		txtIO(errorlog, e);
		screenShot(driver, pngpath);

		renameFile(txtfilepath, uixfilepath);
		return txtfilepath;
	}
	
	/*辅助方法*/
	
	public static String readTxtFile(String filePath){
		/**（暂未用到）
		 * 读取文本文件，返回文本文件内容
		 * 
		 */
		String returnresult ="";
        try {
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        returnresult=returnresult+lineTxt;
                        
                    }
                    read.close();
                    
        }else{
//            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
//            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        
		return returnresult;
      
    }
	
	@SuppressWarnings("unused")
	private String stringReplaceInsert(String strings,String starString,String endString,String replaceString) 
	{
		/**暂未用到可以用(?<=<).*?(?= index)替代的
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
//		System.out.println(path);
		return path;
	}
	
	private static void txtIO(String lujing,String neirong) throws FileNotFoundException
	{
		/**
		 * 文件写入操作，传入路径（lujing)和内容(neirong)
		 * 
		 */
		FileOutputStream fs = new FileOutputStream(new File(lujing));
//		System.out.println(lujing);
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
//		    System.out.println("//不存在");
		    file .mkdir();  
		} else 
		{
//		    System.out.println("//目录存在");
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
//            System.out.println("File does not exist: " + file);
            return;
        }
        File newFile = new File(toFile);
        //修改文件名
        if (toBeRenamed.renameTo(newFile)) {
//            System.out.println("File has been renamed.");
        } else {
//            System.out.println("Error renmaing file");
        }
	} 
} 
	




