package PPL;

public class Eq extends Function{
	public Eq(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		Variable num2 = ip.doInterpreter();
		Word retTrue = new Word("true");
		Word retWrong = new Word("false");
		if(num1 instanceof Number)
		{
			if(num2 instanceof Number)
			{
				Double a = Double.valueOf(((Number) num1).a);
				Double b = Double.valueOf(((Number) num2).a);
				if((a - b) == 0.0)
					return retTrue;
				else
					return retWrong;
			}
			else if(num2 instanceof Word)
			{
				if(((Number) num1).a.equals(((Word) num2).s))
					return retTrue;
				else
					return retWrong;
			}
		}
		else if(num1 instanceof Word)
		{
			if(num2 instanceof Number)
			{
				if(((Word) num1).s.equals(((Number) num2).a))
					return retTrue;
				else
					return retWrong;
			}
			else if(num2 instanceof Word)
			{
				if(((Word) num1).s.equals(((Word) num2).s))
					return retTrue;
				else
					return retWrong;
			}
		}
		return null;
	}
}
