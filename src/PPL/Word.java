package PPL;

public class Word extends Variable{
	public String s;
	public Word(String input)
	{
		s = input;
	}
	@Override
	public void print()
	{
		System.out.print(s);
		System.out.print(" ");
	}
	@Override //hashcode function in word class return a address of object
    public int hashCode() {
        return s.hashCode();
    }
	@Override//
    public boolean equals(Object o){
        if (o instanceof String || o instanceof Word) return o.equals(s);
        return false;
    }
}
