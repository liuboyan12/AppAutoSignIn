package audoSignIn;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import AppiumPractice.AppAutoSignIn.FalseInterface;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class scriptCollection {
	
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
						@SuppressWarnings("unused")
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

	static void Feizhu() throws MalformedURLException, InterruptedException, FileNotFoundException {

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
			Thread.sleep(5000);
			touchmiddle(driver, "[722,210][1080,411]");// 签到备选点击框[722,210][1080,411]
			s_dianji("签到");
			s_deng(2);
			Thread.sleep(8000);

			// stepX(driver, "//android.view.View[@content-desc='立即签到']");
//			stepX(driver, "//android.view.View[@content-desc='签到领里程']");
			stepXTimeOut(driver, "//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[4]/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.view.View[1]", 5);
			s_dianji("立即签到");
			Thread.sleep(5000);
			while(1<2) {
				try {
					stepXTimeOut(driver, "//android.view.View[@content-desc='升级成为F2']", 3);
					break;
				}catch (Exception e) {
					try {
						stepXTimeOut(driver, "//android.view.View[@content-desc='升级成为F3']", 3);
						break;
					}catch (Exception e1) {
						try {
							stepXTimeOut(driver, "//android.view.View[@content-desc='升级成为F4']", 3);
							break;
						}catch (Exception e2) {
							String error = e2.toString();
							FalseInterface falesdriver = new FalseInterface();
							falesdriver.falseInterface(driver, error);
						}
					}
				}
				break;
			}
			Thread.sleep(5000);
			stepXTimeOut(driver, "//android.view.View[@content-desc='去点赞']", 3);
			Thread.sleep(3000);
			int whileout = 0;
			while(1<2) {
				whileout++;
				try {
					Thread.sleep(2000);
					untilTimeOut(driver, "//android.view.View[@content-desc='旅行笔记']", 3);
					WebElement webelement = driver.findElement(By.xpath("//android.view.View[@content-desc='旅行笔记']"));
					int x = webelement.getLocation().x;
					int y = webelement.getLocation().y;
					Thread.sleep(500);
					touch(driver, x+828, y);
					Thread.sleep(2000);
					break;
				}catch (Exception e) {
					swipTo(driver, 500, 1000, 500, 20);
				}
				if(whileout>3) {
					FalseInterface falesdriver = new FalseInterface();
					falesdriver.falseInterface(driver, "//android.view.View[@content-desc='旅行笔记']-部分出错");
						break;
					}
			}
			driver.pressKeyCode(AndroidKeyCode.BACK);
			s_deng(1);
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("飞猪出错" + e.toString());
			String error = e.toString();
			FalseInterface falesdriver = new FalseInterface();
			falesdriver.falseInterface(driver, error);
		}
		s_tuichu("飞猪");
		driver.quit();
		;
	}

	static void Cainiao() throws MalformedURLException, InterruptedException, FileNotFoundException {
		String packageName = "com.cainiao.wireless";
		String ActivityName = ".homepage.presentation.view.activity.NewHomepageActivity";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		s_jinru("菜鸟裹裹");
		try {
			Thread.sleep(6000);
			try {
				driver.findElement(By.linkText("跳过")).click();
			} catch (Exception e) {
				System.out.println("沒有跳过");
			}
			try {
				untilTimeOut(driver, "com.cainiao.wireless:id/appver_update_cancel", 3);
				stepX(driver, "com.cainiao.wireless:id/appver_update_cancel");
			} catch (Exception e) {
				System.out.println("点击取消");
			}
			Thread.sleep(3000);
			stepX(driver, "//android.widget.TextView[@text='我']");
			Thread.sleep(500);
			stepX(driver, "//android.widget.TextView[@text='我']");
			stepXTimeOut(driver, "//android.widget.TextView[@resource-id='com.cainiao.wireless:id/integal_textview']",
					5);
			Thread.sleep(2000);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(2000);
			try {
				untilTimeOut(driver,
						"//android.widget.TextView[@resource-id='com.cainiao.wireless:id/txt_integral_count']", 5);
				String guojiang = driver
						.findElement(By.xpath(
								"//android.widget.TextView[@resource-id='com.cainiao.wireless:id/txt_integral_count']"))
						.getText().toString();

				System.out.println("果酱数为" + guojiang + "。");
			} catch (Exception e) {
				System.out.println("未找到计数空间无法显示果酱数量");
			}

		} catch (Exception e) {
			System.out.println("菜鸟出错" + e.toString());
			String error = e.toString();
			FalseInterface falesdriver = new FalseInterface();
			falesdriver.falseInterface(driver, error);
		}
		s_tuichu("菜鸟");
		driver.quit();
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
			String error = e.toString();
			FalseInterface falesdriver = new FalseInterface();
			try {
				falesdriver.falseInterface(driver, error);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
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
			} catch (Exception e) {
			}
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
			String error = e.toString();
			FalseInterface falesdriver = new FalseInterface();
			try {
				falesdriver.falseInterface(driver, error);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
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
			Thread.sleep(7000);
			try {
				untilTimeOut(driver, "//android.widget.TextView[@text='重新购买']", 8);
				driver.pressKeyCode(AndroidKeyCode.BACK);
			} catch (Exception e) {
			}
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
			String error = e.toString();
			FalseInterface falesdriver = new FalseInterface();
			try {
				falesdriver.falseInterface(driver, error);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
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
			String error = e.toString();
			FalseInterface falesdriver = new FalseInterface();
			try {
				falesdriver.falseInterface(driver, error);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
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
			String error = e.toString();
			FalseInterface falesdriver = new FalseInterface();
			try {
				falesdriver.falseInterface(driver, error);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
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
			int outwhile = 0;
			while (1 < 2) {
				if (outwhile > 2) {
					break;
				}
				outwhile++;
				try {
					Thread.sleep(2000);
					stepXTimeOut(driver, "//android.widget.TextView[@text='我的']", 5);
					break;
				} catch (Exception e) {
					try {
						Thread.sleep(2000);
//						untilTimeOut(driver, "//android.widget.TextView[@text='发布闲置']", 5);
						driver.pressKeyCode(AndroidKeyCode.BACK);
					} catch (Exception e1) {
						Thread.sleep(2000);
					}
				}
			}
			Thread.sleep(2000);
			s_dianji("我的");
			stepXTimeOut(driver, "//android.widget.TextView[@text='我的鱼塘']", 5);
			Thread.sleep(2000);
			int picNum = 0;
			for (picNum = 0; picNum < 3; picNum++) {
				String firstString = "//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[";
				String secondString = "]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.ImageView[1]";

				String finalString = firstString + (picNum + 2) + secondString;
				s_panduan(finalString);
				stepX(driver, finalString);
				stepX(driver, "//android.widget.TextView[@text='签到']");
				Thread.sleep(3000);
				driver.pressKeyCode(AndroidKeyCode.BACK);
			}
			Thread.sleep(2000);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(2000);
			int ywdyt = driver.findElement(By.xpath("//android.widget.TextView[@text='我的鱼塘']")).getLocation().y;
			swipTo(driver, 500, ywdyt, 500, 200);
			Thread.sleep(2000);
			stepXTimeOut(driver, "//android.widget.TextView[@text='我的闲鱼币']", 3);
			Thread.sleep(8000);
			stepXTimeOut(driver, "//android.view.View[@content-desc='马上签到']", 5);
			Thread.sleep(5000);
			
		} catch (Exception e) {
			System.out.println("咸鱼出错" + e.toString());
			String error = e.toString();
			FalseInterface falesdriver = new FalseInterface();
			try {
				falesdriver.falseInterface(driver, error);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		s_tuichu("咸鱼");
		driver.quit();
		;
	}

	@SuppressWarnings("rawtypes")
	static void taobao() throws MalformedURLException, InterruptedException {
		String packageName = "com.taobao.taobao";
		String ActivityName = "com.taobao.tao.welcome.Welcome";
		FalseInterface falesdriver = new FalseInterface();
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		s_jinru("淘宝");

		try {

			s_deng(5);
			Thread.sleep(5000);
			judgeTaobaoScreen(driver);
			try {
				stepXTimeOut(driver, "//android.widget.TextView[@text='取消']", 3);
			} catch (Exception e) {
				System.out.println("界面无更新选项");
			}
			Thread.sleep(2000);
			s_deng(2);
			touch(driver, 950, 1800);
			s_dianji("我的");
			Thread.sleep(2000);
			s_deng(2);
			swipTo(driver, 50, 1108, 50, 280);
			Thread.sleep(10000);
			stepX(driver, "//android.widget.TextView[@text='查看全部工具']");
			s_dianji("查看全部工具");
			Thread.sleep(5000);
			stepX(driver, "//android.widget.TextView[@text='每日打卡']");
			s_dianji("每日打卡");
			s_deng(2);
			Thread.sleep(2000);
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
			// [466,158][613,215]_[402,230][690,518]
			Thread.sleep(5000);
			try {
				stepXTimeOut(driver,
						"//android.widget.ImageView[@content-desc='\\u70B9\\u51FB\\u5F00\\u5B9D\\u7BB1\\u9886\\u91D1\\u5E01']",
						3);
			} catch (Exception e) {
				touch(driver, 500, 300);
				System.out.println("touch点击宝箱");
			}
			try {
				untilTimeOut(driver, "//android.view.View[@content-desc='七日连续签到成功']", 5);
				touch(driver, 550, 1600);
			} catch (Exception e) {
				System.out.println("签到未满7日");
			}
			Thread.sleep(3000);
			int outWhilecode = 0;
			while (1 < 2) {
				try {
					stepXTimeOut(driver, "//android.view.View[@content-desc='今日任务']", 10);

					break;
				} catch (Exception e) {
					outWhilecode = outWhilecode + 1;
					if (outWhilecode >= 2) {
						break;
					}
				}
			}
			// =========================
			untilTimeOut(driver, "//android.widget.TextView[@text='任务中心']", 20);
			Thread.sleep(2000);
			int whileoutcode = 0;
			WebElement dianele = null;
			while (1 < 2) {
				try {
					Thread.sleep(2000);
					dianele = driver.findElement(By.xpath("//android.view.View[@content-desc='好店签到']"));
				} catch (Exception e1) {
					try {
						dianele = driver.findElement(By.xpath("//android.view.View[@content-desc='币有好店']"));
					} catch (Exception e) {
						whileoutcode++;
					}
				}
				if (dianele != null) {
					break;
				}
				if (whileoutcode > 2) {
					break;
				}
			}
			int bx = dianele.getLocation().x;
			int by = dianele.getLocation().y;
			swipTo(driver, bx, by, 220, 220);
			System.out.println("移动好店到 最上面");
			Thread.sleep(2000);
			while (1 < 2) {
				try {
					Thread.sleep(1000);
					String signCoin = "//android.view.View[@content-desc='签到+']";
					untilTimeOut(driver, signCoin, 5);
					WebElement sign5 = driver.findElement(By.xpath(signCoin));
					stepXTimeOut(driver, signCoin, 3);
					Thread.sleep(2000);
					try {
						untilTimeOut(driver, "//android.view.View[@content-desc='店铺热卖']", 15);
						driver.pressKeyCode(AndroidKeyCode.BACK);
						Thread.sleep(2000);
						int y1 = sign5.getLocation().y;
						swipTo(driver, 10, y1, 10, 75);
					} catch (Exception e) {
						System.out.println("店铺热卖没有找到");
						try {
							falesdriver.falseInterface(driver, e.toString());
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						break;
					}

					Thread.sleep(2000);
					try {
						untilTimeOut(driver, "//android.view.View[@content-desc='猜你喜欢']", 3);
						try {
							Thread.sleep(2000);
							driver.findElement(By.xpath(signCoin));
							continue;
						}catch (Exception e) {
							break;
						}
					}catch (Exception e) {
						continue;
					}
				} catch (Exception e) {
					try {
						falesdriver.falseInterface(driver, e.toString());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
			// 店铺领金币结束
		} catch (Exception e) {
			System.out.println("淘宝报错" + e.toString());
			String error = e.toString();
			
			try {
				falesdriver.falseInterface(driver, error);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
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
			String error = e.toString();
			FalseInterface falesdriver = new FalseInterface();
			try {
				falesdriver.falseInterface(driver, error);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		driver.quit();
	}

	static void zhifubao() throws MalformedURLException, InterruptedException {
		String packageName = "com.eg.android.AlipayGphone";
		String ActivityName = ".AlipayLogin";
		FalseInterface falesdriver = new FalseInterface();
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		try {
			 try {
			 Thread.sleep(5000);
			 stepXTimeOut(driver, "//android.widget.TextView[@text='运动']",5);
			 Thread.sleep(2000);
//			 stepXTimeOut(driver, "//android.view.View[@content-desc='行走捐']", 3);
//			 Thread.sleep(2000);
			 try {
				 Thread.sleep(2000);
				 untilTimeOut(driver, "//android.view.View[@content-desc='今天公益金额度已兑完，明天早点来哦！']", 3);
				 System.out.println("公益金额度已兑完");
			 }catch (Exception e) {
				 try {
					 untilTimeOut(driver,"//android.view.View[@content-desc='今日步数']",5);
					 } catch (Exception e11) {
					 }
					 Thread.sleep(5000);
					 touch(driver, 736, 1336);
					 Thread.sleep(2000);
					 stepX(driver, "//android.view.View[@resource-id='J-confirmExchangeBtn']");
					 System.out.println("确定");
					 Thread.sleep(3000);
					 driver.pressKeyCode(AndroidKeyCode.BACK);
					 Thread.sleep(1000);
					 
			 }} catch (Exception e1) {
				 try {
						falesdriver.falseInterface(driver, "运动界面报错");
					} catch (FileNotFoundException e2) {
						e1.printStackTrace();
					}
			
			 Thread.sleep(1000);
			 driver.pressKeyCode(AndroidKeyCode.BACK);
			 Thread.sleep(1000);
			 }
			 try {
			 untilTimeOut(driver, "//android.widget.TextView[@text='大学生活']", 5);
			 } catch (Exception e) {
			 driver.pressKeyCode(AndroidKeyCode.BACK);
			 }
			 // touch(driver, 33, 175);// [0,66][132,210]
			 stepX(driver, "//android.widget.TextView[@text='大学生活']");
			 untilX(driver, "//android.widget.TextView[@text='湘潭大学']");
			 driver.pressKeyCode(AndroidKeyCode.BACK);
			 Thread.sleep(3000);
			 stepX(driver, "//android.widget.TextView[@text='大学生活']");
			 untilX(driver, "//android.widget.TextView[@text='湘潭大学']");
			 Thread.sleep(2000);
			 stepXTimeOut(driver, "//android.view.View[@content-desc='我的']", 5);
			 Thread.sleep(5000);
			 touchmiddle(driver, "[0,780][540,1071]");
			 stepX(driver, "//android.widget.Button[@content-desc='马上签到']");
			
			 while (1 < 2) {
			 Thread.sleep(200);
			 try {
			 Thread.sleep(1500);
			 WebElement fanhui = driver.findElement(By.xpath(
			 "//android.widget.TextView[@resource-id='com.alipay.mobile.nebula:id/h5_tv_nav_back']"));
			 fanhui.click();
			 } catch (Exception e) {
			 break;
			 }
			 }

			// ++++++++++++++++蚂蚁会员签到——++++++++++
			Thread.sleep(4000);
			 stepX(driver,"//android.widget.TextView[@resource-id='com.alipay.android.phone.wealth.home:id/tab_description']");// 我的
			Thread.sleep(3000);
			stepX(driver, "//android.widget.TextView[@text='蚂蚁会员']");
			Thread.sleep(5000);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(2000);
			stepX(driver, "//android.widget.TextView[@text='蚂蚁会员']");

//			//android.view.View[@content-desc='花呗支付']
			int whileout = 0;
			while (1 < 2) {
				if (whileout >= 3) {
					try {
						falesdriver.falseInterface(driver, "循环进入积分签到界面检查超过3次");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					break;
				}
				whileout++;
				try {
					Thread.sleep(2000);
					stepXTimeOut(driver, "//android.view.View[@content-desc='赚积分']", 2);
				} catch (Exception e1) {
					System.out.println("未找到赚积分按钮");
				}
				try {
					Thread.sleep(2000);
					stepXTimeOut(driver, "//android.view.View[@content-desc='领积分']", 2);
				} catch (Exception e) {
					System.out.println("未找到领积分按钮");
				}
			

				try {
					untilTimeOut(driver, "//android.view.View[@content-desc='可用积分']", 3);
					System.out.println("进入积分签到界面");
					break;
				} catch (Exception e) {
				}
			}
			for(int i= 0;i<10;i++) {
				System.out.println(i);
			Thread.sleep(2000);
			try {
			stepXTimeOut(driver, "//android.view.View[@content-desc='点击领取']", 4);
			
			}catch (Exception e) {
			break;
				}
			}
//			===============================明日赛==================================
				driver.pressKeyCode(AndroidKeyCode.BACK);
				Thread.sleep(1000);
				stepXTimeOut(driver, "//android.view.View[@content-desc='行走赛']", 5);
				Thread.sleep(3000);
				try {
					untilTimeOut(driver, "//android.view.View[@content-desc='恭喜你']", 5);
					stepXTimeOut(driver, "//android.widget.Button[@content-desc='报名明日比赛']", 5);
				}catch (Exception e) {
					stepXTimeOut(driver, "//android.view.View[@content-desc='报名明日比赛']", 5);
				}
				Thread.sleep(2000);
				stepXTimeOut(driver, "//android.view.View[@content-desc='立即使用积分报名']", 5);
				Thread.sleep(1000);
				stepXTimeOut(driver, "//android.widget.Button[@text='确认报名']", 5);
				
				
//			======================================================================		
				
		
		} catch (Exception e) {
			System.out.println("支付宝出错");
			String error = e.toString();
			
			try {
				falesdriver.falseInterface(driver, error);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}

		Thread.sleep(2000);
		driver.quit();

	}

	private static void XpathListClick(AndroidDriver driver,String Xpath) throws InterruptedException {
		Thread.sleep(500);
		@SuppressWarnings("rawtypes")
		List XpathList = driver.findElements(By.xpath(Xpath));
		int XpathListNum = XpathList.size(),i=0;
		for(i=0;i<XpathListNum;i++) 
		{
			int x = ((WebElement) XpathList.get(i)).getLocation().x;
			int y =	((WebElement) XpathList.get(i)).getLocation().y;
			Thread.sleep(1000);
			touch(driver, x, y+50);
			
		}
	}

	static void yitao() throws MalformedURLException, InterruptedException {
		String packageName = "com.taobao.etao";
		String ActivityName = "com.taobao.sns.activity.LaunchActivity";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		FalseInterface falesdriver = new FalseInterface();
		Thread.sleep(5000);
		driver.quit();
		Thread.sleep(2000);

		@SuppressWarnings("rawtypes")
		AndroidDriver driver1 = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		int outwhilecode = 0;
		try {
			while (1 < 2) {
				if (outwhilecode >= 2) {
					break;
				}
				Thread.sleep(1000);
				try {
					stepXTimeOut(driver1, "//android.widget.TextView[@text='更新提示']", 3);
					stepXTimeOut(driver1, "//android.widget.Button[@text='取消']", 2);
				} catch (Exception e) {
					outwhilecode++;
				}
				System.out.println("检查是否需要更新" + outwhilecode);
			}

		} catch (Exception e) {
		}
		try {
			stepXTimeOut(driver1, "//android.widget.TextView[@text='签到送豪礼']", 10);
			s_dianji("签到送豪礼");
			Thread.sleep(5000);
			try {	stepXTimeOut(driver1, "//android.view.View[@content-desc='点我签到领钱']", 5);}catch (Exception e) {
				driver.pressKeyCode(AndroidKeyCode.BACK);
				Thread.sleep(2000);
				stepXTimeOut(driver1, "//android.widget.TextView[@text='签到送豪礼']", 5);
				stepXTimeOut(driver1, "//android.view.View[@content-desc='点我签到领钱']", 5);
			}
		
			Thread.sleep(2000);
			try {
				untilTimeOut(driver1, "//android.view.View[@content-desc='提醒规则']", 3);
				Thread.sleep(2000);
			} catch (Exception e) {
				Thread.sleep(2000);
				falesdriver.falseInterface(driver1, "捕捉宝箱界面");
			}
		} catch (Exception e) {
			try {
				String error = e.toString();
				falesdriver.falseInterface(driver1, error);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		driver1.quit();

	}

	static void Xinyue() throws MalformedURLException {
		// /
		String packageName = "com.tencent.tgclub";
		String ActivityName = ".ui.WelcomeActivity";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		try {
			Thread.sleep(8000);
			stepXTimeOut(driver, "//android.widget.TextView[@text='三国群英传']", 5);
			System.out.println("点击三国群英传");
			while (1 < 2) {
				Thread.sleep(1000);
				try {
					stepXTimeOut(driver,
							"//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.RelativeLayout[1]/android.widget.Button[1]",
							5);
					stepXTimeOut(driver,
							"//android.widget.Button[@resource-id='com.tencent.tgclub:id/choice_role_action_confirm']",
							5);
					Thread.sleep(2000);
					stepXTimeOut(driver, "//android.widget.Button[@resource-id='com.tencent.tgclub:id/tgvdialog_bt']",
							5);
				} catch (Exception e) {
					System.out.println("界面內无签到按钮");
					break;
				}

				Thread.sleep(5000);
				try {
					stepXTimeOut(driver, "//android.widget.Button[@resource-id='com.tencent.tgclub:id/get_gift3_btn']",
							5);
					stepXTimeOut(driver,
							"//android.widget.Button[@resource-id='com.tencent.tgclub:id/choice_role_action_confirm']",
							5);
					stepXTimeOut(driver, "//android.widget.Button[@resource-id='com.tencent.tgclub:id/tgvdialog_bt']",
							5);
				} catch (Exception e) {
				}
				stepXTimeOut(driver,
						"//android.widget.LinearLayout[@resource-id='com.tencent.tgclub:id/lottery_start_text_ll']/android.widget.ImageView[1]",
						5);
				System.out.println("点击抽奖");
				try {
					stepXTimeOut(driver,
							"//android.widget.Button[@resource-id='com.tencent.tgclub:id/choice_role_action_confirm']",
							5);
				} catch (Exception e) {
					stepX(driver, "//android.widget.Button[@resource-id='com.tencent.tgclub:id/tgvdialog_bt']");
				}
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			String error = e.toString();
			FalseInterface falesdriver = new FalseInterface();
			try {
				falesdriver.falseInterface(driver, error);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		driver.quit();

	}

	static void liantong() throws MalformedURLException {
		// /
		String packageName = "com.sinovatech.unicom.ui";
		String ActivityName = ".WelcomeClient";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		FalseInterface falesdriver = new FalseInterface();
		try {
			try {
				Thread.sleep(5000);
				int whileoutcode = 0;
				while(1<2) {
					if(whileoutcode>2) {break;}
					stepXTimeOut(driver, "//android.widget.TextView[@text='我的']", 5);
				try {
					untilTimeOut(driver, "//android.widget.TextView[@text='17621680259']", 5);
					break;
				}catch (Exception e) {
					Thread.sleep(1000);
					driver.pressKeyCode(AndroidKeyCode.BACK);
					
				}whileoutcode++;
				}
			
			Thread.sleep(5000);
			touchmiddle(driver,"[876,200][1080,278]");
			Thread.sleep(8000);
			touch(driver, 763, 457);
			
			}catch (Exception e) {
				try {
					String error = e.toString();
					falesdriver.falseInterface(driver, error);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
			}
			
			
			
		} catch (Exception e) {
			String error = e.toString();
			
			try {
				falesdriver.falseInterface(driver, error);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		driver.quit();

	}

	static void KFC() throws MalformedURLException {
		// /
		String packageName = "com.yek.android.kfc.activitys";
		String ActivityName = "com.yum.brandkfc.SplashAct";
		FalseInterface falesdriver = new FalseInterface();
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		System.out.println("KFC");
		try {
			Thread.sleep(2000);
			try {
				untilTimeOut(driver, "//android.widget.TextView[@text='请评价餐厅服务']", 5);
				Thread.sleep(1000);
				try {
					falesdriver.falseInterface(driver, "//android.widget.TextView[@text='请评价餐厅服务']界面截图");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				touchmiddle(driver, "[885,643][966,733]");
				Thread.sleep(1000);
				stepX(driver, "//android.widget.Button[@text='提交']");
			} catch (Exception e) {
			}
			try {
				stepXTimeOut(driver, "//android.widget.Button[@text='马上去抽']", 5);
				Thread.sleep(2000);
				int finalY = driver.manage().window().getSize().height;
				int finalX = driver.manage().window().getSize().width;
				TouchAction touch = new TouchAction(driver);
				touch.longPress(finalX / 2, finalY / 2).perform();
				Thread.sleep(2000);
				driver.pressKeyCode(AndroidKeyCode.BACK);
				Thread.sleep(1000);
				driver.pressKeyCode(AndroidKeyCode.BACK);
				Thread.sleep(1000);
			} catch (Exception e) {
			}

			try {
				Thread.sleep(2000);
				touchmiddle(driver, "[918,204][1050,279]");
				Thread.sleep(2000);
				stepXTimeOut(driver, "//android.widget.TextView[@text='签到']", 5);
				Thread.sleep(1000);
				touchmiddle(driver, "[444,99][636,164]");

			} catch (Exception e) {
			}

		} catch (Exception e) {
			String error = e.toString();

			try {
				falesdriver.falseInterface(driver, error);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		driver.quit();

	}

	static void quanjia() throws MalformedURLException {
		// /
		String packageName = "com.maxxipoint.android";
		String ActivityName = ".shopping.activity.WelcomeActivity";
		FalseInterface falesdriver = new FalseInterface();
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		System.out.println("进入享集联盟");
		try {
			Thread.sleep(5000);
			try {
				Thread.sleep(5000);
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
				stepXTimeOut(driver, "//android.widget.RadioButton[@text='我的']", 5);
			}
			Thread.sleep(2000);
			stepXTimeOut(driver, "//android.widget.TextView[@text='签到']", 5);
			Thread.sleep(2000);
//			stepXTimeOut(driver,
//					"//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.ImageView[1]",
//					5);
//			Thread.sleep(2000);
			stepXTimeOut(driver, "//android.widget.TextView[@text='每天签到赚积分']", 5);
			
		} catch (Exception e) {
			String error = e.toString();

			try {
				falesdriver.falseInterface(driver, error);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		driver.quit();

	}

	static void koudai() throws MalformedURLException, InterruptedException {
		String packageName = "com.qeeniao.mobile.kdjz";
		String ActivityName = ".BlankActivity";
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				appInffo(packageName, ActivityName));
		Thread.sleep(3000);
		TouchAction action = new TouchAction(driver);

		stepX(driver, "//android.widget.TextView[@text='理财']");
		Thread.sleep(3000);
		int q = 0;
		while (1 < 2) {
			try {
				List xpathList = driver.findElements(By.xpath("//android.widget.TextView[@text='领取']"));
				int e = xpathList.size();

				for (int i = 0; i < e; i++) {
					driver.findElement(By.xpath("//android.widget.TextView[@text='领取']")).click();
					q++;
					try {
						Thread.sleep(2000);
						driver.findElement(By.xpath("//android.widget.TextView[@text='立即收取']")).click();
						Thread.sleep(1000);

					} catch (Exception p) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("//android.widget.ImageView[@index='0']")).click();
					}
				}
				System.out.println("领取次数：" + q);
			} catch (Exception e) {
			}
			Thread.sleep(20000);
		}

	}

	/* =============================辅助方法============================= */
	static private void whileXpath(@SuppressWarnings("rawtypes") AndroidDriver driver, String Xpath)
			throws InterruptedException {
		int whileCode = 0;
		while (1 < 2) {
			if (whileCode >= 3) {
				break;
			}
			try {
				stepXTimeOut(driver, Xpath, 3);
			} catch (Exception e) {
				whileCode++;
			}
			Thread.sleep(1000);

		}
	}

	static private void judgeTaobaoScreen(@SuppressWarnings("rawtypes") AndroidDriver driver) {
		System.out.println("开始判断是否弹出淘宝界面");
		int inScreenIcon = 0;
		int outwhilecode = 0;
		while (1 < 2) {
			try {
				driver.findElement(
						By.xpath("//android.widget.TextView[@resource-id='com.taobao.taobao:id/pai_li_tao_icon']"));
				inScreenIcon = 1;
			} catch (Exception e) {
				try {
					driver.findElement(
							By.xpath("//android.widget.TextView[@resource-id='com.taobao.taobao:id/tv_scan_text']"));
					inScreenIcon = 1;
				} catch (Exception e1) {
					try {
						driver.findElement(By.xpath(
								"//android.widget.TextView[@resource-id='com.taobao.taobao:id/tv_member_code_text']"));
						inScreenIcon = 1;
					} catch (Exception e2) {
						// try {
						// driver.findElement(By.xpath("//android.widget.TextView[@text='充值中心']"));
						// inScreenIcon = 1;
						// } catch (Exception e3) {
						System.out.println("未判断到在淘宝界面内");
						// }
					}
				}
			}
			outwhilecode++;
			if (outwhilecode > 2) {
				System.out.println("淘宝进入界面判断代码段出错");
				break;
			}
			if (inScreenIcon == 1) {
				break;
			} else {
				stepX(driver, "//android.widget.TextView[@text='手机淘宝']");
			}
		}
	};
	
	
}
