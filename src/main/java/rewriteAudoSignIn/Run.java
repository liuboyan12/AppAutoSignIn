package rewriteAudoSignIn;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Run {
	String deviceName = "741AECR82S8DF";
	static int mistake = 0;
	public static void main(String[] args) throws DocumentException, MalformedURLException, FileNotFoundException, InterruptedException {

		Run d1 = new Run();
	    d1.run("appData.xml");
	}
	
	//进行判断，该执行那个APP的脚本
	void judgeScript(String judgeString,List lists) 
			throws MalformedURLException, InterruptedException, FileNotFoundException {
		extendAutoSignDo extendAutoSignDo = new extendAutoSignDo();
		String packageName=lists.getItem(0).toString();
		String ActivityName = lists.getItem(1).toString();
//		System.out.println("judgeScript:"+judgeString);
		if(judgeString.equals("feiZhu")) {
			extendAutoSignDo.feiZhu(packageName, ActivityName, deviceName);
		}
		else if (judgeString.equals("xianYu")) {
			extendAutoSignDo.xianYu(packageName, ActivityName, deviceName);
		}
		else if (judgeString.equals("caiNiao")) {
			extendAutoSignDo.caiNiao(packageName, ActivityName, deviceName);
		}
		else if (judgeString.equals("youDao")) {
			extendAutoSignDo.youDao(packageName, ActivityName, deviceName);
		}
		else if (judgeString.equals("jingDongStock")) {
			extendAutoSignDo.jingDongStock(packageName, ActivityName, deviceName);
		}
		else if (judgeString.equals("yiTao")) {
			extendAutoSignDo.yiTao(packageName, ActivityName, deviceName);
		}
		else if (judgeString.equals("yunYinYue")) {
			extendAutoSignDo.yunYinYue(packageName, ActivityName, deviceName);
		}
		else if (judgeString.equals("KFC")) {
			extendAutoSignDo.KFC(packageName, ActivityName, deviceName);
		}
		else if (judgeString.equals("quanJia")) {
			extendAutoSignDo.quanJia(packageName, ActivityName, deviceName);
		}
		else {System.out.println("该APP尚未记录，请查找appData.xml及extendAutoSignDo.java文件");}
	}
	
	//遍历xml文件，取出格式相应数据
	@SuppressWarnings("rawtypes")
	void run(String fileName) 
			throws DocumentException, MalformedURLException, FileNotFoundException, InterruptedException
		{
		File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputXml);
        Element users = document.getRootElement();
        for (Iterator i = users.elementIterator(); i.hasNext();) {
            Element user = (Element) i.next();
            String judgement = user.attributeValue("name");
            System.out.println(judgement);
            System.out.println("查找到'"+judgement+"'APP信息");
            List list = new List();
            for (Iterator j = user.elementIterator(); j.hasNext();){
            		Element node = (Element) j.next();
            		list.add(node.getText());
            	}
            judgeScript(judgement,list);
		}
        System.out.println();
        System.out.println("========");
        System.out.println("=脚本完成=");
        System.out.println("========");
        System.out.println();
        System.out.println("共计报错"+mistake+"次数");
	}

	//Xml读取的demo
	public List parserXml(String fileName,String outConfig) {
	        File inputXml = new File(fileName);
	        SAXReader saxReader = new SAXReader();
	        try {
	            Document document = saxReader.read(inputXml);
	            Element users = document.getRootElement();
	            /*
	             * 使用Iterator 遍历xml文档
	              * */
	            for (@SuppressWarnings("rawtypes")
				Iterator i = users.elementIterator(); i.hasNext();) {
	                Element user = (Element) i.next();
	                String judge = user.attributeValue("name");
	                if(outConfig==judge) {
	                	List list = new List();
	                	System.out.println("查找到'"+judge+"'APP信息");
	                	for (@SuppressWarnings("rawtypes")
						Iterator j = user.elementIterator(); j.hasNext();) {
		                	Element node = (Element) j.next();
		                	list.add(node.getText());
		                	return list;
	                	}
	                }
	                
	                

	                System.out.println();
	            }
	        } catch (DocumentException e) {
	            System.out.println(e.getMessage());
	        }
			return null;
	    }

}
