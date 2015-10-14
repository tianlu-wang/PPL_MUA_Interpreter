package PPL;

public class Test extends Function{
	public Test(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		Word retTrue = new Word("true");
		Word retWrong = new Word("false");
		if(num1 instanceof Word)
		{
			String s = ((Word) num1).s;
			if(s.equals("true") )
			{
				ip.testResult = true;
				return retTrue;
			}
				
			else if(s.equals("false"))
			{
				ip.testResult = false;
				return retWrong;
			}
			else
			{
				System.out.println("after test is not a bool in test function");
				return null;
			}
		}
		else
		{
			System.out.println("after test is even not a word in test function");
			return null;
		}
			
	}
}