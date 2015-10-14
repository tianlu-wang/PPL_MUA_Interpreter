package PPL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Load extends Function{
	public Load(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		FileReader fr;
		try {
			fr = new FileReader("namespace.txt");
			BufferedReader br = new BufferedReader(fr);
			String s;
			while((s = br.readLine()) != null)
			{
				String[] input = s.split(" ");
				Interpreter tmpInterpreter = new Interpreter(ip);
				LinkedList<String> newList = new LinkedList<String>();
				for(String item : input)
				{
					newList.add(item);
				}
				String first = newList.removeFirst();
				tmpInterpreter.AlterCommand(newList);
				ip.MuaNameSpace.put(new Word(first), tmpInterpreter.doInterpreter());
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
