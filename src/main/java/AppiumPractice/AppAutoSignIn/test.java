package AppiumPractice.AppAutoSignIn;

public class test {
public static void main(String[] args) {

		String strings ="=[864,1867][1080,1908]";
		int A,B,C,D=0;
		String str1 = strings.substring(strings.indexOf("[")+1, strings.indexOf(","));
		String str2 = strings.substring(strings.indexOf(",")+1, strings.indexOf("]"));
		StringBuilder sb = new StringBuilder(strings);
		sb.replace(strings.indexOf("["), strings.indexOf("]")+1, "*");
		strings = sb.toString();
		String str3 = strings.substring(strings.indexOf("[")+1, strings.indexOf(","));
		String str4 = strings.substring(strings.indexOf(",")+1, strings.indexOf("]"));
		A=Integer.parseInt(str1);
		B=Integer.parseInt(str2);
		C=Integer.parseInt(str3);
		D=Integer.parseInt(str4);
			
		int x = (int)(C-A)/2+A;
		int y = (int)(D-B)/2+B;
		System.out.println(x);
		System.out.println(y);

	
}
}
