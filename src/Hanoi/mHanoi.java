package Hanoi;

public class mHanoi {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		mb_hanoi(3,'S','T','E');
	}
	
	public static void mb_hanoi(int n,char start,char temp,char end)
	{
		if(n<=1)
			System.out.println("���̴�"+start+"�ƶ���"+end);
		else
		{
			mb_hanoi(n-1,start,end,temp);
			System.out.println("���̴�"+start+"�ƶ���"+end);
			mb_hanoi(n-1,temp,start,end);
		}
	}

}
