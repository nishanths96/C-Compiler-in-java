package parser;

public class GenNewLabel {
	public static int labels=0;
	
	public static int generate(){
		return labels++;
	}
	
	@Override
	public String toString(){
		return "Label"+labels;
	}
}
