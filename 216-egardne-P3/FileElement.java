
public class FileElement implements FSElement {
	private String name;
	private String contents;
	
	public FileElement(String name, String contents) { //Constructor
		this.name = name;
		this.contents = contents;
	}
	
	public String name() {return name;} //Getter for name
	public void rename(String name) {this.name = name;} //Setter for name
	
	public void validate() throws Exception{ //Empty 
	}
	
	public void setContents(String contents) { //Setter for contents
		this.contents = contents;
	}
	
	public String toString() { //Overrides toString, returns contents
		return contents;
	}
}
