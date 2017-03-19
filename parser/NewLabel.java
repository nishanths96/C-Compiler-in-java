package parser;

public class NewLabel {
	private static int labelNumber;
	private static int labelVal = 1;
	
	@Override
	public String toString(){
		return "Label"+labelNumber;
	}
	
	public NewLabel(){
		labelNumber = labelVal++;
	}
}
