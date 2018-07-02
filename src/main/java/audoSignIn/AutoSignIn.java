package audoSignIn;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * APPIUM手机自动化签到脚本 
 *
 */
public class AutoSignIn {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		SignEveryDayTryVersion();
	}

	static void SignEveryDayTryVersion() throws MalformedURLException, InterruptedException {
		Feizhu();
		Xianyu();
		Cainiao();
		Youdao();
		JingdongStock();
		taobao();
		Yunyinyue();
		zhifubao();
	}

	static void Youdao() throws InterruptedException, MalformedURLException {
		String packageName = "com.youdao.note";
		String ActivityName = ".activity2.MainActivity";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		s_jinru("有道云笔记");
		Thread.sleep(2000);
		s_deng(2);
		try {
			s_jinru("有道云笔记");
			stepX(driver, "//android.widget.TextView[@text='我的']");
			s_dianji("我的");
			Thread.sleep(2000);
			s_deng(2);
			stepX(driver, "//android.widget.TextView[@text='我的']");
			s_dianji("我的（再次）");

			int wozhidaoshu = 0;

			while (1 < 3) {
				Thread.sleep(2000);
				s_deng(2);
				stepX(driver, "//android.widget.TextView[@text='签到']");
				s_dianji("签到");
				Thread.sleep(3000);
				s_deng(3);
				int if_code_for_zhidao = exist(driver, "//android.widget.Button[@text='我知道了']");
				if (wozhidaoshu == 2) {
					break;
				}
				if (if_code_for_zhidao == 1) {
					wozhidaoshu++;
					driver.pressKeyCode(AndroidKeyCode.BACK);
					s_dianji("返回");
					continue;
				}

				if (if_code_for_zhidao == 0) {
					int if_for_mashang = exist(driver, "//android.widget.Button[@text='马上观看']");
					if (if_for_mashang == 0) {
						System.out.println("既没有我知道了也没有马上观看");
					}
					if (if_for_mashang == 1) {
						stepX(driver, "//android.widget.Button[@text='马上观看']");
						Thread.sleep(500);
						int overtimecode = 0;
						int times = 0;
						while (1 < 2) {
							times++;

							if (overtimecode > 49) {
								break;
							} else {
								overtimecode = overtimecode + 1;
							}
							String as1 = driver.getScreenshotAs(OutputType.BASE64);
							Thread.sleep(500);
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
						}
						driver.pressKeyCode(AndroidKeyCode.BACK);
						s_dianji("返回");
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		s_tuichu("有道云笔记");
		driver.quit();
		;
	}

	static void Feizhu() throws MalformedURLException, InterruptedException {

		String packageName = "com.taobao.trip";
		String ActivityName = "com.alipay.mobile.quinox.LauncherActivity";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		s_jinru("飞猪");
		s_deng(3);
		Thread.sleep(3000);

		try {
			untilX(driver, "//android.widget.TextView[@text='我的']");
			s_dianji("我的");
			s_deng(2);
			Thread.sleep(2000);
			stepX(driver, "//android.widget.TextView[@text='我的']");
			s_dianji("我的（再次）");
			s_deng(2);
			Thread.sleep(2000);

			stepX(driver, "//android.widget.ImageView[@index='3']");
			s_dianji("签到");
			s_deng(2);
			Thread.sleep(2000);

			stepX(driver, "//android.view.View[@content-desc='立即签到']");
			s_dianji("立即签到");

			s_deng(1);
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("飞猪出错" + e.toString());
		}
		s_tuichu("飞猪");
		driver.quit();
		;
	}

	static void Cainiao() throws MalformedURLException, InterruptedException {
		String packageName = "com.cainiao.wireless";
		String ActivityName = ".homepage.presentation.view.activity.HomepageActivity";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		s_jinru("菜鸟裹裹");
		try {
			Thread.sleep(8000);
			s_deng(8);
			touch(driver, 980, 1800);
			s_dianji("我");
			Thread.sleep(3000);
			s_deng(3);
			touch(driver, 540, 630);// [0,546][1080,777]
			Thread.sleep(3000);
			s_deng(3);
			touch(driver, 60, 150);
			Thread.sleep(2000);
			s_deng(2);

			System.out.print("开始");
			s_panduan("是否签到了");
			String emmmmm = null;
			try {
				@SuppressWarnings("unused")
				WebElement we = driver.findElement(By.xpath("//android.widget.TextView[@text='已签到']"));
			} catch (Exception e) {
				emmmmm = e.toString();
			}
			if (emmmmm != null) {
				System.out.println("页面内没有‘已签到’");
			}

			String guojiang = null;
			guojiang = driver.findElement(By.id("com.cainiao.wireless:id/txt_integral_count")).getText().toString();
			System.out.println("果酱数为" + guojiang + "。");
			// com.cainiao.wireless:id/txt_integral_count
			s_tuichu("裹裹");
		} catch (Exception e) {
			System.out.println("菜鸟出错" + e.toString());
		}
		s_tuichu("菜鸟");
		driver.quit();
		;

	}

	static void JingdongFinace() throws MalformedURLException, InterruptedException {
		String packageName = "com.jd.jrapp";
		String ActivityName = ".WelcomeActivity";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		s_jinru("京东金融");
		try {
			s_deng(10);
			Thread.sleep(10000);

			touch(driver, 900, 1800);
			s_dianji("我的");
			s_deng(2);
			Thread.sleep(2000);
			stepX(driver, "//android.widget.TextView[@text='签到']");
			s_dianji("签到");
			s_deng(5);
			Thread.sleep(5000);
			TouchAction action = new TouchAction(driver);
			action.tap(880, 468).perform();
			s_dianji("880,468");
			s_deng(1);
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("京东金融出错" + e.toString());
		}
		s_tuichu("京东金融");
		driver.quit();
		;
	}

	static void JingdongStock() throws MalformedURLException, InterruptedException {
		String packageName = "com.jd.stock";
		String ActivityName = "com.jdjr.stock.navigation.activity.LaunchActivity";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		s_jinru("京东股票");
		try {
			Thread.sleep(5000);
			try {
				Thread.sleep(2000);
				clickx(driver, "//android.widget.Button[@resource-id='com.jd.stock:id/negativeButton']");
			} catch (Exception e) {}
			stepX(driver, "//android.widget.TextView[@text='我的']");
			Thread.sleep(2000);
			try {
				stepX(driver, "//android.widget.TextView[@text='签到']");
			} catch (Exception e) {
				System.out.println("未找到签到");
			}
			Thread.sleep(3000);
			WebElement em = null;
			try {
				em = driver.findElement(By.xpath("//android.widget.TextView[@text='签到']"));
			} catch (Exception e) {
				System.out.println("未找到签到");
			}
			if (em != null) {
				em.click();
			} else {
				@SuppressWarnings("unused")
				WebElement em1 = null;
				try {
					em1 = driver.findElement(By.xpath("//android.widget.TextView[@text='已签到']"));
				} catch (Exception e) {
					System.out.println("已经签到");
				}
			}
		} catch (Exception e) {
			System.out.println("京东股票出错" + e.toString());
		}
		s_tuichu("京东股票");
		driver.quit();
		;
	}

	static void Yunyinyue() throws MalformedURLException, InterruptedException {
		String packageName = "com.netease.cloudmusic";
		String ActivityName = ".activity.LoadingActivity";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		s_jinru("云音乐");
		try {
			untilX(driver, "//android.widget.TextView[@text='私人FM']");
			s_dengdao("私人FM");
			stepX(driver, "//android.widget.ImageView[@content-desc='抽屉菜单']");
			s_dianji("抽屉菜单");
			s_deng(1);
			Thread.sleep(1000);
			stepX(driver, "//android.widget.TextView[@text='签到']");
			s_dianji("签到");
			s_deng(5);
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("云音乐故障" + e.toString());
		}
		s_tuichu("云音乐");
		driver.quit();
	}

	static void Iyingdi() throws MalformedURLException, InterruptedException {
		String packageName = "com.gonlan.iplaymtg";
		String ActivityName = ".common.StartActivity";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		s_jinru("旅法师应营地");
		s_deng(8);
		Thread.sleep(8000);
		try {

			stepX(driver, "//android.widget.TextView[@text='炉石传说']");
			s_dianji("炉石传说");
			s_deng(5);
			Thread.sleep(5000);
			s_dianji("第一篇文章");
			touch(driver, 500, 1200);// 点击第一篇文章
			s_deng(5);
			Thread.sleep(5000);
			s_dianji("第二篇文章");
			touch(driver, 700, 1850);// 点击评论
			s_deng(5);
			Thread.sleep(5000);
			untilX(driver, "//android.widget.TextView[@text='回复']");
			s_dengdao("回复");

			TouchAction action1 = new TouchAction(driver);
			System.out.println("进入点赞判断");
			int i = 0, e = 0, r = 0;
			while (r < 1) {
				@SuppressWarnings("rawtypes")
				List xpathList = driver.findElements(By.xpath("//android.widget.TextView[@text='回复']"));
				e = xpathList.size();
				System.out.println("本页有" + e + "个赞");

				if (e != 0) {
					int num = 0;
					while (num < e) {
						WebElement em = (WebElement) xpathList.get(num);
						num = num + 1;
						Thread.sleep(1000);
						int x = em.getLocation().x;
						int y = em.getLocation().y;
						action1.tap(x - 163, y + 15).perform();
						i = i + 1;
						System.out.println("点第" + i + "个");
					}
					Thread.sleep(1000);
					swipTo(driver, 10, 1700, 10, 200);
					Thread.sleep(2000);

				} else {
					Thread.sleep(1000);
					swipTo(driver, 10, 1700, 10, 500);
					Thread.sleep(2000);
				}
				if (i > 5) {
					r = 2;
				}
			}
			// =======================================================================

			stepX(driver, "//android.widget.ImageView[@content-desc='取消']");
			s_dianji("返回");
			Thread.sleep(500);
			stepX(driver, "//android.widget.ImageView[@content-desc='取消']");
			s_dianji("返回");

			Thread.sleep(3000);
			s_deng(3);
			touch(driver, 960, 1888);
			s_dianji("我的");
			stepX(driver, "//android.widget.TextView[@text='更多']");
			s_dianji("任务");
			stepX(driver, "//android.widget.TextView[@text='任务']");
			s_dianji("任务");
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("旅法师营地出错" + e.toString());
		}
		s_tuichu("旅法师营地");
		driver.quit();
		;

	}

	static void iqiyi() throws MalformedURLException, InterruptedException {
		String packageName = "com.qiyi.video";
		String ActivityName = ".WelcomeActivity";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));

		try {
			stepX(driver, "//android.widget.TextView[@text='我的']");
			s_dianji("我的");
			s_deng(1);
			Thread.sleep(1000);
			untilX(driver, "//android.widget.TextView[@text='泡泡圈']");
			s_dianji("签到界面");
			touch(driver, 800, 450);// [797,417][1014,470]
			s_deng(3);
			Thread.sleep(3000);
			s_dianji("签到");
			touch(driver, 900, 1465);// [833,1397][968,1532]
			s_deng(1);
			Thread.sleep(1000);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			s_dianji("返回");
			s_deng(2);
			Thread.sleep(2000);
			// swipTo(driver, 50, 1500, 50, 500);//[0,1472][1080,1587]滑动起始点
			driver.pressKeyCode(AndroidKeyCode.BACK);
			s_dianji("返回");
			stepX(driver, "//android.widget.TextView[@text='推荐']");
			s_dianji("推荐");
			s_dianji("首页电视剧");// [45,444][1035,939]
			touch(driver, 500, 700);
			s_deng(2);
			Thread.sleep(2000);
			stepX(driver, "//android.widget.TextView[@text='分享']");
			s_dianji("分享");
			s_deng(1);
			Thread.sleep(1000);
			stepX(driver, "//android.widget.TextView[@text='复制链接']");
			s_dianji("复制链接");
			s_deng(2);
			Thread.sleep(2000);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			s_dianji("返回");
			stepX(driver, "//android.widget.TextView[@text='我的']");
			s_dianji("我的");
			s_deng(1);
			Thread.sleep(1000);
			untilX(driver, "//android.widget.TextView[@text='泡泡圈']");
			touch(driver, 800, 450);// [797,417][1014,470]
			s_deng(1);
			Thread.sleep(1000);
			swipTo(driver, 50, 1500, 50, 100);
			System.out.println("滑动");
			stepX(driver, "//android.widget.TextView[@text='领取']");
			s_dianji("领取");
			s_deng(2);
			Thread.sleep(2000);
			stepX(driver, "//android.widget.TextView[@text='去访问']");
			s_dianji("去访问");
			s_deng(3);
			Thread.sleep(3000);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			s_dianji("返回");
			stepX(driver, "//android.widget.TextView[@text='领取']");
			s_dianji("领取");
			s_deng(2);
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("爱奇艺出错" + e.toString());
		}
		s_tuichu("爱奇艺");
		driver.quit();
		;
	}

	static void Xianyu() throws MalformedURLException, InterruptedException {
		String packageName = "com.taobao.idlefish";
		String ActivityName = "com.taobao.fleamarket.home.activity.MainActivity";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		s_jinru("咸鱼");

		try {
			Thread.sleep(5000);
			stepX(driver, "//android.widget.TextView[@text='我的']");
			s_dianji("我的");
			stepX(driver, "//android.widget.TextView[@text='我的鱼塘']");
			int picNum = 0; 
			for(picNum=0;picNum<3;picNum++) 
			{
				String firstString = "//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[";
				String secondString = "]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]";
				
				String finalString = firstString + (picNum+2) + secondString;
				s_panduan(finalString);
				stepX(driver, finalString);
				stepX(driver, "//android.widget.TextView[@text='签到']");
				Thread.sleep(2000);
				touch(driver, 74, 150);
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("咸鱼出错" + e.toString());
		}
		s_tuichu("咸鱼");
		driver.quit();
		;
	}

	@SuppressWarnings("rawtypes")
	static void taobao() throws MalformedURLException, InterruptedException {
		String packageName = "com.taobao.taobao";
		String ActivityName = "com.taobao.tao.welcome.Welcome";
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		s_jinru("淘宝");
		try {
			s_deng(5);
			Thread.sleep(5000);

			System.out.println("开始判断是否弹出淘宝界面");
			int i = 0;
			while (i < 2) {

				String em12 = "a";
				try {
					Thread.sleep(5000);
					driver.findElement(By.xpath("//android.widget.TextView[@text='扫一扫']"));
				} catch (Exception e) {
					System.out.println("未找到扫一扫，界面不在淘宝内");
					em12 = null;
				}
				if (em12 != null) {
					i = 2;
				} else {
					String em1 = null;
					try {
						Thread.sleep(2000);
						@SuppressWarnings("unused")
						WebElement emm1 = driver.findElement(By.xpath("//android.widget.TextView[@text='菜鸟裹裹']"));
						Thread.sleep(2000);
						@SuppressWarnings("unused")
						WebElement emm2 = driver.findElement(By.xpath("//android.widget.TextView[@text='网易云音乐']"));
					} catch (Exception e) {
						em1 = e.toString();
					}
					Thread.sleep(2000);
					s_deng(2);
					if (em1 == null) {
						stepX(driver, "//android.widget.TextView[@text='手机淘宝']");
						Thread.sleep(3000);
						s_deng(3);
					}
				}
			}

			Thread.sleep(2000);
			s_deng(2);
			touch(driver, 1000, 1900);
			s_dianji("我的");
			Thread.sleep(2000);
			s_deng(2);
			swipTo(driver, 50, 1108, 50, 280);
			stepX(driver, "//android.widget.TextView[@text='查看全部工具']");
			s_dianji("查看全部工具");
			stepX(driver, "//android.widget.TextView[@text='每日打卡']");
			s_dianji("每日打卡");
			s_deng(2);
			Thread.sleep(2000);
			// stepX(driver,"//android.widget.Image[@content-desc='TB1Af6acwoQMeJjy0FnXXb8gFXa-132-132.png_110x10000.jpg_']");s_dianji("返回");
			driver.pressKeyCode(AndroidKeyCode.BACK);
			s_dianji("返回");
			s_deng(2);
			Thread.sleep(2000);
			TouchAction action1 = new TouchAction(driver);
			action1.longPress(100, 1730).moveTo(100, 100).release().perform();
			System.out.println("滑动");
			s_deng(1);
			Thread.sleep(1000);
			stepX(driver, "//android.widget.TextView[@text='领金币']");
			s_dianji("领金币");
			s_deng(3);
			Thread.sleep(3000);
			touch(driver, 500, 400);
			s_dianji("金币箱");// [402,230][690,518]
			s_deng(1);
			Thread.sleep(1000);

			try {
				stepX(driver, "//android.view.View[@content-desc='今日任务']");
				s_dianji("今日任务");
				Thread.sleep(1000);
				clickx(driver, "//android.view.View[@content-desc='浏览活动送金币']");
				s_dianji("浏览+金币");
				Thread.sleep(1000);
				driver.pressKeyCode(AndroidKeyCode.BACK);
				s_dianji("返回");
				Thread.sleep(2000);

			} catch (Exception e) {
				System.out.print("未找到浏览活动送金币");
			}

			try {
				driver.findElement(By.xpath("//android.view.View[@content-desc='签到领金币']")).click();
				Thread.sleep(3000);
				stepX(driver, "//android.view.View[@content-desc='每日签到']");
				Thread.sleep(5000);
				stepX(driver, "//android.widget.ImageButton[@content-desc='转到上一层级']");
				Thread.sleep(2000);

			} catch (Exception e) {

			}

			Thread.sleep(2000);
			s_deng(2);
			int bx = driver.findElement(By.xpath("//android.view.View[@content-desc='币有好店']")).getLocation().x;
			int by = driver.findElement(By.xpath("//android.view.View[@content-desc='币有好店']")).getLocation().y;
			swipTo(driver, bx, by, 220, 220);

			System.out.println("移动币有好店到 最上面");
			Thread.sleep(2000);
			
			String stringFirst = "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.FrameLayout[";
			String stringSecond = "]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]";
			int inNum = 0;
			int controlNum = 0;
			while (1 < 2) {

				try {
					driver.findElement(ByXPath.xpath(stringFirst + "4" + stringSecond));
					controlNum = 3;
				} catch (Exception e) {
					try {
						driver.findElement(ByXPath.xpath(stringFirst + "3" + stringSecond));
						controlNum = 2;
					} catch (Exception e1) {
						try {
							driver.findElement(ByXPath.xpath(stringFirst + "2" + stringSecond));
							controlNum = 1;
						} catch (Exception e11) {
							controlNum = 0;
						}
					}
				}
				for (inNum = 0; inNum < controlNum; inNum++) {
					String finalStrings = stringFirst + (inNum + 2) + stringSecond;
					stepX(driver, finalStrings);
					Thread.sleep(2000);
					untilX(driver, "//android.view.View[@content-desc='店铺热卖']");
					Thread.sleep(2000);
					driver.pressKeyCode(AndroidKeyCode.BACK);
					Thread.sleep(2000);
				}
				WebElement StoreLogo;
				int yLocation;
				if (controlNum == 3) {
					StoreLogo = driver.findElement(By.xpath(stringFirst + "4" + stringSecond));
					yLocation = StoreLogo.getLocation().y + 58;
					swipTo(driver, 20, yLocation, 20, 20);
				} else if (controlNum == 2) {
					StoreLogo = driver.findElement(By.xpath(stringFirst + "3" + stringSecond));
					yLocation = StoreLogo.getLocation().y + 58;
					swipTo(driver, 20, yLocation, 20, 20);
				} else if (controlNum == 1) {
					StoreLogo = driver.findElement(By.xpath(stringFirst + "2" + stringSecond));
					yLocation = StoreLogo.getLocation().y + 58;
					swipTo(driver, 20, yLocation, 20, 20);
				} else if (controlNum == 0) {
				}
				try {
					driver.findElement(By.xpath(stringFirst + "2" + stringSecond));
				}catch (Exception e1111) {
					break;
				}
			}	
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("淘宝报错" + e.toString());
		}
		s_tuichu("淘宝");
		driver.quit();
	}


	static void chiji() throws MalformedURLException, InterruptedException {
		String packageName = "com.tencent.wegame.mangod";
		String ActivityName = "com.tencent.gamehelper.ui.main.WelcomeActivity";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		Thread.sleep(2000);
		try {
			stepX(driver, "//android.widget.TextView[@text='公告']");
			Thread.sleep(500);
			stepX(driver, "//android.widget.TextView[@text='签到领鸡腿，商城兑福利']");
			Thread.sleep(3000);
			touch(driver, 512, 700);// [48,558][1032,996]
			Thread.sleep(3000);
			touch(driver, 530, 856);
			Thread.sleep(500);
			Thread.sleep(2000);
			s_tuichu("吃鸡");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		driver.quit();
	}

	static void zhifubao() throws MalformedURLException, InterruptedException {
		String packageName = "com.eg.android.AlipayGphone";
		String ActivityName = ".AlipayLogin";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		try {
			Thread.sleep(2000);
			stepX(driver, "//android.widget.TextView[@text='运动']");
			Thread.sleep(8000);
			System.out.println("立即捐布");
			touch(driver, 555, 1332);
			System.out.println("确定");
			Thread.sleep(8000);
			touch(driver, 751, 1546);
			Thread.sleep(3000);
			touch(driver, 33, 175);// [0,66][132,210]
			Thread.sleep(1000);
			touch(driver, 33, 175);// [0,66][132,210]
			stepX(driver, "//android.widget.TextView[@text='大学生活']");
			Thread.sleep(10000);
			untilX(driver, "//android.widget.TextView[@text='湘潭大学']");
			Thread.sleep(5000);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(3000);
			stepX(driver, "//android.widget.TextView[@text='大学生活']");
			Thread.sleep(10000);
			untilX(driver, "//android.widget.TextView[@text='湘潭大学']");
			Thread.sleep(2000);
			touch(driver, 930, 1860);
			Thread.sleep(5000);
			touch(driver, 270, 940);
			Thread.sleep(8000);
			touch(driver, 880, 355);
			Thread.sleep(2000);
			while(1<2) 
			{	
				Thread.sleep(200);
				try {
					Thread.sleep(1500);
					WebElement fanhui = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.alipay.mobile.nebula:id/h5_tv_nav_back']"));
					fanhui.click();
				}catch (Exception e) {
					break;
				}
			}
			
			stepX(driver, "//android.widget.TextView[@resource-id='com.alipay.android.phone.wealth.home:id/tab_description']");//我的
			untilX(driver, "//android.widget.TextView[@resource-id='com.alipay.mobile.nebula:id/h5_tv_title']");
			WebElement locatedele = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.alipay.mobile.nebula:id/h5_tv_title']"));
			int locX = locatedele.getLocation().x+10;
			int locY = locatedele.getLocation().y+415;
			touch(driver, locX, locY);
			untilX(driver, "//android.view.View[@content-desc='规则说明']");
			touch(driver, 530, 555);
			try {
				Thread.sleep(1500);
				driver.findElement(By.xpath("//android.view.View[@content-desc='已签到']"));
			}catch (Exception e) {
				System.out.println("签到界面出问题");
			}
		} catch (Exception e) {
			System.out.println("支付宝出错");
		}

		Thread.sleep(2000);
		driver.quit();
	}

	static String ifExist(@SuppressWarnings("rawtypes") AndroidDriver driver, String Xpath) {
		String eme = null;
		try {
			@SuppressWarnings("unused")
			WebElement ele = driver.findElement(By.xpath(Xpath));

		} catch (Exception e) {
			eme = e.toString();
		}
		return eme;

	}

	static void touch(@SuppressWarnings("rawtypes") AndroidDriver driver, int x, int y) {
		int b1 =driver.manage().window().getSize().width;
		int b2 =driver.manage().window().getSize().height;
		
		int xfinal = (int)(x*b1/1080);
		int yfinal = (int)(y*b1/1080);
		
		TouchAction action = new TouchAction(driver);
		action.tap(xfinal, yfinal).perform();
	}

	static void untilX(@SuppressWarnings("rawtypes") AndroidDriver driver, String Xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(Xpath)));
	}

	static void clickx(@SuppressWarnings("rawtypes") AndroidDriver driver, String Xpath) {
		driver.findElement(By.xpath(Xpath)).click();
	}

	static void stepX(@SuppressWarnings("rawtypes") AndroidDriver driver, String Xpath) {
		untilX(driver, Xpath);
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

	// =========================appinfo=============================
	static DesiredCapabilities appInffo(String packageName, String ActivityName) {
		DesiredCapabilities capa = new DesiredCapabilities();
		capa.setCapability("deviceName", "741AECR82S8DF");// 741AECR82S8DF
		capa.setCapability("automationName", "Appium");
		capa.setCapability("platformNme", "Android");
		capa.setCapability("platformVersion", "6.0.1");
		capa.setCapability("appPackage", packageName);
		capa.setCapability("appActivity", ActivityName);
		capa.setCapability("noReset", true);
		return capa;
	}

	// ==============================文字输出========================
	private static void s_dianji(String a) // 点击
	{
		System.out.println("点击" + a + "。");
	}

	private static void s_jinru(String a) {
		System.out.println("进入" + a + "。");
	}

	private static void s_dengdao(String a) {
		System.out.println("等到" + a + "出现。");
	}

	private static void s_tuichu(String a) {
		System.out.println("退出" + a + "。");
		System.out.println("=============================================================");
	}

	private static void s_deng(float a) {
		System.out.println("等" + a + "秒。");
	}

	private static void s_panduan(String a) {
		System.out.println("正在判断" + a + "。");
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

	public static int exist(@SuppressWarnings("rawtypes") AndroidDriver driver, String Xpath) { // 存在为1不存爱为0
		int fund_icon = -1;
		try {
			driver.findElement(By.xpath(Xpath));
			fund_icon = 1;
		} catch (Exception e) {
			fund_icon = 0;
		}
		return fund_icon;
	}

}
