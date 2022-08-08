import java.util.*;

public class StringIterable implements Iterable<Character>{
	public String input;
	
	public StringIterable(String input) {
		this.input = input;
	}
	
	public Iterator<Character> iterator() {
		return new StringIterator(input);
	}

}
