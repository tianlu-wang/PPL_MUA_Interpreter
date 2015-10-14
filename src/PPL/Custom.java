package PPL;

import java.util.LinkedList;

public class Custom extends Function{
	public Custom(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		String functionName = ip.command.pollFirst();
		Word functionNameWord = new Word(functionName);
		Interpreter myip = this.ip;
		Variable value = null;
		while(myip != null)
		{
			value = myip.MuaNameSpace.get(functionNameWord);
			if(value != null) break;
			myip = myip.parent;
		}
		if(value instanceof MuaList)
		{
			//TODO:judge the form of the 
			Variable parameter = ((MuaList) value).L.get(1);
			Variable process = ((MuaList) value).L.get(2);
			if(parameter instanceof MuaList)
			{
				MuaList newMyList = (MuaList) process;
				LinkedList<String> newList = newMyList.listTocommand();
				Interpreter TmpInterpreter = new Interpreter(ip);
				TmpInterpreter.AlterCommand(newList);
				
				int numberOfParameter = ((MuaList) parameter).L.size() - 2;
				for(int i = 1; i <= numberOfParameter; i++)
				{
					Variable tmp = ((MuaList) parameter).L.get(i);
					String tmpString = ((Word) tmp).s;
					Word key = new Word(tmpString);
					Variable var = this.ip.doInterpreter();
					TmpInterpreter.MuaNameSpace.put(key, var);
				}
				try{
					while(TmpInterpreter.command.size() != 0)
					{
							 TmpInterpreter.doInterpreter();
					}
					return TmpInterpreter.var;
				}
				catch(Mystop e){
					System.out.println("Stopped.");
					return e.returnval;
				}
			}
			else
			{
				System.out.println(" parameter it is not a mualist");
			}
		}
		else
		{
			System.out.println("wrong content as a function");
			
		}
		return null;
	}

}
