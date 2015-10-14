package PPL;

import java.util.LinkedList;
import java.util.Scanner;

public class Readlist extends Function{
	public Readlist(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		String[] sArray = s.split(" ");
		MuaList retList = new MuaList();

		LinkedList<String> readList = new LinkedList<String>();
		for(String item : sArray)
			readList.add(item);
		
		Interpreter tmpInterpreter = new Interpreter(ip);
		tmpInterpreter.AlterCommand(readList);
		while(tmpInterpreter.command.size() != 0)
		{
			retList.L.add(tmpInterpreter.doInterpreter());
		}
		return retList;
	}

}
