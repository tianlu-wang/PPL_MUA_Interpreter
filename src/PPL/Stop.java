package PPL;

public class Stop extends Function{
	public Stop(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Mystop
	{ 
		System.out.println("in stop");
		throw new Mystop(ip.var);
	}
}
