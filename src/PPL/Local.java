package PPL;

public class Local extends Function{
	public Local(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable name = ip.doInterpreter();
		if(name instanceof Word)
		{
			Word newname = (Word)name;
			ip.MuaNameSpace.put(newname, null);
		}
		else if(name instanceof Number)
		{
			Word newname = new Word(((Number) name).a);
			ip.MuaNameSpace.put(newname, null);
		}
		else
		{
			System.out.println("after local is not a word");
		}
		
		return null;
	}

}
