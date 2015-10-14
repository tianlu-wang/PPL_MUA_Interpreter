package PPL;

public class Wait extends Function{
	public Wait(Interpreter ip){
		super(ip);
	}
	public Variable execute() throws Exception
	{ 
		Variable num1 = ip.doInterpreter();
		if(num1 instanceof Number)
		{
			String  s = ((Number) num1).a;
			Integer i = Integer.parseInt(s);
			try {
				Thread.sleep(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		else
		{
			System.out.println("not a number after wait");
			return null;
		}
		
	}
}
