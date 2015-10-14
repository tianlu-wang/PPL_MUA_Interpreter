package PPL;

public class Not extends Function{
	public Not(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		Word retTrue = new Word("true");
		Word retWrong = new Word("false");
		if(num1 instanceof Word)
		{
			if(((Word) num1).s.equals("true"))
				return retWrong;
			else
				return retTrue;
		}
		else
		{
			System.out.println("The first parameter is not a number in not function");
		}
		return null;
	}
}