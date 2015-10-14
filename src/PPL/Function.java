package PPL;


public abstract class Function {
	//find a common place between all functions
	public Interpreter ip;
	public Function(Interpreter ip)
	{
		this.ip = ip;
	}
	public abstract Variable execute() throws Exception;
}
