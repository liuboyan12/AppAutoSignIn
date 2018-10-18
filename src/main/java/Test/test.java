package Test;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import audoSignIn.ImageFindDemo;

public class test {
	public static void main(String[] args) {
		BufferedImage keyImage = test.getBfImageFromPath("D:\\桌面\\1.png");
	    int[][] screenShotImageRGBData;   //屏幕截图RGB数据
	    screenShotImageRGBData = test.getImageGRB(keyImage);//获取【屏幕截图】的图片RGB数组
	    for(int i=0;i<10000;i++) 
	    {
	    	for(int o=0;o<10000;o++) {
	    		try {
	    		System.out.println(screenShotImageRGBData[i][o]+"  "+i+"  "+o);
	    	}catch (Exception e) {
			}
	    	}
	    }
	    
	    
		
	}

    public static BufferedImage getBfImageFromPath(String keyImagePath) {
        BufferedImage bfImage = null;
        try {
            bfImage = ImageIO.read(new File(keyImagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bfImage;
    }
    

public static int[][] getImageGRB(BufferedImage bfImage) {
    int width = bfImage.getWidth();
    int height = bfImage.getHeight();
    int[][] result = new int[height][width];
    for (int h = 0; h < height; h++) {
        for (int w = 0; w < width; w++) {
            //使用getRGB(w, h)获取该点的颜色值是ARGB，而在实际应用中使用的是RGB，所以需要将ARGB转化成RGB，即bufImg.getRGB(w, h) & 0xFFFFFF。
            result[h][w] = bfImage.getRGB(w, h) & 0xFFFFFF;
        }
    }
    return result;
}
public static BufferedImage getFullScreenShot() {
    BufferedImage bfImage = null;
    int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    try {
        Robot robot = new Robot();
        bfImage = robot.createScreenCapture(new Rectangle(0, 0, width, height));
    } catch (AWTException e) {
        e.printStackTrace();
    }
    return bfImage;
}

}