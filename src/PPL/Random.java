package PPL;

public class Random extends Function{
	public Random(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		if(num1 instanceof Number)
		{
			String s = ((Number) num1).a;
			Double number = Double.valueOf(s);
			String s2 = ((Double)(Math.random() * number)).toString();
			return new Number(s2);
		}
		else
		{
			System.out.println("The first parameter is not a number in random function");
		}
		return null;
	}
}
