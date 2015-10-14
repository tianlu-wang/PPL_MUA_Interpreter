package PPL;

public class Poall extends Function{
	public Poall(Interpreter ip){
		super(ip);
	}
	public Variable execute()
	{ 
		for(Word w : ip.MuaNameSpace.keySet())
		{
			System.out.print(w.s + " ");
			ip.MuaNameSpace.get(w).print();
			System.out.println("");
		}
		return null;
	}
}
