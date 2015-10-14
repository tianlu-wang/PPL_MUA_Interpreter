package PPL;

import java.util.LinkedList;

public class MuaList extends Variable{
	public LinkedList<Variable> L;
	public MuaList(Variable... input)//the number of element can not be sure
	{
		L = new LinkedList<Variable>();
		for(Variable v : input)
		{
			L.add(v); 
		}
	}
	@Override
	public void print()
	{
		for(Variable i : L)
		{
			i.print();
		}
	}
	public LinkedList<String> listTocommand()
	{
		LinkedList<String> myList = new LinkedList<String>();
		
		for(int i = 1; i < L.size() - 1; i ++)
		{
			Variable v = L.get(i);
			if(v instanceof Number)
				myList.add(((Number) v).a);
			else if(v instanceof Word)
				myList.add(((Word) v).s);
			else if(v instanceof MuaBool)
			{
				boolean b = ((MuaBool) v).b;
				if(b)
					myList.add("true");
				else
					myList.add("false");
			}
			else if(v instanceof MuaList)
			{
				MuaList newL = (MuaList) v;
				LinkedList<String> newList = newL.listTocommand();
				myList.add("[");
				for( String item : newList )
				{
					myList.add(item);
				}
				myList.add("]");
			}
		}
		//System.out.println(myList.toString());
		return myList;
	}
}
