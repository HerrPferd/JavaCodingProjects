
public interface WaitingArrayInterface<Element/*extends ArrayList <T>*/> {
	
	void add(Element element);
	void remove() throws EmptyWaitingArrayException;
	void clear() throws EmptyWaitingArrayException;
	Element getFirst() throws EmptyWaitingArrayException;
	Element getLast() throws EmptyWaitingArrayException;
	public boolean isEmpty();
	public boolean isFull();
	public String toString();
}
