package DecToH.B.O;

import java.util.Scanner;

public class DecConvert {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in=new Scanner(System.in);
		int m=in.nextInt();
		String BIN="";
		String HEX="";
		String OCT="";
		HEX=Integer.toHexString(m& 0x000000FF);
		BIN=Integer.toBinaryString(m& 0x000000FF);
		OCT=Integer.toOctalString(m& 0x000000FF);
		System.out.println(BIN+'\n'+OCT+'\n'+HEX);
		in.close();
		System.exit(0);
	}

}
