package PPL;

public class Last extends Function{
	public Last(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		if(num1 instanceof Word)
		{
			String s = ((Word) num1).s;
			char c = s.charAt(s.length() - 1);
			String s2 = String.valueOf(c);
			return new Word(s2);
		}
		else if(num1 instanceof MuaList)
		{
			return ((MuaList) num1).L.get(((MuaList) num1).L.size() - 2);
		}
		else
		{
			System.out.println("after last is not a word or a list");
			return null;
		}
	}

}
