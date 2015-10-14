package PPL;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
	
	private static Scanner input;
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to MUA !!!");

		Interpreter MuaInterpreter = new Interpreter(null);
				
		while(true)
		{
			System.out.print("?");//remind the user to input command
			input = new Scanner(System.in);
			String[] commandLine = input.nextLine().split(" ");
			LinkedList<String> command = new LinkedList<String>();//command is a linkedlist to store the every part of command
			
			for(String s : commandLine)
			{
				command.add(s);
			}
			MuaInterpreter.AlterCommand( command );
			while(MuaInterpreter.command.size() != 0)
				MuaInterpreter.doInterpreter();
		}
	}
}
