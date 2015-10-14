package PPL;

import java.util.Scanner;

public class Read extends Function{
	public Read(Interpreter ip){
		super(ip);
	}
	public Variable execute()
	{ 
		Scanner input = new Scanner(System.in);
		String s = input.next();
		if(s.charAt(0) == '"')
		{
			String subString = s.substring(1);
			return new Word(subString);
		}
		else if((s.charAt(0)>= '0' && s.charAt(0)<='9') || (s.charAt(0) == '-'))
			return new Number(s);
		else 
			System.out.println("wrong in read function");
		return null;
	}

}
