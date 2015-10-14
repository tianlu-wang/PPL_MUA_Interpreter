package PPL;

public class And extends Function{
	public And(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		Variable num2 = ip.doInterpreter();
		Word retTrue = new Word("true");
		Word retWrong = new Word("false");
		if(num1 instanceof Word)
		{
			if(num2 instanceof Word)
			{
				String a = ((Word) num1).s;
				String b = ((Word) num2).s;
				if(a.equals("true") && b.equals("true"))
					return retTrue;
				else
					return retWrong;
			}
			else
			{
				System.out.println("The second parameter is not a number in and function");
			}
		}
		else
		{
			System.out.println("The first parameter is not a number in and function");
		}
		return null;
	}
}