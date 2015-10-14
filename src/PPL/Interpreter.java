package PPL;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
/*
 * must transfer the name space and functions
 */
public class Interpreter {
	boolean testResult = true;
	Variable var;
	LinkedList<String> command;
	Interpreter parent;
	public HashMap<Word, Variable> MuaNameSpace = new HashMap<Word, Variable>();//the context
	//use Class as a object
	public final static HashMap<String, Class<? extends Function>> MuaFunctions = new HashMap<String, Class<? extends Function>>();
	static{
		MuaFunctions.put("make", Make.class);//TODO
		MuaFunctions.put("thing", Thing.class);
		MuaFunctions.put("print", Print.class);
		MuaFunctions.put("erase", Erase.class);
		MuaFunctions.put("isname", Isname.class);
		MuaFunctions.put("list", List.class);
		MuaFunctions.put("word", MuaWord.class);
		MuaFunctions.put("add", Add.class);
		MuaFunctions.put("sub", Sub.class);
		MuaFunctions.put("repeat", Repeat.class);
		MuaFunctions.put("run", Run.class);
		MuaFunctions.put("local", Local.class);
		MuaFunctions.put("custom", Custom.class);
		MuaFunctions.put("mul", Mul.class);//TODO
		MuaFunctions.put("readlist", Readlist.class);
		MuaFunctions.put("div", Div.class);
		MuaFunctions.put("eq", Eq.class);
		MuaFunctions.put("gt", Gt.class);
		MuaFunctions.put("lt", Lt.class);
		MuaFunctions.put("and", And.class);
		MuaFunctions.put("or", Or.class);
		MuaFunctions.put("not", Not.class);
		MuaFunctions.put("random", Random.class);
		MuaFunctions.put("sqrt", Sqrt.class);
		MuaFunctions.put("isnumber", Isnumber.class);
		MuaFunctions.put("isword", Isword.class);
		MuaFunctions.put("islist", Islist.class);
		MuaFunctions.put("isbool", Isbool.class);
		MuaFunctions.put("isempty", Isempty.class);
		MuaFunctions.put("test", Test.class);
		MuaFunctions.put("iftrue", Iftrue.class);
		MuaFunctions.put("iffalse", Iffalse.class);
		MuaFunctions.put("join", Join.class);
		MuaFunctions.put("first", First.class);
		MuaFunctions.put("last", Last.class);
		MuaFunctions.put("item", Item.class);
		MuaFunctions.put("butfirst", Butfirst.class);
		MuaFunctions.put("butlast", Butlast.class);
		MuaFunctions.put("stop", Stop.class);
		MuaFunctions.put("wait", Wait.class);
		MuaFunctions.put("poall", Poall.class);
		MuaFunctions.put("erall", Erall.class);
		MuaFunctions.put("save", Save.class);
		MuaFunctions.put("load", Load.class);
		MuaFunctions.put("pi", Pi.class);
		MuaFunctions.put("output", Output.class);
	}
	public Interpreter(Interpreter parent)//constructor
	{
		this.parent = parent;
	}
	public void AlterCommand(LinkedList<String> command){
		this.command = command;
	}
	public Variable doInterpreter() throws Exception
	{
		System.out.println(command);
		Class<? extends Function> executionClass = MuaFunctions.get(command.getFirst());
		if(executionClass == null)//if the element is not a  command
		{
			String s = command.getFirst();
			if(s.charAt(0) == ':')
			{
				String subString = s.substring(1);
				command.pollFirst();//erase the first element
				Word newvar = new Word(subString);
				Interpreter ip = this;
				Variable value = null;
				while(ip != null)
				{
					value  = ip.MuaNameSpace.get(newvar);
					if(value != null) break;
					ip = ip.parent;
				}
				if(value != null)
				{
					return value;//get the value of the word in the namespace;
				}
				else
					System.out.println("can not find in nameSpace by :");
				return null;
			}
			else if(((s.charAt(0)>='0')&&(s.charAt(0)<='9')) || (s.charAt(0)=='-'))
			{
				command.pollFirst();//erase the first element
				return new Number(s);//return a number
			}
			else if(s.charAt(0) == '"')
			{
				String subString = s.substring(1);
				command.pollFirst();//erase the first element
				return new Word(subString);//return a word
			}
			else if(s.equals("["))//assume that in a list there is a space between [ and the first element
			{
				MuaList myList = findRightBracket();
				return myList;
			}
			else if(s.equals("//"))
			{
				command.clear();//content after "//" should not be parse
				return null;
			}
			else //input is illegal
			{
				Function custom = new Custom(this);
				return custom.execute();
				
			}
		}
		else
		{
			command.pollFirst();
			return CMD_interpreter(executionClass);
			
		}
	}
	public Variable CMD_interpreter(Class<? extends Function> executionClass) throws Exception
	{
		
		Constructor<? extends Function> constructor = executionClass.getConstructor(Interpreter.class);
		Function exeuction = constructor.newInstance(this);//produce a object and pass interpreter on 
		return exeuction.execute();
	
	}
	public MuaList findRightBracket()//content in a list is all string or word a recursion function
	{
		MuaList myList = new MuaList(new Word("["));
		command.pollFirst();
		String s = command.getFirst();
		while((!(s.equals("]"))) && (!(s.equals(null))))
		{
			if(s.equals("["))
			{
				myList.L.add(findRightBracket());//return a sublist
			}
			else
			{
				myList.L.add(new Word(s));
				command.pollFirst();
			}		
			s = command.getFirst();
		}
		if(s.equals("]"))
		{
			myList.L.add(new Word(s));
			command.pollFirst();
		}
		else
			System.out.println("list input wrong");
		return myList;
	}
}
