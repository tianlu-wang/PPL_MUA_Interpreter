package PPL;

public class First extends Function{
	public First(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		if(num1 instanceof Word)
		{
			String s = ((Word) num1).s;
			char c = s.charAt(0);
			String s2 = String.valueOf(c);
			return new Word(s2);
		}
		else if(num1 instanceof MuaList)
		{
			return ((MuaList) num1).L.get(1);
		}
		else
		{
			System.out.println("after first is not a word or a list");
			return null;
		}
	}

}
