package rewriteAudoSignIn;

import java.io.File;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class test {
	public static void main(String[] args) throws DocumentException {

		test d1 = new test();
	        d1.parserXml("appData.xml"); //文件路径
	 
        
	}
	   public void parserXml(String fileName) {
	        File inputXml = new File(fileName);
	        SAXReader saxReader = new SAXReader();
	        try {
	            Document document = saxReader.read(inputXml);
	            Element users = document.getRootElement();
	            /*
	             * 使用Iterator 遍历xml文档
	              * */
	            for (Iterator i = users.elementIterator(); i.hasNext();) {
	                Element user = (Element) i.next();
	                for (Iterator j = user.elementIterator(); j.hasNext();) {
	                	
	                    Element node = (Element) j.next();
	                    System.out.println(node.getName() + ":" + node.getText());
	                }
	                System.out.println();
	            }
	        } catch (DocumentException e) {
	            System.out.println(e.getMessage());
	        }
	    }

}
