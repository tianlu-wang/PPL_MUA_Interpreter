package PPL;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Save extends Function{
	public Save(Interpreter ip){
		super(ip);
	}
	public Variable execute()
	{ 
		FileWriter fw;
		try {
			fw = new FileWriter("namespace.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for(Word w : ip.MuaNameSpace.keySet())
			{
				bw.write(w.s + " ");
				Variable var = ip.MuaNameSpace.get(w);
				if(var instanceof Word)
				{
					bw.write(((Word)var).s);
					bw.newLine();
				}
				else if(var instanceof Number)
				{
					bw.write(((Number)var).a );
					bw.newLine();
				}
				else if(var instanceof MuaList)
				{
					bw.write(((MuaList)var).L.toString());
					bw.newLine();
				}
				else if(var instanceof MuaBool)
				{
					bw.write(((MuaBool)var).b + " ");
					bw.newLine();
				}
				else 
				    System.out.println("wrong content in namespace in save function");
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
