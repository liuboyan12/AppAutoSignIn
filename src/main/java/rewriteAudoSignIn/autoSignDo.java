package rewriteAudoSignIn;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AppiumPractice.AppAutoSignIn.FalseInterface;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * 
 * @author Aliun.King
 * 用于存放签到脚本用到的方法
 */
@SuppressWarnings("rawtypes")
public class autoSignDo {
	
	// 等待
	void deng(int times) throws InterruptedException {
		System.out.println("等待"+times+"秒");
		Thread.sleep((long) (times*1000));
	}
	
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
		 System.out.println("等待Xpath控件： "+kongjianming+" 等待极限： "+timeout+"秒");
		 try {
			 WebDriverWait wait = new WebDriverWait(driver, timeout);
			 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Xpath)));
		 }catch (Exception e) {
			 System.out.println("界面内无"+kongjianming+"等待超时（"+timeout+"秒)");
			 System.out.println("控件Xpath： "+Xpath);
			 driver.findElement(By.xpath(Xpath));
		}
	}
	 
	 //  等待int秒后通过Xpath点击
	 void stepXTimeOut(AndroidDriver driver, String Xpath, int timeout) {
		String kongjianming = Xpath.substring(Xpath.indexOf("=")+1, Xpath.indexOf("]"));;
		untilTimeOut(driver, Xpath, timeout);
		System.out.println("点击Xpath控件："+kongjianming);
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
	 int existXpathTimeOut(AndroidDriver driver, String Xpath,int timeOut) { 
		// 存在为1不存爱为0
		String kongjianming = Xpath.substring(Xpath.indexOf("=")+1, Xpath.indexOf("]"));
		int fund_icon = -1;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Xpath)));
			System.out.println("存在 "+kongjianming+" 返回值为1");
			fund_icon = 1;
		} catch (Exception e) {
			System.out.println("不存在 "+kongjianming+" 返回值为0,Xpath："+Xpath);
			fund_icon = 0;
		}
		return fund_icon;
	}
	 
	 //监测一个时间段后界面是否一致
	 void staticPicMonitor(AndroidDriver driver,int intervalSecond) throws InterruptedException {
			/**
			 * 监测两个界面是否一致，在intervalSecond的间隔后的图像如果跟当前图像一致，那么函数结束，否则
			 * 该函数将持续不断进行间隔测试，直到进行50*intervalSecond时间后进行报错弹出继续下面的代码
			 * 
			 * 该函数是循环判断直到有两个一样的界面出现或者是来回反复监测的，intervalSecond实际上除了控制时长还有控制
			 * 两次截图之间的精度问题
			 */
			@SuppressWarnings("unused")
			int times=0,overtimecode=0;
			while(1<2) {
				times++;

				if (overtimecode > 49) {
					System.out.println("监测超时，没有检测到相同的界面");
					break;
				} else {
					overtimecode++;
				}
				String as1 = driver.getScreenshotAs(OutputType.BASE64);
				Thread.sleep(intervalSecond*1000);
				String as2 = driver.getScreenshotAs(OutputType.BASE64);
				Thread.sleep(500);
				{
					Random rand = new Random();
					int as1length = as1.length();
					int as2length = as2.length();
					if (as1length == as2length) {
						ArrayList<Integer> list = new ArrayList<Integer>();
						String listout = "";
						for (int foricode = 0; foricode < 5; foricode++) {
							int randome_range = as1length - 11;
							int random_num = rand.nextInt(randome_range);
							String ras1 = as1.substring(random_num, random_num + 10);
							String ras2 = as2.substring(random_num, random_num + 10);
							if (ras1.equals(ras2)) {
								list.add(1);
								listout = listout + 1;
							} else {
								list.add(0);
								listout = listout + 0;
							}
						}
						System.out.println(listout);
						int breakcode = 1;
						for (int forcodei1 = 0; forcodei1 < list.size(); forcodei1++) {
							int panduan = list.get(forcodei1);
							if (panduan == 0) {
								breakcode = 2;
							} else {
								continue;
							}
						}
						if (breakcode == 2) {
							continue;
						} else {
							break;
						}
					} else {
						continue;
					}
				}
			}}
			
	 //返回键 BACK
	 void back(AndroidDriver driver) {
		 System.out.println("按键：返回（BACK)");
		 driver.pressKeyCode(AndroidKeyCode.BACK);
	 }
	 
	 //退出
	 void tuichu(AndroidDriver driver,String appName) {
		 driver.quit();
		 System.out.println("退出APP "+appName);
		 System.out.println("==================================================================");
	 }
	 
	 //找到某个Xpath控件，输入Y的固定坐标，从Xpath的X位置移动到X
	 void fromXpathMoveX(AndroidDriver driver,String Xpath,int Y,int X) {
		 String kongjianming = Xpath.substring(Xpath.indexOf("=")+1, Xpath.indexOf("]"));
		 System.out.println("获取Xpath控件: "+kongjianming+" 位置");
		 int xwdyt = driver.findElement(By.xpath(Xpath)).getLocation().x;
		 System.out.println(kongjianming+" 横坐标为 "+xwdyt);
			swipTo(driver,xwdyt, Y, X, Y );
	 }
	 
	//找到某个Xpath控件，输XY的固定坐标，从Xpath的Y位置移动到Y
	 void fromXpathMoveY(AndroidDriver driver,String Xpath,int X,int Y) {
		 String kongjianming = Xpath.substring(Xpath.indexOf("=")+1, Xpath.indexOf("]"));
		 System.out.println("获取Xpath控件: "+kongjianming+" 位置");
		 int ywdyt = driver.findElement(By.xpath(Xpath)).getLocation().y;
		 System.out.println(kongjianming+" 纵坐标为 "+ywdyt);
			swipTo(driver, X, ywdyt, X, Y);
	 }
	 
	 //错误界面截图
	 void mistakeShotScreen(AndroidDriver driver,Exception e) throws FileNotFoundException {
		 FalseInterface falesdriver = new FalseInterface();
		 System.out.println("xxxxxxxxxxxxx界面报错xxxxxxxxxxxxx");
		 String error = e.toString();
		String path = falesdriver.falseInterface(driver, error);
		System.out.println("报错储存路径："+path);
	 }
	 
	 //界面截圖
	 void ShotScreen(AndroidDriver driver,String saveString) throws FileNotFoundException {
		 FalseInterface falesdriver = new FalseInterface();
		 System.out.println("xxxxxxxxxxxxx界面截图xxxxxxxxxxxxx");
		 System.out.println();
		String path = falesdriver.falseInterface(driver, saveString);
		System.out.println("截图储存路径："+path);
	 }
	 
	 //获取Xpath控件的y坐标
	 int getXpathY(AndroidDriver driver,String Xpath) {
		 String kongjianming = Xpath.substring(Xpath.indexOf("=")+1, Xpath.indexOf("]"));
		 int y = driver.findElement(By.xpath(Xpath)).getLocation().y;
		 System.out.println("获取Xpath控件: "+kongjianming+" 的Y坐标位置： "+y);
		 return y;
	 }
	 
	//获取Xpath控件的x坐标
		 int getXpathX(AndroidDriver driver,String Xpath) {
			 String kongjianming = Xpath.substring(Xpath.indexOf("=")+1, Xpath.indexOf("]"));
			 int x = driver.findElement(By.xpath(Xpath)).getLocation().x;
			 System.out.println("获取Xpath控件: "+kongjianming+" 的X坐标位置： "+x);
			 return x;
		 }
//================================================Driver信息================================================
	public AndroidDriver rundriver(String packageName, String ActivityName, String deviceName) throws MalformedURLException {
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				this.appInffo(packageName, ActivityName, deviceName));
		System.out.println("启动："+" 包名："+packageName+" 活动名："+ActivityName);
		return driver;
	}
	
	DesiredCapabilities appInffo(String packageName, String ActivityName, String deviceName) {
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
