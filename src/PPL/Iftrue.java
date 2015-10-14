package PPL;

import java.util.LinkedList;

public class Iftrue extends Function{
	public Iftrue(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		if(num1 instanceof MuaList)
		{
			if(ip.testResult == true)
			{
				MuaList newMyList = (MuaList) num1;
				LinkedList<String> newList = newMyList.listTocommand();
				Interpreter TmpInterpreter = new Interpreter(ip);
				TmpInterpreter.AlterCommand(newList);
				while(TmpInterpreter.command.size() != 0)
					TmpInterpreter.doInterpreter();
				return null;
			}
			else
			{
				System.out.println("do nothing because test result is false");
				return null;
			}
		}
		else
		{
			System.out.println("after iftrue is not a list in if true function");
			return null;
		}
	}
}
