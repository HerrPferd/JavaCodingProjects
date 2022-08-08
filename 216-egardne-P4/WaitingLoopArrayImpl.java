import java.util.ArrayList;

public class WaitingLoopArrayImpl<Element> implements WaitingArrayInterface<Element> {
	public Element element;
	public int initialCapacity;
	public int entryIndex;
	public int exitIndex;
	public ArrayList<Element> loopArray;
	public WaitingLoopArrayImpl() {
		initialCapacity = 100;
		entryIndex = 99;
		exitIndex = 0;
		loopArray = new ArrayList<Element>(100);
		for(int x = 0; x < 100; x++) {
			loopArray.add(null);
		}
	}
	
	public WaitingLoopArrayImpl(int capacity) {
		initialCapacity = capacity;
		entryIndex = capacity - 1;
		exitIndex = 0;
		loopArray = new ArrayList<Element>(capacity);
		for(int x = 0; x < capacity; x++) {
			loopArray.add(null);
		}
	}
	
	public void add(Element element) {
		if((exitIndex - entryIndex == 2) || (entryIndex - exitIndex == (initialCapacity - 2))) {
			this.resizeCapacity();
		}
		entryIndex++;
		if(entryIndex >= initialCapacity) 
			entryIndex = 0;
		loopArray.set(entryIndex, element);
	}
	
	public void remove() throws EmptyWaitingArrayException{
		try {
			if((exitIndex == 0) && (entryIndex >= initialCapacity - 1)) {
				throw new EmptyWaitingArrayException();
			}
			loopArray.set(exitIndex, null);
			exitIndex++;
			if(exitIndex == initialCapacity)
				exitIndex = 0;
		}
		catch (Exception e) {
			throw new EmptyWaitingArrayException();
		}
	}
	
	public void clear() throws EmptyWaitingArrayException{
		if((entryIndex == initialCapacity - 1) && (exitIndex == 0))
			throw new EmptyWaitingArrayException();
		ArrayList<Element> out = new ArrayList<Element>(initialCapacity);
		loopArray = out;
	}
	
	public Element getFirst() throws EmptyWaitingArrayException{
		if(loopArray.get(exitIndex) == null)
			throw new EmptyWaitingArrayException();
		return loopArray.get(exitIndex);
	}
	
	public Element getLast() throws EmptyWaitingArrayException{
		if(loopArray.get(entryIndex) == null)
			throw new EmptyWaitingArrayException();
		return loopArray.get(entryIndex);
	}
	
	public boolean isEmpty() {
		int num = 0;
		for(Element e : loopArray) {
			if(e != null)
				num++;
		}
		if(num == 0)
			return true;
		return false;
	}
	
	public boolean isFull() {
		if((exitIndex - entryIndex == 2) || (entryIndex - exitIndex == (initialCapacity - 2))) {
			return true;
		}
		return false;
	}
	
	private void resizeCapacity() {
		if((exitIndex - entryIndex == 2) || (entryIndex - exitIndex == (initialCapacity - 2))) {
			ArrayList<Element> out = new ArrayList<Element>(initialCapacity * 2);
			for(int i = 0; i < initialCapacity; i++) {
				out.add(loopArray.get(i));
			}
			for(int o = initialCapacity; o < (initialCapacity * 2); o++)
				out.add(null);
			initialCapacity = initialCapacity * 2;
			loopArray = out;
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
		catch (Exception f){}
		out += "]";
		return out;
	}
}
