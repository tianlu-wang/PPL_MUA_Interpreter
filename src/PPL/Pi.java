package PPL;

public class Pi extends Function{
	public Pi(Interpreter ip){
		super(ip);
	}
	public Variable execute()
	{ 
		Double i = 3.14159;
		String s = i.toString();
		return new Number(s);
	}
}
