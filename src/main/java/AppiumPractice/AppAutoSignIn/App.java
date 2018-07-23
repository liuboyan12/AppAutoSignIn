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
//			int inScreenIcon = 0;
//			while (1 < 2) {
//				try {
//					driver.findElement(By.xpath(
//							"//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[3]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[5]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"));
//					inScreenIcon = 1;
//				} catch (Exception e) {
//					try {
//						driver.findElement(By.xpath("//android.widget.TextView[@text='天猫国际']"));
//						inScreenIcon = 1;
//					} catch (Exception e1) {
//						try {
//							driver.findElement(By.xpath("//android.widget.TextView[@text='分类']"));
//							inScreenIcon = 1;
//						} catch (Exception e2) {
//							try {
//								driver.findElement(By.xpath("//android.widget.TextView[@text='充值中心']"));
//								inScreenIcon = 1;
//							} catch (Exception e3) {
//								System.out.println("未判断到在淘宝界面内");
//							}
//						}
//					}
//				}
//				if (inScreenIcon == 1) {
//					break;
//				} else {
//					stepX(driver, "//android.widget.TextView[@text='手机淘宝']");
//				}
//			}
//			Thread.sleep(2000);
//			touch(driver, 950, 1800);
//			swipTo(driver, 50, 1108, 50, 280);
//			stepX(driver, "//android.widget.TextView[@text='查看全部工具']");
//			TouchAction action1 = new TouchAction(driver);
//			action1.longPress(100, 1730).moveTo(100, 100).release().perform();
//			System.out.println("滑动");
//			Thread.sleep(1000);
//			stepX(driver, "//android.widget.TextView[@text='领金币']");
////			transfer.falseInterface(driver, "");
//			stepXTimeOut(driver, "//android.view.View[@content-desc='今日任务']", 10);
//			Thread.sleep(5000);
//			WebElement dianele = null;
//			try {
//				dianele = driver.findElement(By.xpath("//android.view.View[@content-desc='好店签到']"));
//			} catch (Exception e1) {
//				dianele = driver.findElement(By.xpath("//android.view.View[@content-desc='币有好店']"));
//			}
//			int bx = dianele.getLocation().x;
//			int by = dianele.getLocation().y;
//			swipTo(driver, bx, by, 220, 220);
//			System.out.println("移动好店到 最上面");
//			Thread.sleep(2000);
//			transfer.falseInterface(driver, "");
//			while (1 < 2) {
//				try {
//					Thread.sleep(1000);
//					untilTimeOut(driver, "//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]", 10);
//					WebElement sign5 = driver.findElement(By.xpath(
//							"//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]"));
//					stepX(driver, "//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]");
//					Thread.sleep(2000);
//					try {
//						untilTimeOut(driver, "//android.view.View[@content-desc='店铺热卖']", 15);
//					}catch (Exception e) {
//						System.out.println("店铺热卖没有找到");
//					}
//					
//					driver.pressKeyCode(AndroidKeyCode.BACK);
//					Thread.sleep(2000);
//					int x1 = sign5.getLocation().x;
//					int y1 = sign5.getLocation().y;
//					swipTo(driver, x1, y1, x1, 75);
//				} catch (Exception e) {
//					try {
//						untilTimeOut(driver, "//android.view.View[@content-desc='猜你喜欢']", 5);
//						driver.quit();
//					} catch (Exception e1) {
//						FalseInterface falesdriver1 = new FalseInterface();
//						falesdriver1.falseInterface(driver, e1.toString());
//						driver.quit();
//						System.out.println("淘宝界面出错，请查看");
//					}}}
//			
			stepX(driver,
					"//android.widget.TextView[@resource-id='com.alipay.android.phone.wealth.home:id/tab_description']");// 我的
			stepX(driver, "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.TabHost[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]");
			try {
				stepXTimeOut(driver, "//android.view.View[@content-desc='领积分']", 10);
				
			}catch (Exception e) {
				try {
					stepXTimeOut(driver, "//android.view.View[@content-desc='赚积分']", 10);
				}catch (Exception e1) {
					System.out.println("未找到领取积分界面");
				}
			}
			untilX(driver, "//android.view.View[@content-desc='规则说明']");
			touch(driver, 530, 555);
			try {
				Thread.sleep(1500);
				driver.findElement(By.xpath("//android.view.View[@content-desc='已签到']"));
			} catch (Exception e) {
				System.out.println("签到界面出问题");
			}

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
}