package PPL;

public class Number extends Variable{
	public String a;
	public Number(String input)
	{
		a = input;
	}
	@Override
	public void print()
	{
		System.out.print(a);
		System.out.print(" ");
	}
}
