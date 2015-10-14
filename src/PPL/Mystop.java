package PPL;

public class Mystop extends Exception{
	Variable returnval;
	Mystop(Variable ret){
		returnval = ret;
	}
}
