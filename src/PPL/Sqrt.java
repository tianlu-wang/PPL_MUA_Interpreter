package PPL;

public class Sqrt extends Function{
	public Sqrt(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		if(num1 instanceof Number)
		{
			String s = ((Number) num1).a;
			Double number = Double.valueOf(s);
			String s2 = ((Double)(Math.sqrt(number))).toString();
			return new Number(s2);
		}
		else
		{
			System.out.println("The first parameter is not a number in random function");
		}
		return null;
	}
}
