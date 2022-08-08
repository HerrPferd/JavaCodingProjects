
public class IDFile extends FileElement {
	private IDInfo id;
	
	public IDFile(IDInfo id) { //initialized IDFile with syntax given in Project3.html
		super("ID.txt",	"Full Name: " + id.getName() + "\n" +
						"userID: " + id.getUserId() + "\n" +
						"G#: " + id.getGNum() + "\n" +
						"Lecture section: " + id.getLecture() + "\n" +
						"Lab section: " + id.getLab() + "\n");
		
		this.id = id;
	}
	
	public IDInfo getId() {return id;}
	public void setContents(String contents) {}
}
