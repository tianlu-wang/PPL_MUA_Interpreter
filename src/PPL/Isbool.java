package PPL;

public class Isbool extends Function{
	public Isbool(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		Word retTrue = new Word("true");
		Word retWrong = new Word("false");
		if(num1 instanceof Word)
		{
			String s = ((Word) num1).s;
			if(s.equals("true") || s.equals("false"))
				return retTrue;
			else
				return retWrong;
		}
		else
			return retWrong;
	}
}