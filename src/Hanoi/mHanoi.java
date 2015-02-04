package Hanoi;

public class mHanoi {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		mb_hanoi(3,'S','T','E');
	}
	
	public static void mb_hanoi(int n,char start,char temp,char end)
	{
		if(n<=1)
			System.out.println("将盘从"+start+"移动到"+end);
		else
		{
			mb_hanoi(n-1,start,end,temp);
			System.out.println("将盘从"+start+"移动到"+end);
			mb_hanoi(n-1,temp,start,end);
		}
	}

}
