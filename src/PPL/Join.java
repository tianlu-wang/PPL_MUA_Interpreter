package PPL;

public class Join extends Function{
	public Join(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable list = ip.doInterpreter();
		if(list instanceof MuaList)
		{
			Variable value = ip.doInterpreter();
			MuaList myList = (MuaList) list;
			myList.L.removeLast();
			myList.L.add(value);
			myList.L.add(new Word("]"));
			return myList;
		}
		else
		{
			System.out.println("this is not a list in join function");
			return null;
		}
		
	}
}