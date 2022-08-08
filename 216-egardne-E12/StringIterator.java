import java.util.*;

public class StringIterator implements Iterator<Character>{
	private String input;
	private int pos;
		
	public StringIterator(String input) {
		this.input = input;
		this.pos = -1;
	}
	
	public boolean hasNext() {
		try {
			input.charAt(pos + 1);
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
	}
	
	public Character next(){
		if (!hasNext()) throw new NoSuchElementException();
		pos++;
		return input.charAt(pos);
	}
}
