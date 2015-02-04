package ChapFive;

public class Employee {
	
	private static int NEXTid=1;
	private String name;
	private double salary;
	private int id;
	
	public Employee(String name,double salary)
	{
		this.name=name;
		this.salary=salary;
		this.id=NEXTid++;
	}
	
	public String toString()
	{
		return getClass().getName().substring(9)+" [Name:"+name+" Salary:"+salary+" Id:"+id+"]";
	}
	
	public Employee()
	{
		this.name="";
		this.salary=0;
		this.id=NEXTid++;
	}
	
	public void raisesalary(double percent)
	{
		this.salary*=(1+percent/100);
	}
	
	public static int getNEXTid()
	{
		return NEXTid;
	}
	
	public String getname()
	{
		return name;
	}
	
	public double getsalary()
	{
		return salary;
	}
	
	public void setsalary(double salary)
	{
		this.salary=salary;
	}
	
	public int getid()
	{
		return id;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Employee[] M=new Employee[3];
		Manager Boss=new Manager("Timeless",2000,500);
		M[0]=Boss;
		M[1]=new Employee("Tim",500);
		M[2]=new Employee("Sam",800);
		for(Employee x:M)
			System.out.println(x);
		M[0].raisesalary(30);
		System.out.println(M[0]);
		System.out.println(Boss);
	}

}
