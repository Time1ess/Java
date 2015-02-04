package ChapFive;

public class Manager extends Employee {
	
	private double bonus;
	
	public Manager(String name,double salary,double bonus)
	{
		super(name,salary);
		this.bonus=bonus;
	}
	
	public Manager()
	{
		super();
		this.bonus=0;
	}
	
	public String toString()
	{
		return super.toString()+"[Bonus:"+bonus+"]";
	}
	
	public void setbonus(double bonus)
	{
		this.bonus=bonus;
	}
	
	public double getsalary()
	{
		return super.getsalary()+bonus;
	}
}
