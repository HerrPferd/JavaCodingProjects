import java.util.*;

public class ThanosIterator<T> implements Iterator<List<T>>{

	private List<T> snap;
	private int pos;
	public ThanosIterator(List<T> snap) {
		this.snap = snap;
		pos = 0;
	}
	
	public static <T> List<T> halve(List<T> input){
		input = input.subList(0, input.size()/2);
		return input;
	}
	
	public List<T> halve(List<T> input, int times){
		if(times == 0)
			return input;
		if(times == 1)
			return ThanosIterator.halve(input);
		else
			return ThanosIterator.halve(this.halve(input, times - 1));
	}
	
	public boolean hasNext() {
		if(snap.size() <= 1)
			return false;
		return true;
	}
	
	public List<T> next(){
		if (!hasNext()) throw new NoSuchElementException();
		if(pos == 0) {
			pos++;
			return snap;
		}
		snap = ThanosIterator.halve(snap);
		return snap;
	}

}
