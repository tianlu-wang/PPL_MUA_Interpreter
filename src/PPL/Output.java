package PPL;

public class Output extends Function{
	public Output(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable var = ip.doInterpreter();
		//System.out.println(((Number)var).a);
		ip.var = var;
		//System.out.println(((Number)(ip.var)).a);
		return null;
		
	}
}
