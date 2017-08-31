package YYGL_Common;

public class test01 {
	public static void main(String[] args) {
		String a="30.22";
		String b="20.11";
		
		double n_c= Double.parseDouble(a)-Double.parseDouble(b);
		String c= String.valueOf(n_c);
		System.out.println(c);
	}

}
