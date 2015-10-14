package PPL;

public class Thing extends Function{
	public Thing(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable var = ip.doInterpreter();
		if(var instanceof Word)
		{
			Word newvar = (Word)var;
			Interpreter ip = this.ip;
			Variable value = null;
			while(ip != null)
			{
				value  = ip.MuaNameSpace.get(newvar);
				if(value != null) break;
				ip = ip.parent;
			}
			if(value == null)
				System.out.println("can not find the variable in the total nameSpace");
			return value;
		}
		else
		{
			System.out.println("Something is wrong in thing");
		}
		return null;
	}
}
