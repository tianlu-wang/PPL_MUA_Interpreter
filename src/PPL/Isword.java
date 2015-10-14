package PPL;

public class Isword extends Function{
	public Isword(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		Word retTrue = new Word("true");
		Word retWrong = new Word("false");
		if(num1 instanceof Word)
			return retTrue;
		else
			return retWrong;
	}
}