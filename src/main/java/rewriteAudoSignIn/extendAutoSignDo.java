package rewriteAudoSignIn;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AppiumPractice.AppAutoSignIn.FalseInterface;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * @author Aliun.King 继承于方法库，实现真正脚本运作0
 */
@SuppressWarnings("rawtypes")
public class extendAutoSignDo extends autoSignDo {

	void feiZhu(String packageName, String ActivityName, String deviceName)
			throws MalformedURLException, InterruptedException {
		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		
		deng(5);
		try {
			stepXTimeOut(driver, "//android.widget.TextView[@text='我的']", 5);
			deng(2);
			stepXTimeOut(driver, "//android.widget.TextView[@text='我的']", 3);
			deng(5);
			touchmiddle(driver, "[722,210][1080,411]");
			deng(8);
			// stepXTimeOut(driver, "//android.view.View[@content-desc='立即签到']", 3);
			stepXTimeOut(driver, "//android.view.View[@content-desc='签到领里程']", 3);
			stepXTimeOut(driver,
					"//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[4]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.view.View[1]",
					5);
			deng(5);
			while (1 < 2) {
				try {
					stepXTimeOut(driver, "//android.view.View[@content-desc='升级成为F2']", 3);
					break;
				} catch (Exception e) {
					try {
						stepXTimeOut(driver, "//android.view.View[@content-desc='升级成为F3']", 3);
						break;
					} catch (Exception e1) {
						try {
							stepXTimeOut(driver, "//android.view.View[@content-desc='升级成为F4']", 3);
							break;
						} catch (Exception e2) {
							String error = e2.toString();
							
							falesdriver.falseInterface(driver, error);
							break;
						}
					}
				}
			}
			deng(4);
			stepXTimeOut(driver, "//android.view.View[@content-desc='去点赞']", 3);
			deng(3);
			
			
			// try {
			//
			// int whileout = 0;
			// while(1<2) {
			// whileout++;
			// try {
			// deng(2);
			// untilTimeOut(driver, "//android.view.View[@content-desc='旅行笔记']", 3);
			// WebElement webelement =
			// driver.findElement(By.xpath("//android.view.View[@content-desc='旅行笔记']"));
			// int x = webelement.getLocation().x;
			// int y = webelement.getLocation().y;
			// Thread.sleep(500);
			// touch(driver, x+860, y);
			// deng(2);
			// break;
			// }catch (Exception e) {
			// swipTo(driver, 500, 1000, 500, 20);
			// }
			// if(whileout>3) {
			// 
			// falesdriver.falseInterface(driver,
			// "//android.view.View[@content-desc='旅行笔记']-部分出错");
			// break;
			// }
			// }
			// back(driver);
			// s_deng(1);
			// Thread.sleep(1000);
		} catch (Exception e) {
		}
		tuichu(driver,"飞猪旅行");
	}

	void xianYu(String packageName, String ActivityName, String deviceName) throws MalformedURLException {
		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		
		try {
			deng(5);
			int outwhile = 0;
			while (1 < 2) {
				if (outwhile > 2) {
					break;
				}
				outwhile++;
				try {
					deng(2);
					stepXTimeOut(driver, "//android.widget.TextView[@text='我的']", 5);
					break;
				} catch (Exception e) {
					try {
						deng(2);
						untilTimeOut(driver, "//android.widget.TextView[@text='发布闲置']", 5);
						back(driver);
					} catch (Exception e1) {
						deng(2);
					}
				}
			}
			
			deng(2);
			stepXTimeOut(driver, "//android.widget.TextView[@text='我的鱼塘']", 5);
			deng(2);
			int picNum = 0;
			for (picNum = 0; picNum < 3; picNum++) {
				String firstString = "//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[";
				String secondString = "]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]";

				String finalString = firstString + (picNum + 2) + secondString;
				stepXTimeOut(driver, finalString,3);
				stepXTimeOut(driver, "//android.widget.TextView[@text='签到']",3);
				deng(2);
				back(driver);
			}
			deng(2);
			back(driver);
			deng(2);
			fromXpathMoveY(driver, "//android.widget.TextView[@text='我的鱼塘']",500, 200);
			deng(2);
			stepXTimeOut(driver, "//android.widget.TextView[@text='我的闲鱼币']", 3);
			deng(8);
			stepXTimeOut(driver, "//android.view.View[@content-desc='马上签到']", 5);
			deng(5);
			
		}catch (Exception e) {
		}


//	
//			
//		} catch (Exception e) {
//			System.out.println("咸鱼出错" + e.toString());
//			String error = e.toString();
//			
//			try {
//				falesdriver.falseInterface(driver, error);
//			} catch (FileNotFoundException e1) {
//				e1.printStackTrace();
//			}
//		}
//		s_tuichu("咸鱼");
//		tuichu(driver,"");
//		;
	
		tuichu(driver,"闲鱼");
	}

	void caiNiao(String packageName, String ActivityName, String deviceName) throws MalformedURLException {
		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		
		tuichu(driver,"菜鸟裹裹");
	}

	void youDao(String packageName, String ActivityName, String deviceName)
			throws MalformedURLException, InterruptedException, FileNotFoundException {

		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		
		deng(2);
		try {
			stepXTimeOut(driver, "//android.widget.TextView[@text='我的']", 5);
			deng(2);
			stepXTimeOut(driver, "//android.widget.TextView[@text='我的']", 5);
			deng(2);
			stepXTimeOut(driver, "//android.widget.TextView[@text='我的']", 5);
			deng(2);
			stepXTimeOut(driver, "//android.widget.TextView[@text='签到']", 3);
			deng(3);
			back(driver);
			deng(3);
			int outwhile = 0;
			while (1 < 2) {
				stepXTimeOut(driver, "//android.widget.TextView[@text='观看短视频，领取随机奖励']", 3);
				deng(10);
				staticPicMonitor(driver, 3);
				deng(2);
				untilTimeOut(driver, "//android.widget.TextView[@text='选择一个奖励礼包']", 5);
				stepXTimeOut(driver, "//android.widget.ImageView[@index='0']", 3);
				deng(2);
				back(driver);
				deng(2);
				try {
					untilTimeOut(driver, "//android.widget.TextView[@text='已领']", 3);
					break;
				} catch (Exception e) {
					if (outwhile > 4) {
						System.out.println("有道界面報錯" + e.toString());
						String error = e.toString();
						falesdriver.falseInterface(driver, error);
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("有道出错" + e.toString());
			String error = e.toString();
			falesdriver.falseInterface(driver, error);
		}
		tuichu(driver,"有道");
	}

	void jingDongStock(String packageName, String ActivityName, String deviceName) throws MalformedURLException {
		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		
		
		tuichu(driver,"京东股票");
	}

	void yiTao(String packageName, String ActivityName, String deviceName) throws MalformedURLException {
		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		
		
		tuichu(driver,"一淘");
	}

	void yunYinYue(String packageName, String ActivityName, String deviceName) throws MalformedURLException {
		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		
		
		tuichu(driver,"网易云音乐");
	}

	void KFC(String packageName, String ActivityName, String deviceName) throws MalformedURLException {
		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		
		
		tuichu(driver,"肯德基");
	}

	void quanJia(String packageName, String ActivityName, String deviceName) throws MalformedURLException {
		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		
		
		tuichu(driver,"享集联盟");
	}

}



//void quanJia(String packageName, String ActivityName, String deviceName) throws MalformedURLException {
//	AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
//	
//}