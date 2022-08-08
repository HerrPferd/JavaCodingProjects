import java.util.ArrayList;
public class VIPWaitingArrayImpl<Element extends Comparable<Element>> implements WaitingArrayInterface<Element> {
	public int initialCapacity; 
	public int entryIndex = -1;
	public ArrayList<Element> loopArray;
	
	public VIPWaitingArrayImpl() {
		initialCapacity = 100;
		loopArray = new ArrayList<Element>(100);
	}
	
	public VIPWaitingArrayImpl(int capacity) {
		initialCapacity = capacity;
		loopArray = new ArrayList<Element>(capacity);
	}
	
	public void add(Element element) {
		Boolean tempInd = false;
		if(this.isEmpty() == false) {
			for(int i = 0; i < loopArray.size(); i++) {
				if(loopArray.get(i).compareTo(element) >= 0) {
					entryIndex = i;
					tempInd = true;
					loopArray.add(entryIndex, element);
					break;
				}
			}
		}
		else if(this.isEmpty()){
			loopArray.add(element);
			entryIndex = 0;
			tempInd = true;
		}
		if(tempInd == false){
			entryIndex = loopArray.size() - 1;
			loopArray.add(element);
		}
	}
	
	public void remove() throws EmptyWaitingArrayException{
		if(entryIndex == -1)
			throw new EmptyWaitingArrayException();
		ArrayList<Element> out = new ArrayList<Element>(initialCapacity);
		for(int i = 1; i < loopArray.size(); i++) {
			out.add(i - 1, loopArray.get(i));
		}
		loopArray = out;
	}
	
	public void clear() throws EmptyWaitingArrayException{
		if(entryIndex == -1)
			throw new EmptyWaitingArrayException();
		ArrayList<Element> out = new ArrayList<Element>(initialCapacity);
		loopArray = out;
		entryIndex = -1;
	}
	
	public Element getFirst() throws EmptyWaitingArrayException{
		try {
			loopArray.get(0);
			if(entryIndex == -1)
			throw new EmptyWaitingArrayException();
		}
		catch (Exception e) {
			throw new EmptyWaitingArrayException();
		}
		return loopArray.get(0);
	}
	
	public Element getLast() throws EmptyWaitingArrayException{
		if(entryIndex == -1)
			throw new EmptyWaitingArrayException();
		return loopArray.get(loopArray.size() - 1);
	}
	
	public boolean isEmpty() {
		return entryIndex == -1 || loopArray.size() == 0;
	}
	public boolean isFull() {
		if(loopArray.size() == this.initialCapacity)
			return true;
		return false;
	}
	
	private void resizeCapacity() {
		if(this.isFull()) {
			for(int i = 0; i < initialCapacity; i++) {
				loopArray.add(initialCapacity + i, null);
			}
			initialCapacity = loopArray.size();
		}
	}
	
	public String toString() {
		String out = "[";
		try {
			out += loopArray.get(0).toString();
			for(int i = 1; i < initialCapacity; i++) {
				try {
					if(loopArray.get(i).toString().equals("null") == false) {
						out += ",";
						out += loopArray.get(i).toString();
					}
				}
				catch(Exception e) {
				}
			}
		}
		catch (Exception f){
		}
		out += "]";
		return out;
	}
}
/*comments are for fools. Only the wise know that the creation of complex and un-maintainable code will ensure
 * continued success in the realm of computer science*/
