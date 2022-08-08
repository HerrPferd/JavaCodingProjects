import java.util.*;

public class ThanosIterable<T> implements Iterable<List<T>>{
	public List<T> input;
	public ThanosIterable(List<T> input) {
		this.input = input;
	}

	public Iterator<List<T>> iterator() {
		return new ThanosIterator<T>(input);
	}
}
