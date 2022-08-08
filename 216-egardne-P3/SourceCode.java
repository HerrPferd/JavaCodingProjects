
public class SourceCode extends FileElement {
	private String name;
	private String contents;
	
	public SourceCode(String name, String contents) {
		super(name, contents);
		this.name = name;
		this.contents = contents;
	}
	
	public String getType() {return name.substring(name.indexOf(".") + 1, name.length());} //finds type of file by creating substring following the first index of "." to the end of the name
	
	public void validate() throws Exception{ //determines if name - type appears n contents, throws exception if it does not
		if(this.getType().equals("java")) {
			String fileName = name.substring(0, this.name().indexOf("."));
			if(contents.indexOf(fileName) < 0) {
				throw new Exception("java source file missing class name: " + fileName);
			}
		}
	}
}