import java.util.ArrayList;

public class ChainFilter implements FSFilter {
	private ArrayList<FSFilter> filterList;
	
	public ChainFilter() {
		this.filterList = new ArrayList<FSFilter>(); //instantiates filterList as an ArrayList of FSFilters
	}
	
	public void add(FSFilter filter) { //Adds FSFilter filter to filterList
		filterList.add(filter);
	}
	
	public FSElement process(FSElement elem) throws Exception{ //iterates through filterList using each .process method with FSElement elem
		for(FSFilter e : filterList) {
			elem = e.process(elem);
		}
		return elem;
	}
}
