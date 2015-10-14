package PPL;

public class List extends Function{
	public List(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable list1 = ip.doInterpreter();
		Variable list2 = ip.doInterpreter();
		MuaList myList = new MuaList(new Word("["));
		myList.L.add(list1);
		myList.L.add(list2);
		myList.L.add(new Word("]"));
		return myList;
	}
}