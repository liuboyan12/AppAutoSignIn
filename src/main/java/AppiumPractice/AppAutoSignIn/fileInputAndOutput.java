package AppiumPractice.AppAutoSignIn;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileInputAndOutput {
	public static void main(String[] args) throws IOException 
		
	{
		fileInputAndOutput use = new fileInputAndOutput();
		use.txtInput("C:\\Users\\Administrator\\Desktop\\新建文本文档.txt", "lalal");
		
	}

	public void txtInput(String filepath,String content) throws IOException 
	{
		fileInputAndOutput driver = new fileInputAndOutput();
		driver.fileExist(filepath);
		BufferedWriter output = new BufferedWriter(new FileWriter(filepath));
		output.write(content);
		output.close();
		
	}
	public void fileExist(String filepath) 
	{

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
	
	public void floderExist(String filepath) {
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
	
	
	
	

}
