package AppiumPractice.AppAutoSignIn;

public class test {
public static void main(String[] args) {

		String strings ="=[864,1867][1080,1908]";
		int A,B,C,D=0;
		int Aindex = strings.indexOf("[");
		int Bindex = strings.indexOf(",");
		int Cindex = strings.indexOf("]");
		int Dindex = strings.indexOf("[",1);
		int Eindex = strings.indexOf(",",1);
		int Findex = strings.indexOf("]",1);
		A=Integer.parseInt(strings.substring(Aindex+1, Bindex));
		B=Integer.parseInt(strings.substring(Bindex+1, Cindex));
		C=Integer.parseInt(strings.substring(Dindex+1, Eindex));
		D=Integer.parseInt(strings.substring(Eindex+1, Findex));
		System.out.println(""+A+" "+B+" "+C+" "+D);
		
	
}
}
