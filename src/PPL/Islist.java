package PPL;

public class Islist extends Function{
	public Islist(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		Word retTrue = new Word("true");
		Word retWrong = new Word("false");
		if(num1 instanceof MuaList)
			return retTrue;
		else
			return retWrong;
	}
}