package PPL;

public class Erase extends Function{
	public Erase(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable name = ip.doInterpreter();
		if(name instanceof Word)
		{
			
			Word newname = (Word)name;
			Interpreter ip = this.ip;
			while(ip != null)
			{
				if(ip.MuaNameSpace.containsKey(newname))
					break;
				ip = ip.parent;
			}
			if(ip != null)
				ip.MuaNameSpace.remove(newname);
			else
				System.out.println("can find the var when erase");
		}
		else if(name instanceof Number)
		{
			Word newname = new Word(((Number) name).a);
			Interpreter ip = this.ip;
			while(ip != null)
			{
				if(ip.MuaNameSpace.containsKey(newname))
					break;
				ip = ip.parent;
			}
			if(ip != null)
				ip.MuaNameSpace.remove(newname);
			else
				System.out.println("can find the var when erase");
		}
		else
		{
			System.out.println("after erase is not a word or a number");
		}
		return null;
	}
}
