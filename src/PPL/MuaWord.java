package PPL;

public class MuaWord extends Function{
	public MuaWord(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable word1 = ip.doInterpreter();
		Variable word2 = ip.doInterpreter();
		String s = ((Word) word1).s ;
		if(word2 instanceof Word)
		{
			s = s + ((Word) word2).s;
		}
		else if(word2 instanceof Number)
		{
			s = s + ((Number) word2).a;
		}
		else if(word2 instanceof MuaBool)
		{
			s = s + ((MuaBool) word2).b;
		}
		return new Word(s);
	}
}
