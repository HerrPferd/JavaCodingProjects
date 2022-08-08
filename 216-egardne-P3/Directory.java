import java.util.ArrayList;

public class Directory implements FSElement {
	private String name;
	private int depth;
	private ArrayList<FSElement> files;
	
	public Directory(String name, int depth) { //Constructor w name and depth
		this.name = name;
		this.depth = depth;
		files = new ArrayList<FSElement>();
	}
	public Directory(String name) { //Constructor w name only
		this.name = name;
		depth = 0;
		files = new ArrayList<FSElement>();
	}
	public Directory() { //Default constructor
		name = ".";
		depth = 0;
		files = new ArrayList<FSElement>();
	}
	
	//override
	public String name() {return name + "/";} //Getter for name, appends "/" to end of string
	public int getDepth() {return depth;} //Getter for depth
	public void rename(String name) {this.name = name;} //Setter for name
	public void setDepth(int depth) {this.depth = depth;} //Setter for depth
	public void add(FSElement elem) { //Adds element elem to directory, sets elem depth to depth+1 if elem is directory
		files.add(elem);
		if(elem instanceof Directory) {
			((Directory) elem).setDepth(this.depth + 1);
		}
	}
	public FSElement get(int i) {return files.get(i);} //Getter for FSElement at index i of files
	public FSElement remove(int i) {return files.remove(i);} //Removes FSElement at index i of files
	public boolean remove(FSElement elem) {return files.remove(elem);} //Removes FSElement elem from files
	public int numElements() {return files.size();} //Returns size of files
	public boolean isDefault() { //Determines if a directory is a default diretory
		if(this.name.equals("."))
			return true;
		return false;
	}
	public void validate() throws Exception{ //validates individual FSElements in files
		for(FSElement e: files) {
			e.validate();
		}
	}
	public String toString() { //Overrides toString, returns with syntax specified in Project3.html
		String out = "";
		for(FSElement e : files) {
			int x = depth;
			for(int i = 0; i <= x; i++) {
				out += "=";
			}
			if(e instanceof Directory) {
				x = ((Directory) e).getDepth();
				for(int i = 1; i < x; i++) {
					out += "=";
				}
			}
			out = out + "> " + e.name() + "\n"+ e.toString() + "\n";
		}
		return out;
	}
}