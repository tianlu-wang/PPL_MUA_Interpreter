package PPL;

public class Isnumber extends Function{
	public Isnumber(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		Word retTrue = new Word("true");
		Word retWrong = new Word("false");
		if(num1 instanceof Number)
			return retTrue;
		else
			return retWrong;
	}
}