package PPL;

import java.util.LinkedList;

public class Run extends Function{
	public Run(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable myList = ip.doInterpreter();//return s list
		if(!(myList instanceof MuaList))
		{
			System.out.println( "it is not a list");
			Interpreter ip = this.ip;
			while(ip != null)
			{
				ip.command.clear();
				ip = ip.parent;
			}
			return null;
		}
		else
		{
			MuaList newMyList = (MuaList) myList;
			LinkedList<String> newList = newMyList.listTocommand();
			Interpreter TmpInterpreter = new Interpreter(ip);
			TmpInterpreter.AlterCommand(newList);
			while(TmpInterpreter.command.size() != 0)
				TmpInterpreter.doInterpreter();
		}
		return null;
	}
}
