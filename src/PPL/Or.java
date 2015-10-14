package PPL;

public class Or extends Function{
	public Or(Interpreter ip){
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
				if(a.equals("false") && b.equals("false"))
					return retWrong;
				else
					return retTrue;
			}
			else
			{
				System.out.println("The second parameter is not a number in or function");
			}
		}
		else
		{
			System.out.println("The first parameter is not a number in or function");
		}
		return null;
	}
}