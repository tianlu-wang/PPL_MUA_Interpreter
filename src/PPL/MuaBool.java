package PPL;

public class MuaBool extends Variable{
	public boolean b;
	public MuaBool(String input)
	{
		if(input.equals("true"))
			b = true;
		else
			b = false;
	}
	@Override
	public void print()
	{
		System.out.print(b);
		System.out.print(" ");
	}
}
