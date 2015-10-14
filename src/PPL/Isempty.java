package PPL;

public class Isempty extends Function{
	public Isempty(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		Word retTrue = new Word("true");
		Word retWrong = new Word("false");
		if(num1 instanceof Word)
		{
			if(((Word) num1).s.length() == 0)
				return retTrue;
			else
				return retWrong;
		}
		else if(num1 instanceof MuaList)
		{
			if(((MuaList) num1).L.size() == 2)
				return retTrue;
			else
				return retWrong;
		}
		else
			return retWrong;
	}
}