package rewriteAudoSignIn;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AppiumPractice.AppAutoSignIn.FalseInterface;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * @author Aliun.King 继承于方法库，实现真正脚本运作0
 */

/*
 * 模板
 * void quanJia(String packageName, String ActivityName, String deviceName)
 * throws MalformedURLException {
 * AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
 */
@SuppressWarnings("rawtypes")
public class extendAutoSignDo extends autoSignDo  {

	void feiZhu(String packageName, String ActivityName, String deviceName)
			throws MalformedURLException, InterruptedException, FileNotFoundException {
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
							mistakeShotScreen(driver, e2);
							break;
						}
					}
				}
			}
			deng(4);
			stepXTimeOut(driver, "//android.view.View[@content-desc='去点赞']", 3);
			deng(3);
			int y = getXpathY(driver, "//android.view.View[@content-desc='旅行笔记']");
			touch(driver,1004,y);
		} catch (Exception e) {
			mistakeShotScreen(driver, e);
		}
		tuichu(driver, "飞猪旅行");
	}

	void xianYu(String packageName, String ActivityName, String deviceName) 
			throws MalformedURLException, FileNotFoundException {
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
				stepXTimeOut(driver, finalString, 3);
				stepXTimeOut(driver, "//android.widget.TextView[@text='签到']", 3);
				deng(2);
				back(driver);
			}
			deng(2);
			back(driver);
			deng(2);
			fromXpathMoveY(driver, "//android.widget.TextView[@text='我的鱼塘']", 500, 200);
			deng(2);
			stepXTimeOut(driver, "//android.widget.TextView[@text='我的闲鱼币']", 3);
			deng(8);
			stepXTimeOut(driver, "//android.view.View[@content-desc='马上签到']", 5);
			deng(5);

		} catch (Exception e) {
			mistakeShotScreen(driver, e);
			
		}
		tuichu(driver, "闲鱼");
	}

	void caiNiao(String packageName, String ActivityName, String deviceName) 
			throws MalformedURLException, FileNotFoundException {
		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		try {
			deng(6);
			try {
				untilTimeOut(driver, "com.cainiao.wireless:id/appver_update_cancel", 3);
				stepXTimeOut(driver, "com.cainiao.wireless:id/appver_update_cancel", 3);
			} catch (Exception e) {
				System.out.println("点击取消");
			}
			deng(3);
			deng(3);
			stepXTimeOut(driver, "//android.widget.TextView[@text='我']",3);
			deng(1);
			stepXTimeOut(driver, "//android.widget.TextView[@text='我']",3);
			stepXTimeOut(driver, "//android.widget.TextView[@resource-id='com.cainiao.wireless:id/integal_textview']",5);
			deng(2);
			back(driver);
			deng(2);
		}catch (Exception e) {
			mistakeShotScreen(driver, e);
		}
		tuichu(driver, "菜鸟裹裹");
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
			int mistakeCoin = 0;
			while (1 < 2) {

				mistakeCoin++;
				try {
					stepXTimeOut(driver, "//android.widget.TextView[@text='观看短视频，领取随机奖励']", 5);
				} catch (Exception e) {
					if (mistakeCoin <= 3) {
						continue;
					} else {
						mistakeShotScreen(driver, e);
						break;
					}

				}
				deng(10);
				staticPicMonitor(driver, 3);
				back(driver);
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
						mistakeShotScreen(driver, e);
						break;
					}
				}
			}
		} catch (Exception e) {
			mistakeShotScreen(driver, e);
		}
		tuichu(driver, "有道");
	}

	void jingDongStock(String packageName, String ActivityName, String deviceName) 
			throws MalformedURLException, FileNotFoundException {
		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		try {
			deng(5);
			try {
				deng(2);
				stepXTimeOut(driver, "//android.widget.Button[@resource-id='com.jd.stock:id/negativeButton']",3);
			} catch (Exception e) {
			}
			stepXTimeOut(driver, "//android.widget.TextView[@text='我的']",3);
			deng(2);
			try {
				stepXTimeOut(driver ,"//android.widget.TextView[@text='签到']",3);
			} catch (Exception e) {
				System.out.println("未找到签到");
			}
			deng(3);
			
		}catch (Exception e) {
			mistakeShotScreen(driver, e);
		}
		tuichu(driver, "京东股票");
	}

	void yiTao(String packageName, String ActivityName, String deviceName) 
			throws MalformedURLException, FileNotFoundException, InterruptedException {
		AndroidDriver driver1 = this.rundriver(packageName, ActivityName, deviceName);
		deng(10);
		tuichu(driver1,"预启动一淘");
		deng(3);
		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		try {
			int outwhilecode = 0;
			try {
				while (1 < 2) {
					if (outwhilecode >= 2) {
						break;
					}
					deng(1);
					try {
						stepXTimeOut(driver, "//android.widget.TextView[@text='更新提示']", 3);
						stepXTimeOut(driver, "//android.widget.Button[@text='取消']", 2);
					} catch (Exception e) {
						outwhilecode++;
					}
					System.out.println("检查是否需要更新" + outwhilecode);
				}

			} catch (Exception e) {
			}
		
				stepXTimeOut(driver, "//android.widget.TextView[@text='签到送豪礼']", 10);
				deng(5);
				try {
					stepXTimeOut(driver, "//android.view.View[@content-desc='点我签到领钱']", 5);
				} catch (Exception e) {
					back(driver);
					deng(2);
					stepXTimeOut(driver, "//android.widget.TextView[@text='签到送豪礼']", 5);
					stepXTimeOut(driver, "//android.view.View[@content-desc='点我签到领钱']", 5);
				}
				deng(2);
				try {
					untilTimeOut(driver, "//android.view.View[@content-desc='提醒规则']", 3);
					deng(2);
				} catch (Exception e) {
					deng(2);
					mistakeShotScreen(driver, e);
				}
		}catch (Exception e) {
			mistakeShotScreen(driver, e);
		}
		tuichu(driver, "一淘");
	}

	void yunYinYue(String packageName, String ActivityName, String deviceName) 
			throws MalformedURLException, FileNotFoundException {
		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		try {
			deng(7);
			try {
				untilTimeOut(driver, "//android.widget.TextView[@text='重新购买']", 8);
				back(driver);
			} catch (Exception e) {
			}
			untilTimeOut(driver, "//android.widget.TextView[@text='私人FM']",5);
			stepXTimeOut(driver, "//android.widget.ImageView[@content-desc='抽屉菜单']",3);
			deng(3);
			stepXTimeOut(driver, "//android.widget.TextView[@text='签到']",3);
			deng(5);
		}catch (Exception e) {
			mistakeShotScreen(driver, e);
		}
		tuichu(driver, "网易云音乐");
	}

	void KFC(String packageName, String ActivityName, String deviceName) 
			throws MalformedURLException, FileNotFoundException, InterruptedException {
		AndroidDriver driver1 = this.rundriver(packageName, ActivityName, deviceName);
		deng(8);
		tuichu(driver1,"预进入KFC");
		deng(3);
		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		try {
				deng(2);
				untilTimeOut(driver, "//android.widget.TextView[@text='我的余额']", 10);
				deng(2);
				touchmiddle(driver, "[918,204][1050,279]");
				deng(2);
				stepXTimeOut(driver, "//android.widget.TextView[@text='签到']", 5);
				deng(1);
				touchmiddle(driver, "[444,99][636,164]");
				//加入遍历点击券
				while(1<2) {
					try {
						deng(2);
						int y = getXpathY(driver,"//android.widget.TextView[@text='立即领取']");
						swipTo(driver,300,y,300,200);
						deng(2);
						stepXTimeOut(driver, "//android.widget.TextView[@text='立即领取']", 3);
						deng(3);
					}catch (Exception e) {
						System.out.println("界面无领取");
						break;
					}
				}
				deng(2);
				
		}catch (Exception e) {
			mistakeShotScreen(driver, e);
		}
		tuichu(driver, "肯德基");
	}

	void quanJia(String packageName, String ActivityName, String deviceName) 
			throws MalformedURLException, FileNotFoundException {
		AndroidDriver driver = this.rundriver(packageName, ActivityName, deviceName);
		try {
			deng(10);
			try {
				deng(5);
				stepXTimeOut(driver, "//android.widget.RadioButton[@text='我的']", 3);
			} catch (Exception e) {
				int whileout = 0;
				while (1 < 2) {
					if (whileout > 2) {
						break;
					}
					try {
						untilTimeOut(driver, "//android.widget.TextView[@text='温馨提示']", 3);
						driver.pressKeyCode(AndroidKeyCode.BACK);
					} catch (Exception e1) {
						whileout++;
					}
				}
				int outif = 1;
				while (1 < 2) {
					outif++;
					if (outif >= 5) {
						break;
					}
					deng(2);
					try {
						untilTimeOut(driver, "//android.widget.TextView[@text='确定要退出软件吗？']", 5);
						stepXTimeOut(driver, "//android.widget.TextView[@text='取消']", 2);
					} catch (Exception ee) {
					}
				}
				stepXTimeOut(driver, "//android.widget.RadioButton[@text='我的']", 5);
			}
			deng(2);
			stepXTimeOut(driver, "//android.widget.TextView[@text='签到']", 5);
			deng(2);
			// stepXTimeOut(driver,
			// "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.ImageView[1]",
			// 5);
			// deng(2);
			stepXTimeOut(driver, "//android.widget.TextView[@text='每天签到赚积分']", 5);
		}catch (Exception e) {
			mistakeShotScreen(driver, e);
		}
		tuichu(driver, "享集联盟");
	}

}

