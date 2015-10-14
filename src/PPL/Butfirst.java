package PPL;

public class Butfirst extends Function{
	public Butfirst(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		if(num1 instanceof Word)
		{
			String s = ((Word) num1).s;
			String sub = s.substring(1, s.length() - 1);
			String s2 = String.valueOf(sub);
			return new Word(s2);
		}
		else if(num1 instanceof MuaList)
		{
			((MuaList) num1).L.remove(1);
			return num1;
		}
		else
		{
			System.out.println("after first is not a word or a list");
			return null;
		}
	}

}
