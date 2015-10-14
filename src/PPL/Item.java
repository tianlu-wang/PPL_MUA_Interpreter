package PPL;

public class Item extends Function{
	public Item(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		Variable num2 = ip.doInterpreter();
		if(num1 instanceof Number)
		{
			String s0 = ((Number) num1).a;
			Integer i = Integer.parseInt(s0);
			if(num2 instanceof Word)
			{
				String s = ((Word) num2).s;
				char c = s.charAt(i);
				String s2 = String.valueOf(c);
				return new Word(s2);
			}
			else if(num2 instanceof MuaList)
			{
				return ((MuaList) num2).L.get(i + 1);
			}
			else
			{
				System.out.println("after item the second is not a word or a list");
				return null;
			}
		}
		else
		{
			System.out.println("after item the first var is not a number");
			return null;
		}
		
	}
}
