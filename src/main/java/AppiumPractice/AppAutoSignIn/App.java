package AppiumPractice.AppAutoSignIn;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.primitives.Bytes;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class App {
	public static void main(String[] args) throws MalformedURLException, FileNotFoundException {
//++++++++++++++++++++++++++++++++++++++++++++包+++++++++++++++++++++++++++++++++++++++
		String packageName = "com.eg.android.AlipayGphone";
		String ActivityName = ".AlipayLogin";
//++++++++++++++++++++++++++++++++++++++++++++包+++++++++++++++++++++++++++++++++++++++
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName, "", ""));// "810EBND57TB9","5.1"
		FalseInterface transfer = new FalseInterface();
		try {
//++++++++++++++++++++++测试代码段+++++++++++++++++++++++++++++++++++++++++++++++++++++++
			Thread.sleep(30000);
			transfer.falseInterface(driver, "1");
			
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++结束测试端+++++
		} catch (Exception e) {
			String error = e.toString();
			transfer.falseInterface(driver, error);
		}

	}

	public static void txtIO(String lujing, String neirong) throws FileNotFoundException {
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

	static DesiredCapabilities appInffo(String packageName, String ActivityName, String deviceName,
			String platformVersion) {
		String a0 = "741AECR82S8DF";
		String b0 = "6.0.1";
		if (!(deviceName == null || deviceName.equals(""))) {
			a0 = deviceName;
		}
		if (!(platformVersion == null || platformVersion.equals(""))) {
			b0 = platformVersion;
		}
		DesiredCapabilities capa = new DesiredCapabilities();
		capa.setCapability("deviceName", a0);// 741AECR82S8DF
		capa.setCapability("automationName", "Appium");
		capa.setCapability("platformNme", "Android");
		capa.setCapability("platformVersion", b0);
		capa.setCapability("appPackage", packageName);
		capa.setCapability("appActivity", ActivityName);
		capa.setCapability("noReset", true);
		return capa;
	}

	public static void screenShot(@SuppressWarnings("rawtypes") AndroidDriver driver, String sFilePath) {
		File file = new File(sFilePath);
		// 如果截图存在先删除
		try {
			if (file.exists()) {
				file.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 截图
		File newFile = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(newFile, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void touch(@SuppressWarnings("rawtypes") AndroidDriver driver, int x, int y) {
		int b1 = driver.manage().window().getSize().width;
		int b2 = driver.manage().window().getSize().height;

		int xfinal = (int) (x * b1 / 1080);
		int yfinal = (int) (y * b2 / 1920);

		TouchAction action = new TouchAction(driver);
		action.tap(xfinal, yfinal).perform();
	}

	static void untilX(@SuppressWarnings("rawtypes") AndroidDriver driver, String Xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Xpath)));
	}

	static void untilTimeOut(@SuppressWarnings("rawtypes") AndroidDriver driver, String Xpath, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Xpath)));
	}

	static void clickx(@SuppressWarnings("rawtypes") AndroidDriver driver, String Xpath) {
		driver.findElement(By.xpath(Xpath)).click();
	}

	static void stepX(@SuppressWarnings("rawtypes") AndroidDriver driver, String Xpath) {
		untilX(driver, Xpath);
		clickx(driver, Xpath);
	}

	static void stepXTimeOut(@SuppressWarnings("rawtypes") AndroidDriver driver, String Xpath, int timeout) {
		untilTimeOut(driver, Xpath, timeout);
		clickx(driver, Xpath);
	}

	static void stepID(@SuppressWarnings("rawtypes") AndroidDriver driver, String ID) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(ID)));

		driver.findElement(By.id(ID));
	}

	static void swipTo(@SuppressWarnings("rawtypes") AndroidDriver driver, int X1, int Y1, int X2, int Y2) {
		TouchAction action1 = new TouchAction(driver);
		action1.longPress(X1, Y1).moveTo(X2, Y2).release().perform();
	}

	static void Mistake(String x, String e) {
		System.out.println(x + "出错" + e);
	}

	static void textX(@SuppressWarnings("rawtypes") AndroidDriver driver, String Xpath, String x) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Xpath)));
		driver.findElement(By.xpath(Xpath)).sendKeys(x);
	}
	static  void touchmiddle(@SuppressWarnings("rawtypes") AndroidDriver driver,String strings) {
//		[864,1867][1080,1908]
		int A,B,C,D=0;
		String str1 = strings.substring(strings.indexOf("[")+1, strings.indexOf(","));
		String str2 = strings.substring(strings.indexOf(",")+1, strings.indexOf("]"));
		StringBuilder sb = new StringBuilder(strings);
		sb.replace(strings.indexOf("["), strings.indexOf("]")+1, "*");
		strings = sb.toString();
		String str3 = strings.substring(strings.indexOf("[")+1, strings.indexOf(","));
		String str4 = strings.substring(strings.indexOf(",")+1, strings.indexOf("]"));
		A=Integer.parseInt(str1);
		B=Integer.parseInt(str2);
		C=Integer.parseInt(str3);
		D=Integer.parseInt(str4);
			
		int x = (int)(C-A)/2+A;
		int y = (int)(D-B)/2+B;
		System.out.println(" "+x+" "+y);
		touch(driver, x, y);
		
	}
}