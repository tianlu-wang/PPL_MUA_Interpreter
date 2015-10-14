package PPL;


public class Make extends Function{
	public Make(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable name = ip.doInterpreter();
		if(name instanceof Word)
		{
			Word newname = (Word)name;
			Variable value = ip.doInterpreter();
			Interpreter ip = this.ip;
			boolean flag = false;
			while(ip.parent != null)
			{
				if(ip.MuaNameSpace.containsKey(newname))
				{
					ip.MuaNameSpace.put(newname, value);
					flag = true;
				}
				else
				{
					ip = ip.parent;
				}
				if(flag == true)
					break;
			}
			if(ip.parent == null)
			{
				ip.MuaNameSpace.put(newname, value);
			}
		}
		else if(name instanceof Number)
		{
			Word newname = new Word(((Number) name).a);
			Variable value = ip.doInterpreter();
			Interpreter ip = this.ip;
			while(ip.parent != null)
			{
				if(ip.MuaNameSpace.containsKey(newname))
				{
					ip.MuaNameSpace.put(newname, value);
					break;
				}
				else
				{
					ip = ip.parent;
				}
			}
			if(ip.parent == null)
			{
				ip.MuaNameSpace.put(newname, value);
			}
		}
		else
		{
			System.out.println("after make is not a word");
		}
		
		return null;
	}

}
