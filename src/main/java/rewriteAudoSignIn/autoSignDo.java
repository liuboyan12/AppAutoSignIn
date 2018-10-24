package rewriteAudoSignIn;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

/**
 * 
 * @author Aliun.King
 * 用于存放签到脚本用到的方法
 */
@SuppressWarnings("rawtypes")
public class autoSignDo {
	
	
	 // [x1,y1][x2,y2]区域的中间，传入string必须为前面的格式
	 void touchmiddle(AndroidDriver driver, String strings) {
		int A, B, C, D = 0;
		String str1 = strings.substring(strings.indexOf("[") + 1, strings.indexOf(","));
		String str2 = strings.substring(strings.indexOf(",") + 1, strings.indexOf("]"));
		StringBuilder sb = new StringBuilder(strings);
		sb.replace(strings.indexOf("["), strings.indexOf("]") + 1, "*");
		strings = sb.toString();
		String str3 = strings.substring(strings.indexOf("[") + 1, strings.indexOf(","));
		String str4 = strings.substring(strings.indexOf(",") + 1, strings.indexOf("]"));
		A = Integer.parseInt(str1);
		B = Integer.parseInt(str2);
		C = Integer.parseInt(str3);
		D = Integer.parseInt(str4);
		int x = (int) (C - A) / 2 + A;
		int y = (int) (D - B) / 2 + B;
		int b1 = driver.manage().window().getSize().width;
		int b2 = driver.manage().window().getSize().height;
		int xfinal = (int) (x * b1 / 1080);
		int yfinal = (int) (y * b2 / 1920);
		touch(driver, xfinal, yfinal);
		
	}

	 //	 点击x,y坐标
	 void touch(AndroidDriver driver, int x, int y) {
		int b1 = driver.manage().window().getSize().width;
		int b2 = driver.manage().window().getSize().height;
		int xfinal = (int) (x * b1 / 1080);
		int yfinal = (int) (y * b2 / 1920);
		System.out.println("点击"+xfinal+"  "+yfinal);
		TouchAction action = new TouchAction(driver);
		action.tap(xfinal, yfinal).perform();
		
	}

	 // 等待一定时间：如果超时报错
	 void untilTimeOut(AndroidDriver driver, String Xpath, int timeout) {
		 String kongjianming = Xpath.substring(Xpath.indexOf("=")+1, Xpath.indexOf("]"));
		 System.out.println("等待界面Xpaht控件： "+kongjianming+" 等待极限： "+timeout+"秒");
		 try {
			 WebDriverWait wait = new WebDriverWait(driver, timeout);
			 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Xpath)));
		 }catch (Exception e) {
			 System.out.println("等待超时（"+timeout+"秒)");
			 driver.findElement(By.xpath(Xpath));
		}
	}
	 
	 //  等待int秒后通过Xpath点击
	 void stepXTimeOut(AndroidDriver driver, String Xpath, int timeout) {
		String kongjianming = Xpath.substring(Xpath.indexOf("=")+1, Xpath.indexOf("]"));;
		untilTimeOut(driver, Xpath, timeout);
		System.out.println("点击："+kongjianming);
		driver.findElement(By.xpath(Xpath)).click();
	}
	 
	 //  滑动从x1,y1滑动到x2,y2
	 void swipTo(AndroidDriver driver, int X1, int Y1, int X2, int Y2) {
		System.out.println("从("+X1+","+Y1+")滑动到("+X2+","+Y2+")");
		TouchAction action1 = new TouchAction(driver);
		action1.longPress(X1, Y1).moveTo(X2, Y2).release().perform();
	}

	 //  往Xpath找到的控件里面输入字符
	 void sendTextX(AndroidDriver driver, String Xpath, String x) {
		String kongjianming = Xpath.substring(Xpath.indexOf("=")+1, Xpath.indexOf("]"));
		System.out.println("向 "+kongjianming+" 输入 "+x);
		driver.findElement(By.xpath(Xpath)).sendKeys(x);
	}

	 //  判断是否存在Xpath的元素
	 int existX(AndroidDriver driver, String Xpath) { 
		// 存在为1不存爱为0
		String kongjianming = Xpath.substring(Xpath.indexOf("=")+1, Xpath.indexOf("]"));
		int fund_icon = -1;
		try {
			driver.findElement(By.xpath(Xpath));
			System.out.println("存在 "+kongjianming+" 返回值为1");
			fund_icon = 1;
		} catch (Exception e) {
			System.out.println("不存在 "+kongjianming+" 返回值为0");
			fund_icon = 0;
		}
		return fund_icon;
	}
	
//================================================Driver信息================================================
	public AndroidDriver rundriver(String packageName, String ActivityName, String deviceName) throws MalformedURLException {
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				this.appInffo(packageName, ActivityName, deviceName));
		System.out.println("启动");
		return driver;
	}
	
	DesiredCapabilities appInffo(String deviceName, String packageName, String ActivityName) {
		DesiredCapabilities capa = new DesiredCapabilities();
		capa.setCapability("deviceName", deviceName);//741AECR82S8DFmeizuE2
		capa.setCapability("automationName", "Appium");
		capa.setCapability("platformNme", "Android");
		capa.setCapability("platformVersion", "5.1.1");
		capa.setCapability("appPackage", packageName);
		capa.setCapability("appActivity", ActivityName);
		capa.setCapability("noReset", true);
		return capa;
	}

	
	
}
