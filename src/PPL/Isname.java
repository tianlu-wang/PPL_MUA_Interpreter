package PPL;

public class Isname extends Function{
	public Isname(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable var = ip.doInterpreter();
		if(var instanceof Word)
		{
			if(ip.MuaNameSpace.containsKey((Word) var))
			{
				//var can be found in namespace
				return new MuaBool("true");
			}
			else
				return new MuaBool("false");
		}
		else
		{
			System.out.println("It is not a word");
		}
		return null;
	}
}
