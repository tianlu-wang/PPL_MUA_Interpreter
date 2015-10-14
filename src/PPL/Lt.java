package PPL;

public class Lt extends Function{
	public Lt(Interpreter ip){
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
				String a = ((Number) num1).a;
				String b = ((Number) num2).a;
				if(a.compareTo(b) < 0)
					return retTrue;
				else
					return retWrong;
			}
			else if(num2 instanceof Word)
			{
				String a = ((Number) num1).a;
				String b = ((Word) num2).s;
				if(a.compareTo(b) < 0)
					return retTrue;
				else
					return retWrong;
			}
		}
		else if(num1 instanceof Word)
		{
			if(num2 instanceof Number)
			{
				String a = ((Word) num1).s;
				String b = ((Number) num2).a;
				if(a.compareTo(b) < 0)
					return retTrue;
				else
					return retWrong;
			}
			else if(num2 instanceof Word)
			{
				String a = ((Word) num1).s;
				String b = ((Word) num2).s;
				if(a.compareTo(b) < 0)
					return retTrue;
				else
					return retWrong;
			}
		}
		return null;
	}
}
