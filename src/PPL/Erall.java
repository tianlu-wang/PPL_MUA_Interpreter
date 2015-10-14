package PPL;

public class Erall extends Function{
	public Erall(Interpreter ip){
		super(ip);
	}
	public Variable execute()
	{ 
		ip.MuaNameSpace.clear();
		return null;
	}
}
