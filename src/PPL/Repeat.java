package PPL;

import java.util.LinkedList;

public class Repeat extends Function{
	public Repeat(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable number = ip.doInterpreter();
		if(number instanceof Number)
		{
			
			LinkedList<String> tmpCommand = new LinkedList<String>();
			for(int i = 0; i < Integer.parseInt(((Number) number).a); i++)
			{
				for(String s : ip.command)//copy the command
				{
					tmpCommand.add(s);
				}
			}
			ip.command.clear();
			for(String s : tmpCommand)
				ip.command.add(s);
			return ip.doInterpreter();
		}
		else
		{
			System.out.println("The first parameter must be a number!");
		}
		return null;
	}
}
