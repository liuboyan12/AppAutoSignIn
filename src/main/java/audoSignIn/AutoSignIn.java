package audoSignIn;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

/**
 * APPIUM手机自动化签到脚本
 *
 */
public class AutoSignIn {
	public static void main(String[] args) throws MalformedURLException, InterruptedException, FileNotFoundException {
		autoSignInDo autoSignInDo = new autoSignInDo();
		autoSignInDo.Feizhu();
		autoSignInDo.Cainiao();
		autoSignInDo.KFC();
		autoSignInDo.JingdongStock();
		autoSignInDo.quanjia();
		autoSignInDo.Xianyu();
		autoSignInDo.Yunyinyue();
		autoSignInDo.yitao();
		autoSignInDo.Youdao();
	}
	

}