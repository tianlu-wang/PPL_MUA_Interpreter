package PPL;

public class Print extends Function{
	public Print(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable output = ip.doInterpreter();
		if(output == null)
		{
			System.out.println("Can not find in namespace after print");
		}
		output.print();
		System.out.print("\n");
		return null;
	}
}
